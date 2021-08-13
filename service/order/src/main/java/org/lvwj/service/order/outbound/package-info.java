/**
 * outbound输出端(南向网关)：按菱形对称架构，分为port(南向端口) 和 adapter(南向适配器)
 * 1.port: 南向端口，放仓储、其他微服务/第三方服务、发布者等接口
 * 2.adapter: 南向适配器，放仓储、其他微服务/第三方服务、发布者等接口的实现，(按DDD分层架构，属于基础设施层)
 * 3.如果顶层已经有了SpringUtil.publishEvent方法和注解式发送RabbitMq,那么port.publisher包可以去掉，
 *   adapter.publisher包保留，专门放注解式发送RabbitMq的类(例：SyncMqProducer)
 *
 * @author lvweijie
 * @date 2021-08-04 15:04
 */
package org.lvwj.service.order.outbound;