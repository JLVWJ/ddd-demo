package org.lvwj.common.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解：北向网关的本地服务(应用服务)标识
 * @author lvweijie
 * @date 2021/8/13 17:26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Local {
}
