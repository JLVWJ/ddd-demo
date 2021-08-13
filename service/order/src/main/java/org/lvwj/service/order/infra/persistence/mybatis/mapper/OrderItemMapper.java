package org.lvwj.service.order.infra.persistence.mybatis.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderItemDO;

import java.util.List;

/**
 * @author lvweijie
 * @date 2021-08-11 23:59
 */
public interface OrderItemMapper extends BaseMapper<OrderItemDO> {
    List<OrderItemDO> listByOrderId(String orderId);
}
