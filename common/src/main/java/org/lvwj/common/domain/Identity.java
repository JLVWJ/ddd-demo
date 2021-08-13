package org.lvwj.common.domain;

import java.io.Serializable;

/**
 * 唯一标识接口
 * @author lvweijie
 * @date 2021/8/13 17:43
 */
public interface Identity<T> extends Serializable {
    T value();
}