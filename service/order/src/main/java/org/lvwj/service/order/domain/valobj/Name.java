package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 姓名
 * @author lvweijie
 * @date 2021-08-11 22:26
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Name {
    String value;

    /**
     * 姓
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:19
     */
    public String firstName() {
        return value.substring(0, 1);
    }

    /**
     * 名
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:18
     */
    public String lastName() {
        return value.substring(1);
    }

    /**
     * 加密姓名 (例: 吕**)
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:47
     */
    public String encryptName() {
        return firstName() + "**";
    }
}
