package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Address {
    Province province;
    City city;
    County county;
    /**
     * 县以下的详细地址(具体到门牌号) (例：孙坂北路801号402室)
     *
     * @author lvweijie
     * @date 2021/8/11 21:45
     */
    String detail;

    /**
     * 具体地址=省市县+详细地址 (例：福建省厦门市集美区孙坂北路801号402室)
     *
     * @param separator
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 21:47
     */
    public String fullAddress(String separator) {
        return provinceCityCounty(separator) + separator + detail;
    }

    /**
     * 省市 (例：福建省厦门市)
     *
     * @param separator
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:08
     */
    public String provinceCity(String separator) {
        return province.getName() + separator + city.getName();
    }

    /**
     * 省市县 (例：福建省厦门市集美区)
     *
     * @param separator
     * @return java.lang.String
     * @author lvweijie
     * @date 2021/8/11 22:08
     */
    public String provinceCityCounty(String separator) {
        return provinceCity(separator) + separator + county.getName();
    }
}
