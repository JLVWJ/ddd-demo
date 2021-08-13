package org.lvwj.service.product.api.provider;

import org.lvwj.service.product.api.dto.ProductDTO;

/**
 *
 * @author lvweijie
 * @date 2021-08-12 08:59
 */
public interface IProductFeign {
    ProductDTO getProduct(String productId);
}
