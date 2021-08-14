/**
 * 说明：
 * 1.domain下的分包，是按当前微服务存在几个上下文来分的，比如商品微服务存在车源上下文和库存上下文，
 *   那就可以分成domain.carsource和domain.inventory，管理各自的领域模型，
 *   好处是高内聚低耦合，以后如果拆成俩个微服务就很好拆，代码改动小。
 *
 * @author lvweijie
 * @date 2021-08-15 00:44
 */
package org.lvwj.service.product.domain;