package org.lvwj.common.domain.primitive;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 通用值对象(domain primitive(简称:领域基础类型)): 货币
 *
 * @author lvweijie
 * @date 2021-08-15 11:39
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Currency {
    /**
     * 符号
     * @author lvweijie
     * @date 2021/8/15 11:42
     */
    String symbol;
    /**
     * 英文名称
     * @author lvweijie
     * @date 2021/8/15 11:43
     */
    String enName;
    /**
     * 中文名称
     * @author lvweijie
     * @date 2021/8/15 11:43
     */
    String chName;
}
