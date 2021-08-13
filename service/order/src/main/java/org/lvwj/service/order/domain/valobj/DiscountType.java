package org.lvwj.service.order.domain.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.lvwj.common.domain.BaseEnum;

/**
 * @author lvweijie
 * @date 2021-08-13 14:37
 */
@Getter
@AllArgsConstructor
public enum DiscountType implements BaseEnum {

    NONE(0, ""),
    SUBTRACT(1, "优惠"),
    ADD(2, "加价"),
    ;

    Integer code;
    String name;
}
