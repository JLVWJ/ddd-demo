package org.lvwj.service.order.domain.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.lvwj.common.domain.BaseEnum;


/**
 * 枚举也是一种值对象，如果api模块也用到，可以放在api.enums包下
 *
 * @author lvweijie
 * @date 2021-08-11 22:56
 */
@AllArgsConstructor
@Getter
public enum OrderStatus implements BaseEnum {
    CREATED(1, "已创建"),
    PAYED(2, "已支付"),
    FINISHED(3, "已完成"),

    ;

    Integer code;
    String name;

    public boolean isCreated() {
        return this == CREATED;
    }

    public boolean isPayed() {
        return this == PAYED;
    }

    public boolean isFinished() {
        return this == FINISHED;
    }
}
