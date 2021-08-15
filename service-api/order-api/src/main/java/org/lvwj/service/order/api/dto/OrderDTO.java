package org.lvwj.service.order.api.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lvweijie
 * @date 2021-08-12 08:16
 */
@Data
public class OrderDTO {

    private String id;
    private String orderNo;
    private String status;
    private String provinceName;
    private String provinceCode;
    private String collectPersonName;
    private String collectPersonPhone;
    private String contractId;
    private String contractCode;
    private List<OrderItemDTO> orderItems;
}
