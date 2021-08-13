package org.lvwj.service.product.api.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * @author lvweijie
 * @date 2021-08-12 08:59
 */
@Data
public class ProductDTO {
    private String productId;
    private String productName;
    private String productCode;
    private BigDecimal indicativePrice;;
    private BigDecimal purchasePrice;
}
