package org.lvwj.service.order.outbound.adapter.client;

import lombok.RequiredArgsConstructor;
import org.lvwj.common.domain.primitive.Money;
import org.lvwj.service.order.domain.valobj.ProductSnapShot;
import org.lvwj.service.order.outbound.port.client.IProductApiClient;
import org.lvwj.service.product.api.dto.ProductDTO;
import org.lvwj.service.product.api.provider.IProductFeign;
import org.springframework.stereotype.Component;

/**
 * 调用商品微服务的防腐层(ACL)接口实现
 *
 * 南网关适配器：用适配器模式，包装商品微服务暴露的feign接口(IProductFeign),
 *   如果是给C端应用服务或领域服务用的，可以把feign接口返回的DTO(ProductDTO)转成当前微服务的领域层对象(ProductSnapShot)作为返回值。
 *   如果是给Q端应用服务用的，可以把feign接口返回的DTO(ProductDTO)转成自定义DTO(例如:ProductSnapShotDTO)作为返回值
 *
 * @author lvweijie
 * @date 2021-08-12 08:57
 */
@Component
@RequiredArgsConstructor
public class ProductApiClient implements IProductApiClient {

    private final IProductFeign productFeign;

    @Override
    public ProductSnapShot getProductSnapShot(String productId) {
        ProductDTO productDTO = productFeign.getProduct(productId);
        final Money purchasePrice = Money.create(productDTO.getPurchasePrice());
        final Money indicativePrice = Money.create(productDTO.getIndicativePrice());
        final ProductSnapShot ps = ProductSnapShot.create(productId, productDTO.getProductCode(), productDTO.getProductName(), purchasePrice, indicativePrice);
        return ps;
    }
}
