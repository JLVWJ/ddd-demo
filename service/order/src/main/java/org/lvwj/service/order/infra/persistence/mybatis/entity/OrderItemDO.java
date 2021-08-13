package org.lvwj.service.order.infra.persistence.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单明细数据实体
 *
 * 商品快照字段 如果就几个，可以冗余到订单明细表里; 如果很多，可以新建一个订单明细的扩展表：商品快照表
 *
 * @author lvweijie
 * @date 2021-08-12 07:57
 */
@Data
@TableName("order_item")
public class OrderItemDO {

    private String id;
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
    //...
}
