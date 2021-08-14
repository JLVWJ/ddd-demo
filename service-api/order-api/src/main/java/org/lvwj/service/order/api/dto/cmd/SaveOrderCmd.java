package org.lvwj.service.order.api.dto.cmd;

import lombok.Data;
import org.lvwj.service.order.api.dto.OrderDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 命令请求DTO
 *
 * @author lvweijie
 * @date 2021-08-12 08:16
 */
@Data
public class SaveOrderCmd {

    //...其它字段

    @Valid
    @NotNull(message = "订单信息不能为null!")
    private OrderDTO orderDTO;
    
    //...其它字段
}
