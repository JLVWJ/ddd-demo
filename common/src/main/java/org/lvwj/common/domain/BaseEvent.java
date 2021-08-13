package org.lvwj.common.domain;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @author lvweijie
 * @date 2021-08-12 13:41
 */
@Getter
public class BaseEvent extends ApplicationEvent {

    /**
     * 事件ID
     *
     * @author lvweijie
     * @date 2021/8/12 16:29
     */
    private final String id;
    /**
     * 事件创建时间
     *
     * @author lvweijie
     * @date 2021/8/12 16:29
     */
    private final LocalDateTime createTime;

    /**
     * 事件版本号
     *
     * @author lvweijie
     * @date 2021/8/13 17:24
     */
    private final String version;

    public BaseEvent(Object source) {
        this(source, "1.0");
    }

    public BaseEvent(Object source, String version) {
        super(source);
        id = UUID.randomUUID().toString();
        createTime = LocalDateTime.now();
        this.version = version;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEvent baseEvent = (BaseEvent) o;
        return id.equals(baseEvent.id) && createTime.equals(baseEvent.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime);
    }
}
