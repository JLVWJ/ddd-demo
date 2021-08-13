package org.lvwj.common.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解：上下文标识
 * @author lvweijie
 * @date 2021/8/13 17:26
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.SOURCE)
public @interface BoundedContext {

    String name();

    SubDomain subDomain() default SubDomain.Core;
}