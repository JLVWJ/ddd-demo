package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


/**
 * 市
 * @author lvweijie
 * @date 2021-08-11 21:42
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class City {
    String code;
    String name;
}
