package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 省
 * @author lvweijie
 * @date 2021-08-11 21:41
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Province {
    String code;
    String name;

    public static Province create(String code, String name) {
        return Province.builder().code(code).name(name).build();
    }
}
