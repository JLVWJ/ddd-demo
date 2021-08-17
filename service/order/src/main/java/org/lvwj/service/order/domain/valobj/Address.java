package org.lvwj.service.order.domain.valobj;

import lombok.*;

/**
 * 值对象：Address，包含省市区等值对象字段和detail字段
 *
 * 1.值对象的字段也可以是值对象
 * 2.通用的值对象就跟基础类型一样，在DDD中叫Domain Primitive，这些值对象可以提升到顶层包或common包 供其它微服务的领域层使用
 * 3.值对象不只有字段，还有丰富的逻辑方法(fullAddress provinceCity provinceCityCounty等)，遵循了高内聚思想，逻辑方法可以复用
 *
 * @author lvweijie
 * @date 2021/8/14 23:49
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
//@Value  说明：@Value和@Builder都可以标识不可变类，选择@Builder 是因为MapStruct组件支持@Data和@Builder互转，不支持@Data和@Value互转
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
     * 构建Address
     *
     * @param province
     * @param city
     * @param county
     * @param detail
     * @return org.lvwj.service.order.domain.valobj.Address
     * @author lvweijie
     * @date 2021/8/16 16:08
     */
    public static Address create(Province province, City city, County county, String detail) {
        return Address.builder().province(province).city(city).county(county).detail(detail).build();
    }

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
