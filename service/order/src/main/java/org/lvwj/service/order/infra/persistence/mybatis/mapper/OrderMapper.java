package org.lvwj.service.order.infra.persistence.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderDO;

import java.util.Optional;

/**
 * mybatis mapper接口
 *
 * @author lvweijie
 * @date 2021-08-11 23:47
 */
public interface OrderMapper extends BaseMapper<OrderDO> {
     Boolean checkOrderNoIsExist(String orderNo);

     /**
      * 建议返回值用Optional包装，提醒调用方处理空指针
      *
      * @param orderNo
      * @return java.util.Optional<org.lvwj.service.order.infra.persistence.mybatis.entity.OrderDO>
      * @author lvweijie
      * @date 2021/8/12 15:19
      */
     Optional<OrderDO> getOrderByNo(String orderNo);
}
