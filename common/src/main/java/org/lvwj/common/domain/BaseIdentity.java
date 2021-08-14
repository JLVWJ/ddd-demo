package org.lvwj.common.domain;

import java.util.Objects;

/**
 * 唯一标识抽象基类
 * @author lvweijie
 * @date 2021/8/13 17:44
 */
public abstract class BaseIdentity<T> implements Identity<T> {
    private T value;

    protected BaseIdentity(T value) {
        this.setId(value);
    }

    @Override
    public T value() {
        return getValue();
    }

    public T getValue() {
        return value;
    }

    private void setId(T value) {
        if (value == null) {
            throw new IllegalArgumentException("The identity is required ");
        }
        this.validateValue(value);
        this.value = value;
    }

    protected void validateValue(T value) {
        //更多校验逻辑可以在子类重写定义
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseIdentity<?> that = (BaseIdentity<?>) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + value + "]";
    }
}
