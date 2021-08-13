package org.lvwj.service.order.inbound.local.service.command;

import lombok.RequiredArgsConstructor;
import org.lvwj.common.util.SpringUtil;
import org.lvwj.service.order.api.dto.cmd.CreateOrderCmd;
import org.lvwj.service.order.domain.entity.Order;
import org.lvwj.service.order.domain.entity.OrderItem;
import org.lvwj.service.order.domain.event.OrderCreatedEvent;
import org.lvwj.service.order.domain.valobj.*;
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
 * 2.做为领域层的门面(Facade)，负责组合编排领域层对象的业务方法，完成一个完整的业务用例
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

    /**
     * 保存订单(创建or更新)
     *
     * @param cmd
     * @return java.lang.Boolean
     * @author lvweijie
     * @date 2021/8/12 9:23
     */
    public Boolean saveOrder(CreateOrderCmd cmd) {
        String orderNo = numberApiClient.generateOrderNo();
        Boolean isExist = orderRepository.checkOrderNoIsExist(orderNo);
        if (!isExist) {
            //throw new
        }
        //region 用请求命令DTO(CreateOrderCmd)来组装领域层对象(Order、OrderItem)
        OrderStatus status = OrderStatus.CREATED;
        final Province province = Province.builder().code("123").name("福建省").build();
        final City city = City.builder().code("456").name("厦门市").build();
        final County county = County.builder().code("789").name("集美区").build();
        Address address = Address.builder().province(province).city(city).county(county).detail("孙坂北路801号402室").build();
        final Name name = Name.builder().value("吕伟杰").build();
        final Phone phone = Phone.builder().value("15359450827").build();
        final Person person = Person.builder().name(name).phone(phone).build();
        final Contract contract = Contract.builder().id("123456").code("23456789").contractor(person).createTime(LocalDateTime.now()).build();

        ProductSnapShot ps = productApiClient.getProductSnapShot("123");
        OrderItem orderItem = OrderItem.create(2, ps);
        final Set<OrderItem> orderItems = new HashSet<>();
        orderItems.add(orderItem);
        Order order = Order.create(orderNo, status, address, person, contract, orderItems);

        //endregion

        //调仓储接口 持久化领域对象
        Boolean result = orderRepository.saveOrder(order);
        //创建订单之后，发布领域事件，订阅者如果是当前进程内的 可以用SpringUtil.publishEvent，当前微服务的其他聚合来消费
        //如果是跨进程的，可以用RabbitMQ发送，其他微服务来消费，比如库存微服务、支付微服务、消息通知微服务等
        if (null == cmd.getOrderId()) {
            //1.SpringUtil.publishEvent(OrderCreatedEvent);
            //2.RabbitMQ发送
        }
        return result;
    }
}
