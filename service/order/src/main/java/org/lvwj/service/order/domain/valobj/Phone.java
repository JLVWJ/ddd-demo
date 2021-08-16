package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;


/**
 * 手机号
 * @author lvweijie
 * @date 2021-08-11 22:26
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Phone {
    public static final int[] YI_DONG = new int[]{134, 135, 136, 137, 138, 139, 147, 148, 150, 151, 152, 157, 158, 159, 178, 182, 183, 184, 187, 188, 198, 1440, 1703, 1705, 1706};
    public static final int[] DIAN_XIN = new int[]{133, 153, 177, 180, 181, 189, 191, 199, 1349, 1410, 1700, 1701, 1702, 1740};
    public static final int[] LIAN_TONG = new int[]{130, 131, 132, 155, 156, 185, 186, 145, 146, 166, 167, 175, 176, 1704, 1707, 1708, 1709, 1710, 1711, 1712, 1713, 1714, 1715, 1716, 1717, 1718, 1719};

    String value;

    public static Phone create(String value) {
        return Phone.builder().value(value).build();
    }

    /**
     * 手机号后4位
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:21
     */
    public String phoneLastFour() {
        return value.substring(6, 11);
    }

    /**
     * 手机号前3位
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:29
     */
    public String firstThree() {
        return value.substring(0, 3);
    }

    /**
     * 手机号前4位
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:29
     */
    public String firstFour() {
        return value.substring(0, 4);
    }

    /**
     * 手机号加密
     *
     * @param
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:23
     */
    public String encryptPhone() {
        return firstThree() + "****" + phoneLastFour();
    }

    /**
     * 是否是移动手机号
     *
     * @param
     * @return java.lang.Boolean
     * @author lvweijie
     * @date 2021/8/11 22:42
     */
    public Boolean isYiDong() {
        return Arrays.stream(YI_DONG).mapToObj(String::valueOf).anyMatch(s -> s.equals(firstThree()) || s.equals(firstFour()));
    }

    /**
     * 是否是电信手机号
     *
     * @param
     * @return java.lang.Boolean
     * @author lvweijie
     * @date 2021/8/11 22:43
     */
    public Boolean isDianXin() {
        return Arrays.stream(DIAN_XIN).mapToObj(String::valueOf).anyMatch(s -> s.equals(firstThree()) || s.equals(firstFour()));
    }

    /**
     * 是否是联通手机号
     *
     * @param
     * @return java.lang.Boolean
     * @author lvweijie
     * @date 2021/8/11 22:43
     */
    public Boolean isLianTong() {
        return Arrays.stream(LIAN_TONG).mapToObj(String::valueOf).anyMatch(s -> s.equals(firstThree()) || s.equals(firstFour()));
    }
}
