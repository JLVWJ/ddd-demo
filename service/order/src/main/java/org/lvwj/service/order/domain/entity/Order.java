package org.lvwj.service.order.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.lvwj.common.domain.BaseAggregate;
import org.lvwj.service.order.domain.valobj.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * 订单(聚合根)
 *
 * 1.@Builder建造者模式是没有set方法的，DDD不推荐用setXXX来修改字段，因为这个操作没有业务含义，别人看了，不知道这是什么业务逻辑？
 *   推荐通过自定义业务行为方法来驱使字段的变更，而且可以复用，例如:orderPayed(修改订单状态为已支付并添加支付时间),orderFinished(修改订单状态为已完成并添加完成时间)
 * 2.注意看实体和值对象的lombok注解之间的区别，值对象多了@@EqualsAndHashCode. 因为实体通过基类的id来确定唯一标识，而值对象是全字段来确定唯一性。
 * 3.构建对象有俩种方式：
 *   3.1 字段少、简单的实体，可以直接在实体内，创建create来构建实体对象,入参只需初始化就有的字段，比如payTime、finishTime初始化就是null不需要作为入参。
 *   3.2 字段多，复杂的实体，可以新建Factory类，来构建实体对象。
 * 4.DDD推荐把实体的所有基础类型字段尽可能的建模成值对象(例：String orderNo -> OrderNo orderNo, String id -> OrderId id)
 *
 * @author lvweijie
 * @date 2021/8/12 14:17
 */
@Builder
@Getter
@ToString(callSuper = true)
public class Order extends BaseAggregate<String> {
    /**
     * 订单编号
     *
     * @author lvweijie
     * @date 2021/8/11 21:38
     */
    private String orderNo;

    /**
     * 订单状态
     *
     * @author lvweijie
     * @date 2021/8/11 23:01
     */
    private OrderStatus status;

    /**
     * 收货地址
     *
     * @author lvweijie
     * @date 2021/8/11 21:39
     */
    private Address collectAddress;

    /**
     * 收货人
     *
     * @author lvweijie
     * @date 2021/8/11 22:50
     */
    private Person collectPerson;

    /**
     * 订单合同
     *
     * @author lvweijie
     * @date 2021/8/11 21:40
     */
    private Contract contract;

    /**
     * 订单明细
     *
     * @author lvweijie
     * @date 2021/8/11 22:54
     */
    private Set<OrderItem> orderItems;

    /**
     * 修改时间
     *
     * @author lvweijie
     * @date 2021/8/11 23:06
     */
    private LocalDateTime updateTime;

    /**
     * 订单支付时间
     *
     * @author lvweijie
     * @date 2021/8/11 23:06
     */
    private LocalDateTime payTime;

    /**
     * 订单完成时间
     *
     * @author lvweijie
     * @date 2021/8/11 23:07
     */
    private LocalDateTime finishTime;

    /**
     * 创建订单
     * <p>
     * 1.字段少、简单的实体，可以直接在实体内，创建create来构建实体对象,入参只需初始化就有的字段，比如payTime、finishTime初始化就是null不需要作为入参。
     * 2.字段多，复杂的实体，可以新建Factory类，来构建实体对象。
     *
     * @param orderNo
     * @param status
     * @param collectAddress
     * @param collectPerson
     * @param contract
     * @return org.lvwj.service.order.domain.entity.Order
     * @author lvweijie
     * @date 2021/8/11 22:52
     */
    public static Order create(String orderNo, OrderStatus status, Address collectAddress, Person collectPerson, Contract contract,Set<OrderItem> orderItems) {
        return Order.builder().orderNo(orderNo).status(status).collectAddress(collectAddress).collectPerson(collectPerson).contract(contract).orderItems(orderItems).build();
    }

    /**
     * 添加订单明细
     *
     * @param orderItem
     * @return java.lang.Boolean
     * @author lvweijie
     * @date 2021/8/11 22:55
     */
    public Boolean addOrderItem(OrderItem orderItem) {
        if (null == orderItems) {
            orderItems = new HashSet<>();
        }
        return orderItems.add(orderItem);
    }

    /**
     * 订单已支付
     *
     * @param
     * @return void
     * @author lvweijie
     * @date 2021/8/11 23:03
     */
    public void orderPayed() {
        this.status = OrderStatus.PAYED;
        this.payTime = LocalDateTime.now();
    }

    /**
     * 订单已完成
     *
     * @param
     * @return void
     * @author lvweijie
     * @date 2021/8/11 23:04
     */
    public void orderFinished() {
        this.status = OrderStatus.FINISHED;
        this.finishTime = LocalDateTime.now();
    }

    /**
     * 变更合同
     *
     * @param contract
     * @return void
     * @author lvweijie
     * @date 2021/8/13 16:20
     */
    public void changeContract(Contract contract) {
       this.contract = contract;
       this.updateTime = LocalDateTime.now();
    }

    /**
     * 订单总额 = 订单明细金额累加
     *
     * @param
     * @return java.math.BigDecimal
     * @author lvweijie
     * @date 2021/8/11 23:29
     */
    public BigDecimal totalAmount(){
        return Optional.ofNullable(orderItems).orElse(new HashSet<>()).stream().map(OrderItem::amount).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    /**
     * 订单总数量 = 订单明细数量累加
     *
     * @param
     * @return java.lang.Integer
     * @author lvweijie
     * @date 2021/8/11 23:30
     */
    public Integer totalNum(){
        return Optional.ofNullable(orderItems).orElse(new HashSet<>()).stream().mapToInt(OrderItem::getNum).sum();
    }
}
