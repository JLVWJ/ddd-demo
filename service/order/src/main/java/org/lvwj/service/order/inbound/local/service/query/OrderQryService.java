package org.lvwj.service.order.inbound.local.service.query;

import lombok.RequiredArgsConstructor;
import org.lvwj.service.order.api.dto.OrderDTO;
import org.lvwj.service.order.infra.converter.OrderConverter;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderDO;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderItemDO;
import org.lvwj.service.order.infra.persistence.mybatis.mapper.OrderItemMapper;
import org.lvwj.service.order.infra.persistence.mybatis.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Q端应用服务-订单查询服务(查)
 *
 * 1.Q端就跟原来的service类的查询接口一样，通过调mapper接口，返回前端要的DTO
 * 2.直接调基础设施层(infra)的持久化框架接口(例如mybatis的mapper接口)，查询前端需要的DTO，不需要经过领域层，也不需要调仓储接口。
 * 3.可以用spring.data.redis方法注解来加查询缓存
 * 4.如果返给前端的DTO的部分字段在当前微服务的数据实体中不存在，那就需要调其它微服务feign接口来获取(IProductApiClient)
 * 5.这里OrderQryService类没有接口，因为接口可有可无，都行。
 *
 * @author lvweijie
 * @date 2021-08-12 07:59
 */
@Service
@RequiredArgsConstructor
public class OrderQryService {

    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    //private final IProductApiClient productApiClient;

    /**
     * 数据转换器
     */
    private final OrderConverter orderConverter;

    /**
     * 通过订单ID获取订单及明细信息
     *
     * @param id
     * @return org.lvwj.service.order.api.dto.OrderDTO
     * @author lvweijie
     * @date 2021/8/12 8:22
     */
    public OrderDTO getOrder(String id) {
        final OrderDO orderDO = orderMapper.selectById(id);
        final List<OrderItemDO> orderItemDOS = orderItemMapper.listByOrderId(id);
        orderDO.setOrderItems(orderItemDOS);
        /* DTO部分字段需要调其它微服务来获取
        XX xx = productApiClient.getXXX();
        orderDO.set(xx);
        */
        return orderConverter.orderDoToOrderDTO(orderDO);
    }
}
