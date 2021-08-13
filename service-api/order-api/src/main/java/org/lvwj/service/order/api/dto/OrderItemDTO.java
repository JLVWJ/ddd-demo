package org.lvwj.service.order.api.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * @author lvweijie
 * @date 2021-08-12 08:22
 */
@Data
public class OrderItemDTO {

    private Integer num;
    private String orderId;
    private String productId;
    private String productCode;
    private String productName;
    /**
     * 商品采购价
     * @author lvweijie
     * @date 2021/8/11 23:15
     */
    private BigDecimal purchasePrice;
    /**
     * 商品指导价
     * @author lvweijie
     * @date 2021/8/11 23:15
     */
    private BigDecimal indicativePrice;
}
