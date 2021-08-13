package org.lvwj.service.order.outbound.adapter.client;

import lombok.RequiredArgsConstructor;
import org.lvwj.service.order.outbound.port.client.INumberApiClient;
import org.springframework.stereotype.Component;

/**
 * 调编号微服务的防腐层接口实现
 *
 * @author lvweijie
 * @date 2021-08-12 09:10
 */
@Component
@RequiredArgsConstructor
public class NumberApiClient implements INumberApiClient {

    //private final INumberFeign numberFeign; INumberFeign是编号微服务暴露的feign接口

    @Override
    public String generateOrderNo() {
        //String orderNo = numberFeign.generateOrderNo();
        return null;
    }
}
