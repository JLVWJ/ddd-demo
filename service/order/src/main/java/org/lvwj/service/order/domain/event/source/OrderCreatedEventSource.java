package org.lvwj.service.order.domain.event.source;

import lombok.*;
import org.lvwj.common.domain.BaseEventSource;

/**
 * 订单已创建领域事件的事件源
 *
 *
 * @author lvweijie
 * @date 2021-08-12 15:52
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class OrderCreatedEventSource implements BaseEventSource {

     String orderId;
     String orderNo;
}
