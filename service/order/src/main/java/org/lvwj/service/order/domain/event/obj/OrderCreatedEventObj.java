package org.lvwj.service.order.domain.event.obj;

import lombok.Value;

/**
 * 订单已创建领域事件的事件源(source)
 *
 *
 * @author lvweijie
 * @date 2021-08-12 15:52
 */
@Value(staticConstructor = "of")
public class OrderCreatedEventObj{

     String orderId;
     String orderNo;
}
