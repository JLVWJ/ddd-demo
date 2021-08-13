package org.lvwj.service.order.outbound.port.repository;

import org.lvwj.service.order.domain.entity.Order;

import java.util.Optional;

/**
 * 订单仓储接口
 *
 * @author lvweijie
 * @date 2021-08-11 23:42
 */
public interface OrderRepository {

    Optional<Order> getOrder(String id);

    Boolean saveOrder(Order order);

    Boolean checkOrderNoIsExist(String orderNo);
}
