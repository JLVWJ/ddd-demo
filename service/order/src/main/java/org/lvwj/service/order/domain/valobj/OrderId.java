package org.lvwj.service.order.domain.valobj;

import org.lvwj.common.domain.BaseIdentity;

/**
 * 值对象：订单id(订单的唯一标识)
 *
 * 说明：唯一标识不一定就是基础类型(String、Long)，也可以是这样的值对象，
 *      DDD推荐把所有基础类型字段尽可能的建模成值对象。
 *      好处是：数据校验，业务规则，业务逻辑在值对象里面内聚和复用，
 *      如果是基础类型，那么这些逻辑就会散落在领域实体上，没有做到自己的逻辑自己管理，也就是高内聚
 * @author lvweijie
 * @date 2021-08-14 23:26
 */

public class OrderId extends BaseIdentity<String> {

    OrderId(String value) {
        super(value);
    }

    public static OrderId create(String value) {
        return new OrderId(value);
    }
}
