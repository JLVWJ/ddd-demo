package org.lvwj.service.order.domain.service;

import lombok.RequiredArgsConstructor;
import org.lvwj.service.order.domain.entity.Order;
import org.lvwj.service.order.domain.valobj.Contract;
import org.lvwj.service.order.outbound.port.client.IContractApiClient;
import org.lvwj.service.order.outbound.port.repository.OrderRepository;
import org.springframework.stereotype.Service;

/**
 * 订单变更合同服务(领域服务)
 *
 * 0.类名/方法名按业务逻辑命名，一个类一个方法对应一个领域服务
 * 1.领域服务是一个涉及多个领域对象的业务行为方法。
 * 2.区别于应用服务，应用服务是一个完整的业务用例，而领域服务只是应用服务中的一个业务流程，粒度不一样。
 * 3.领域服务可以调外部服务接口(contractApiClient)和仓储接口(orderRepository)
 *
 * @author lvweijie
 * @date 2021-08-13 16:11
 */
@Service
@RequiredArgsConstructor
public class OrderChangeContractService {

    //调外部服务
    private final IContractApiClient contractApiClient;
    private final OrderRepository orderRepository;

    /**
     * 变更合同
     *
     * @param order
     * @return void
     * @author lvweijie
     * @date 2021/8/13 16:22
     */
    public Boolean changeContract(Order order) {
        final Contract contract = contractApiClient.getContract(order.getId());
        if (null == contract) {

        }
        order.changeContract(contract);
        return orderRepository.saveOrder(order);
    }
}
