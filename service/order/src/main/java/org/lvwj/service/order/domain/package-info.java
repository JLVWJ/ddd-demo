/**
 * domain(领域层)：
 *
 * 1.按限界上下文或聚合来分包，比如车源上下文carsource和库存上下文inventory各自一个包，(例：domain.carsource | domain.inventory)
 *   各自管理聚合根、实体、值对象、领域服务、领域事件、实体工厂等领域模型
 * 2.这里假设订单服务就一个订单上下文，上下文就一个订单聚合，那就不需要建domain.order包, 直接domain包就行
 * 3.domain包介绍：
 *   3.1 entity包：放领域实体、聚合根(特殊的领域实体)
 *   3.2 event包：放领域事件
 *   3.3 service包：放领域服务
 *   3.4 valobj包：方放值对象
 *   3.5 其他包：factory, spec(specification业务规范)有需要再建
 * @author lvweijie
 * @date 2021-08-13 16:36
 */
package org.lvwj.service.order.domain;