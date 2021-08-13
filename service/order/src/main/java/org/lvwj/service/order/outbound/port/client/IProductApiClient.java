package org.lvwj.service.order.outbound.port.client;

import org.lvwj.service.order.domain.valobj.ProductSnapShot;

/**
 * 调商品微服务的防腐层(ACL)接口
 *
 * @author lvweijie
 * @date 2021-08-12 08:56
 */
public interface IProductApiClient {

     /**
      * 获取商品快照信息
      *
      * @param productId
      * @return org.lvwj.service.order.domain.valobj.ProductSnapShot
      * @author lvweijie
      * @date 2021/8/12 13:59
      */
     ProductSnapShot getProductSnapShot(String productId);
}
