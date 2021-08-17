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
 *   3.4 valobj包：放值对象
 *   3.5 其他包(可选)：factory, spec(specification业务规范)等
 *    3.5.1 factory：领域实体工厂，如果一个聚合根有很多字段，那在聚合根内部用static create就不太合适，可以用factory来构建聚合根
 *    3.5.2 spec(specification) 有俩种用法：
 *     3.5.2.1 封装数据校验/业务校验逻辑，在领域层里面可以复用，这是用面向对象的方式，把判断逻辑封装成一个对象。
 *     3.5.2.1 作为仓储接口的入参，接口实现把spec转换成sql where条件,作用于持久化框架，这样根据不同领域实体字段拼装查询条件来查询出聚合根
 *             jpa底层就有specification可以支持这种用法，mybatis需要自己写领域实体字段转成sql where条件。
 * @author lvweijie
 * @date 2021-08-13 16:36
 */
package org.lvwj.service.order.domain;