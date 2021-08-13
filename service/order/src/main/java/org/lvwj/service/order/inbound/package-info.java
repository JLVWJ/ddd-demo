/**
 * inbound输入端(北向网关): 按菱形对称架构，输入端分为remote(远程服务) 和 local(本地服务)
 * 1.remote(远程服务)：放控制器、提供者、订阅者、定时器等，(按DDD分层架构，属于基础设施层)
 * 2.local(本地服务)：即应用服务，根据CQRS，分为Command端和Query端，(按DDD分层架构，属于应用服务层)
 *   2.1 Command端有接口和实现，调用会经过domain层
 *   2.2 Query端只有接口，调用不会经过domain层，直接调用基础设施层的数据持久化框架来查询前端要的DTO,
 *       接口实现放在infra.query
 *   2.3 Command和Query服务可以不要接口，只有实现
 * @author lvweijie
 * @date 2021-08-04 14:58
 */
package org.lvwj.service.order.inbound;