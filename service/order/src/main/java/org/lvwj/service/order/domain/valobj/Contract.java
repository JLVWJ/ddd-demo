package org.lvwj.service.order.domain.valobj;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 值对象：合同(Contract)
 *
 * 1.在订单上下文，合同是值对象，对应订单表上的合同相关的字段
 * 2.在合同上下文，合同就是聚合根/领域实体，对应合同表
 *
 * @author lvweijie
 * @date 2021/8/15 0:00
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Contract {
    String id;
    String code;
    /**
     * 合同签约人
     *
     * @author lvweijie
     * @date 2021/8/11 22:13
     */
    Person contractor;
    LocalDateTime createTime;

    public static Contract create(String id, String code, Person contractor, LocalDateTime createTime) {
        return Contract.builder().id(id).code(code).contractor(contractor).createTime(createTime).build();
    }
}
