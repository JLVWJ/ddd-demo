package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.lvwj.common.domain.primitive.Money;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * 商品快照
 *
 * @author lvweijie
 * @date 2021-08-11 23:11
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class ProductSnapShot {
    String productId;
    String productCode;
    String productName;
    /**
     * 商品采购价
     *
     * @author lvweijie
     * @date 2021/8/11 23:15
     */
    Money purchasePrice;
    /**
     * 商品指导价
     *
     * @author lvweijie
     * @date 2021/8/11 23:15
     */
    Money indicativePrice;


    public static ProductSnapShot create(String productId, String productCode, String productName, Money purchasePrice, Money indicativePrice) {
        return ProductSnapShot.builder().productId(productId).productCode(productCode).productName(productName).purchasePrice(purchasePrice).indicativePrice(indicativePrice).build();
    }


    /**
     * 优惠/加价金额
     *
     * @param
     * @return java.math.BigDecimal
     * @author lvweijie
     * @date 2021/8/13 14:43
     */
    public Money discountPrice() {
        try {
            return indicativePrice.subtract(purchasePrice);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 优惠类型
     *
     * @param
     * @return org.lvwj.service.order.domain.valobj.DiscountType
     * @author lvweijie
     * @date 2021/8/13 14:43
     */
    public DiscountType discountType() {
        final Money money = discountPrice();
        if (null == money) {
            return DiscountType.NONE;
        }
        if (money.getValue().compareTo(BigDecimal.ZERO) > 0) {
            return DiscountType.SUBTRACT;
        } else if (money.getValue().compareTo(BigDecimal.ZERO) < 0) {
            return DiscountType.ADD;
        } else {
            return DiscountType.NONE;
        }
    }
}
