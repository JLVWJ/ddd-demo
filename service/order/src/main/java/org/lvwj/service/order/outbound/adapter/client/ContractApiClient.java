package org.lvwj.service.order.outbound.adapter.client;

import org.lvwj.service.order.domain.valobj.Contract;
import org.lvwj.service.order.outbound.port.client.IContractApiClient;

/**
 * @author lvweijie
 * @date 2021-08-13 16:18
 */
public class ContractApiClient implements IContractApiClient {

    //private IContractFeign contractFeign;

    @Override
    public Contract getContract(String orderId) {
        //contractFeign.getXXX(orderId)
        return null;
    }
}
