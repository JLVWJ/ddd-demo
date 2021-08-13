package org.lvwj.service.order.outbound.port.client;

import org.lvwj.service.order.domain.valobj.Contract;

/**
 * @author lvweijie
 * @date 2021-08-13 16:16
 */
public interface IContractApiClient {

    Contract getContract(String orderId);
}
