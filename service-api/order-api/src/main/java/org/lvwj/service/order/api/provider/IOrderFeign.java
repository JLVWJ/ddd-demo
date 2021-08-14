package org.lvwj.service.order.api.provider;

import org.lvwj.service.order.api.dto.OrderDTO;
import org.lvwj.service.order.api.dto.cmd.SaveOrderCmd;

/**
 * 对外暴露的feign接口
 *
 * @author lvweijie
 * @date 2021-08-12 08:48
 */
public interface IOrderFeign {

    OrderDTO getOrder(String orderId);

    Boolean saveOrder(SaveOrderCmd cmd);
}
