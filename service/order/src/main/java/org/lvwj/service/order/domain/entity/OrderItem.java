package org.lvwj.service.order.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.lvwj.common.domain.BaseEntity;
import org.lvwj.service.order.domain.valobj.ProductSnapShot;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 订单明细(订单聚合根的子实体)
 *
 * @author lvweijie
 * @date 2021/8/12 14:18
 */
@Builder
@Getter
@ToString(callSuper = true)
public class OrderItem extends BaseEntity<String> {
    /**
     * 订单明细数量
     *
     * @author lvweijie
     * @date 2021/8/11 23:13
     */
    private Integer num;

    private String orderId;

    /**
     * 订单明细的商品快照
     *
     * @author lvweijie
     * @date 2021/8/11 23:13
     */
    private ProductSnapShot productSnapShot;

    /**
     * 外部只通过create来构建订单明细对象，不要自己写OrderItem.builder().num(num).productSnapShot(productSnapShot).build();
     * 这样做是为了构建对象的数据完整性，自己写builder会遗漏赋值。
     * 如果要加必要的初始化参数，可以方法重载，也就是再建个create静态方法
     * @param num
     * @param productSnapShot
     * @return org.lvwj.service.order.domain.entity.OrderItem
     * @author lvweijie
     * @date 2021/8/13 9:04
     */
    public static OrderItem create(Integer num, ProductSnapShot productSnapShot) {
        return OrderItem.builder().num(num).productSnapShot(productSnapShot).build();
    }

    /**
     * 当需要加参数时，如果直接改原来的create没影响，那就直接改；如果有影响，那就再建个create
     *
     * @param num
     * @param orderId
     * @param productSnapShot
     * @return org.lvwj.service.order.domain.entity.OrderItem
     * @author lvweijie
     * @date 2021/8/13 9:08
     */
    public static OrderItem create(Integer num,String orderId, ProductSnapShot productSnapShot) {
        return OrderItem.builder().num(num).orderId(orderId).productSnapShot(productSnapShot).build();
    }

    /**
     * 订单明细金额 = 明细数量 x 商品指导价
     *
     * @param
     * @return java.math.BigDecimal
     * @author lvweijie
     * @date 2021/8/11 23:18
     */
    public BigDecimal amount() {
        return productSnapShot.getIndicativePrice().multiply(new BigDecimal(num)).setScale(2, RoundingMode.HALF_UP);
    }

}
