package org.lvwj.common.domain;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 枚举接口
 *
 * @author lvweijie
 * @date 2021-08-13 10:07
 */
public interface BaseEnum {
    @JsonValue
    Integer getCode();

    String getName();

    static <T extends BaseEnum> T enumOfCode(Class<T> enumType, Integer code) {
        T[] enums = enumType.getEnumConstants();
        if (null == enums) {
            return null;
        }
        return Arrays.stream(enums).filter(s -> s.getCode().equals(code)).findFirst().orElse(null);
    }

    static <T extends BaseEnum> T enumOfName(Class<T> enumType, String name) {
        T[] enums = enumType.getEnumConstants();
        if (null == enums) {
            return null;
        }
        return Arrays.stream(enums).filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
}
