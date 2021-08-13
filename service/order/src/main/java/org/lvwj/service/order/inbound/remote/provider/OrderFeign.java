package org.lvwj.service.order.inbound.remote.provider;

import lombok.RequiredArgsConstructor;
import org.lvwj.service.order.api.dto.OrderDTO;
import org.lvwj.service.order.api.dto.cmd.CreateOrderCmd;
import org.lvwj.service.order.api.provider.IOrderFeign;
import org.lvwj.service.order.inbound.local.service.command.OrderCmdService;
import org.lvwj.service.order.inbound.local.service.query.OrderQryService;
import org.springframework.stereotype.Component;

/**
 * 提供者接口实现(北网关适配器)：调CQ端应用服务层的业务用例方法
 *
 * @author lvweijie
 * @date 2021-08-12 08:48
 */
@Component
@RequiredArgsConstructor
public class OrderFeign implements IOrderFeign {

    private final OrderQryService orderQryService;
    private final OrderCmdService orderCmdService;

    @Override
    public OrderDTO getOrder(String orderId) {
        return orderQryService.getOrder(orderId);
    }

    @Override
    public Boolean saveOrder(CreateOrderCmd cmd) {
        return orderCmdService.saveOrder(cmd);
    }
}
