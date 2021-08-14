package org.lvwj.service.order.inbound.remote.controller;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.RequiredArgsConstructor;
import org.lvwj.service.order.api.dto.OrderDTO;
import org.lvwj.service.order.api.dto.cmd.SaveOrderCmd;
import org.lvwj.service.order.inbound.local.service.command.OrderCmdService;
import org.lvwj.service.order.inbound.local.service.query.OrderQryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * 控制器(北网关适配器)：调CQ端应用服务层的业务用例方法
 * @author lvweijie
 * @date 2021-08-12 08:47
 */
@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderCmdService orderCmdService;
    private final OrderQryService orderQryService;

    @PostMapping(value = "/save")
    public R<Boolean> saveOrder(@Valid @RequestBody SaveOrderCmd cmd) {
        return R.ok(orderCmdService.saveOrder(cmd));
    }

    @GetMapping(value = "/get")
    public R<OrderDTO> saveOrder(@NotBlank(message = "订单id不能为空!") @RequestParam String id) {
        return R.ok(orderQryService.getOrder(id));
    }
}
