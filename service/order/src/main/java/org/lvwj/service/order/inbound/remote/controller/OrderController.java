package org.lvwj.service.order.inbound.remote.controller;

import lombok.RequiredArgsConstructor;
import org.lvwj.service.order.inbound.local.service.command.OrderCmdService;
import org.lvwj.service.order.inbound.local.service.query.OrderQryService;

/**
 * 控制器(北网关适配器)：调CQ端应用服务层的业务用例方法
 * @author lvweijie
 * @date 2021-08-12 08:47
 */
@RequiredArgsConstructor
public class OrderController {
    private final OrderCmdService orderCmdService;
    private final OrderQryService orderQryService;


}
