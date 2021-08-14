package org.lvwj.service.order.inbound.remote.subscriber;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lvwj.service.order.domain.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 订单已创建事件处理器(进程内的事件处理器)
 * 说明：只是为了代码演示
 * 1. 如果要在同一事务  @Async可以去掉
 *
 * @author lvweijie
 * @date 2021-08-12 16:05
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class OrderCreatedEventListener {


    @Async //异步就会不在同一事务
    @Order
    @EventListener(OrderCreatedEvent.class)
    public void handlerEvent(OrderCreatedEvent event) {
        final Object source = event.getSource();
        //.....
    }
}
