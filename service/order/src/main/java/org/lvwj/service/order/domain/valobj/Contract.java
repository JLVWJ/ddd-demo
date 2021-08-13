package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Contract {
    String id;
    String code;
    /**
     * 合同签约人
     * @author lvweijie
     * @date 2021/8/11 22:13
     */
    Person contractor;
    LocalDateTime createTime;
}
