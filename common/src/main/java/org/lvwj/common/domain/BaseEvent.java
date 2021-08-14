package org.lvwj.common.domain;

import cn.hutool.json.JSONUtil;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * 事件基类
 *
 * @author lvweijie
 * @date 2021-08-12 13:41
 */
@Getter
public abstract class BaseEvent extends ApplicationEvent {

    /**
     * 事件ID
     *
     * @author lvweijie
     * @date 2021/8/12 16:29
     */
    private final String id;

    /**
     * 事件名称
     *
     * @author lvweijie
     * @date 2021/8/12 16:29
     */
    private final String name;

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

    /**
     * 事件源json字符串
     *
     * @author lvweijie
     * @date 2021/8/14 18:25
     */
    private final String json;

    public BaseEvent(BaseEventSource source) {
        this(source, "1.0");
    }

    public BaseEvent(BaseEventSource source, String version) {
        super(Objects.requireNonNull(source));
        this.id = UUID.randomUUID().toString();
        this.name = this.getClass().getSimpleName();
        this.createTime = LocalDateTime.now();
        this.version = version;
        this.json = JSONUtil.toJsonStr(source);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEvent baseEvent = (BaseEvent) o;
        return id.equals(baseEvent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
