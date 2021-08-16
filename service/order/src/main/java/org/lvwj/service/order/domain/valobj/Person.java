package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 人
 * @author lvweijie
 * @date 2021/8/13 8:51
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Person {
    Name name;
    Phone phone;

    public static Person create(Name name,Phone phone) {
        return Person.builder().name(name).phone(phone).build();
    }

    /**
     * 姓名手机号
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:48
     */
    public String namePhone() {
        return name.getValue() + "(" + phone.getValue() + ")";
    }

    /**
     * 加密的姓名手机号
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:48
     */
    public String encryptNamePhone() {
        return name.encryptName() + "(" + phone.encryptPhone() + ")";
    }
}
