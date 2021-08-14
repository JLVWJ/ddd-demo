package org.lvwj.common.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * 领域实体基类
 *
 * @author lvweijie
 * @date 2021/8/14 23:20
 */
@Getter
@Setter
@ToString
public class BaseEntity<T extends Serializable> implements Serializable {
    /**
     * 领域实体的唯一标识
     * @param T  1.T可以是String、Long等基础类似; 2.T也可以是继承BaseIdentity的值对象(例如：OrderId)(*推荐*)
     * @author lvweijie
     * @date 2021/8/14 23:21
     */
    private T id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
