package org.lvwj.common.domain.specification;

import cn.hutool.core.lang.Assert;

/**
 * NOT规范，用于创建一个新规范，作为另一个规范的"非（NOT）"操作的结果。
 *
 * @param <T> 类型参数，表示规范所应用到的目标对象类型。
 */
public class NotSpecification<T> extends AbstractSpecification<T> {

    private final Specification<T> spec1;

    /**
     * 基于另一个规范创建它对应的“非(NOT)”规范。
     *
     * @param spec1 要执行“非（NOT)"操作的规范.
     */
    public NotSpecification(final Specification<T> spec1) {
        this.spec1 = Assert.notNull(spec1, "Specification %s is null!", spec1.getClass().getSimpleName());
    }

    /**
     * {@inheritDoc}
     *
     * @param t 要用来执行“非(NOT)”操作的规范。
     * @return 如果t满足规范t，则返回false，否则返回true。
     */
    @Override
    public boolean isSatisfiedBy(final T t) {
        return !spec1.isSatisfiedBy(t);
    }
}
