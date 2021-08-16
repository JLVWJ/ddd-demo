package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 县
 * @author lvweijie
 * @date 2021-08-11 21:43
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class County {
    String code;
    String name;

    public static County create(String code, String name) {
        return County.builder().code(code).name(name).build();
    }
}
