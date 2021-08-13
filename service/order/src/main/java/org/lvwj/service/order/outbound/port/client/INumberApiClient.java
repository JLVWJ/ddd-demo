package org.lvwj.service.order.outbound.port.client;

/**
 * 调编号微服务的防腐层接口
 *
 * @author lvweijie
 * @date 2021-08-12 09:10
 */
public interface INumberApiClient {

    /**
     * 生成订单编号
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/12 14:01
     */
    String generateOrderNo();
}
