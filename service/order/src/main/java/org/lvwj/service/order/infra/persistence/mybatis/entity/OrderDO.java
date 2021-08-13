package org.lvwj.service.order.infra.persistence.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * 订单数据实体
 * 1. @TableField(exist = false) private List<OrderItemDO> orderItems
 *  这样是因为转换器支持深拷贝，OrderDO的集合字段 或 对象字段都可以自动set
 *
 * @author lvweijie
 * @date 2021-08-12 07:57
 */
@Data
@TableName("order")
public class OrderDO {
    private String id;
    private String orderNo;
    private String status;
    private String provinceName;
    private String provinceCode;
    private String collectPersonName;
    private String collectPersonPhone;
    private String contractId;
    private String contractCode;

    @TableField(exist = false)
    private List<OrderItemDO> orderItems;

    //......
}
