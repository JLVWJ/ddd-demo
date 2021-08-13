package org.lvwj.common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lvweijie
 * @date 2021-08-11 21:32
 */
@Setter
@Getter
@ToString
public class BaseAggregate<T extends Serializable> extends BaseEntity<T> {
    private Long version;
}
