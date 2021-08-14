package org.lvwj.service.order.outbound.adapter.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.lvwj.service.order.domain.entity.Order;
import org.lvwj.service.order.infra.converter.OrderConverter;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderDO;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderItemDO;
import org.lvwj.service.order.infra.persistence.mybatis.mapper.OrderItemMapper;
import org.lvwj.service.order.infra.persistence.mybatis.mapper.OrderMapper;
import org.lvwj.service.order.outbound.port.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 仓储接口实现
 *
 * 0.明确一点：CQ分离之后，仓储是给C端应用服务用的，或者是领域层的领域服务
 * 1.一个聚合对应一个仓储接口，
 *   聚合内所有领域对象的字段(实体和值对象)，统一由仓储来管理。不可能存在部分字段，需要在仓储里调apiClient去其它微服务获取的情况。
 * 2.仓储的查询方法和Q端的查询方法的区别：要搞清楚仓储和Q端应用服务的职责
 *   2.1 仓储的查询方法用于构建完整的Order聚合根(例：getOrder) 或 给C端应用服务或领域服务的业务逻辑使用，比如：业务校验、更新订单等
 *       或者类似checkOrderNoIsExist，判断字段是否已存在。
 *   2.2 Q端的查询方法是直接调基础设施层的持久化框架接口，组装DTO并返回给前端，可能DTO部分字段需要调其他微服务feign接口(ApiClient)来获取
 * 3.仓储不应该依赖注入调其他微服务feign接口(ApiClient)
 * 4.仓储方法命名 要有业务语意，不要随意命名，应用服务方法命名也是一样
 * 5.可以用spring.data.redis注解方式 来加缓存和清理缓存
 *
 * @author lvweijie
 * @date 2021-08-11 23:45
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final OrderConverter orderConverter;

    /**
     * 查询订单(通过数据库来构建完整的Order聚合根)
     *
     * @param id
     * @return Optional<Order> 返回结果最好用Optional包装一下，提醒调用方处理空指针，Mapper的自定义查询接口同理
     * @author lvweijie
     * @date 2021/8/12 9:28
     */
    @Override
    public Optional<Order> getOrder(String id) {
        OrderDO orderDO = orderMapper.selectById(id);
        List<OrderItemDO> orderItemDOS = orderItemMapper.listByOrderId(id);
        orderDO.setOrderItems(orderItemDOS);
        final Order order = orderConverter.toOrder(orderDO);
        return Optional.ofNullable(order);
    }

    /**
     * saveOrder保存订单就已经涵盖了创建或更新，方法名不要写成saveOrUpdate或createOrUpdate, 这些命名是持久化框架的概念，不是DDD的业务方法命名
     *
     * @param order
     * @return java.lang.Boolean
     * @author lvweijie
     * @date 2021/8/12 15:04
     */
    @Override
    public Boolean saveOrder(Order order) {
        final String orderId = order.getId();
        final OrderDO orderDO = orderConverter.toOrderDO(order);
        final List<OrderItemDO> orderItems = orderDO.getOrderItems();
        if (null == orderId) {
            orderMapper.insert(orderDO);
        } else {
            orderMapper.updateById(orderDO);
            orderItemMapper.delete(Wrappers.lambdaQuery(OrderItemDO.class).eq(OrderItemDO::getOrderId, orderId));
        }
        orderItems.forEach(orderItemMapper::insert);
        return true;
    }

    /**
     * 仓储方法命名 要有业务语意，不要随意命名
     *
     * @param orderNo
     * @return java.lang.Boolean
     * @author lvweijie
     * @date 2021/8/12 15:07
     */
    @Override
    public Boolean checkOrderNoIsExist(String orderNo) {
        return orderMapper.checkOrderNoIsExist(orderNo);
    }
}
