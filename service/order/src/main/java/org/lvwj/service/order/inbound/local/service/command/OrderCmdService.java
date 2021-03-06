package org.lvwj.service.order.inbound.local.service.command;

import lombok.RequiredArgsConstructor;
import org.lvwj.service.order.api.dto.cmd.SaveOrderCmd;
import org.lvwj.service.order.domain.entity.Order;
import org.lvwj.service.order.domain.entity.OrderItem;
import org.lvwj.service.order.domain.valobj.*;
import org.lvwj.service.order.infra.converter.OrderConverter;
import org.lvwj.service.order.outbound.port.client.IContractApiClient;
import org.lvwj.service.order.outbound.port.client.INumberApiClient;
import org.lvwj.service.order.outbound.port.client.IProductApiClient;
import org.lvwj.service.order.outbound.port.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * C端应用服务-订单命令服务(增删改)
 *
 * 1.一个方法就是一个业务用例
 * 2.做为领域层的门面(Facade)，负责组合编排领域层对象的业务方法，或调其它微服务的apiClient, 来完成一个完整的业务用例
 * 3.调用其它微服务获取部分字段，来进行业务校验或组装成值对象，然后调仓储接口持久化到数据库
 * 4.可以用spring.data.redis方法注解来清除缓存
 * 5.这里OrderCmdService类没有接口，因为接口可有可无，都行。
 *
 * @author lvweijie
 * @date 2021-08-12 08:01
 */
@Service
@RequiredArgsConstructor
public class OrderCmdService {

    private final IProductApiClient productApiClient;
    private final INumberApiClient numberApiClient;
    private final IContractApiClient contractApiClient;

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    /**
     * 保存订单(创建or更新)
     *
     * 说明：以下简单演示了保存订单业务用例的5个步骤
     *
     * @param cmd
     * @return java.lang.Boolean
     * @author lvweijie
     * @date 2021/8/12 9:23
     */
    public Boolean saveOrder(SaveOrderCmd cmd) {
        //1.业务校验。 数据校验可以在CreateOrderCmd字段上用Bean Validation注解
        String orderNo = numberApiClient.generateOrderNo();
        Boolean isExist = orderRepository.checkOrderNoIsExist(orderNo);
        if (isExist) {
            //throw new
        }

        //region 2.用请求命令DTO(CreateOrderCmd)来组装领域层对象(Order、OrderItem)
        //2.0 手写set 或 用转换器
        //2.1 手写set
        OrderStatus status = OrderStatus.CREATED;
        final Province province = Province.create("123","福建省");
        final City city = City.create("456","厦门市");
        final County county = County.create("789","集美区");
        Address address = Address.create(province,city,county,"xxx号xxx室");
        final Name name = Name.create("lwj");
        final Phone phone = Phone.create("155555555");
        final Person person = Person.create(name,phone);
        final Contract contract = Contract.create("111","222",person,LocalDateTime.now());

        ProductSnapShot ps = productApiClient.getProductSnapShot("123");
        OrderItem orderItem = OrderItem.create(2, ps);
        final Set<OrderItem> orderItems = new HashSet<>();
        orderItems.add(orderItem);
        Order order = Order.create(orderNo, status, address, person, contract, orderItems);

        //2.2 用转换器
        final Order order1 = orderConverter.orderDtoToOrder(cmd.getOrder());
        //endregion

        //3.调Order领域对象内部的逻辑方法，来进行逻辑处理...

        //4.调仓储接口持久化领域对象
        Boolean result = orderRepository.saveOrder(order);

        //5.创建订单之后，发布领域事件，订阅者如果是当前进程内的 可以用SpringUtil.publishEvent，当前微服务的其他聚合来消费
        //  如果是跨进程的，可以用RabbitMQ发送，其他微服务来消费，比如库存微服务、支付微服务、消息通知微服务等
        if (null == cmd.getOrder().getId()) {
            //5.1 SpringUtil.publishEvent(OrderCreatedEvent);
            //5.2 RabbitMQ发送
        }
        return result;
    }
}
