package org.lvwj.service.order.domain.event;

import org.lvwj.common.domain.BaseEvent;
import org.lvwj.service.order.domain.event.source.OrderCreatedEventSource;

/**
 * 订单已创建领域事件
 *
 * 0.命名格式：聚合实体名词+动词过去式+Event
 * 1.基类继承ApplicationEvent，所以事件携带的具体信息通过事件源对象(eventSource)来传输
 *
 * @author lvweijie
 * @date 2021-08-12 13:41
 */
public class OrderCreatedEvent extends BaseEvent {

    /**
     * @param eventSource 事件源
     * @author lvweijie
     * @date 2021/8/12 16:03
     */
    private OrderCreatedEvent(OrderCreatedEventSource eventSource){
        super(eventSource);
    }
}
