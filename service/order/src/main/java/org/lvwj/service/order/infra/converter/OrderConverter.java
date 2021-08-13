package org.lvwj.service.order.infra.converter;

import org.lvwj.service.order.api.dto.OrderDTO;
import org.lvwj.service.order.api.dto.OrderItemDTO;
import org.lvwj.service.order.domain.entity.Order;
import org.lvwj.service.order.domain.entity.OrderItem;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderDO;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderItemDO;
import org.mapstruct.*;

import java.util.List;

/**
 * 转换器 mapStruct接口
 *
 * 1.@Mapping表示来源和目标字段的映射关系，如果字段名和类型一致，不需要设置@Mapping
 * 2.枚举和枚举值名称之间可以自动转换
 * 3.OrderConverter实现类在target包里(OrderConverterImpl)
 * 4.mapStruct接口更多用法看我发的wiki，自动生成set方法，很强大，有很多高级玩法
 * @author lvweijie
 * @date 2021-08-12 07:58
 */
@Mapper(componentModel = "spring")
public interface OrderConverter {

    /**
     * 数据实体 -> 领域实体
     *
     * @param orderDO
     * @return org.lvwj.service.order.domain.entity.Order
     * @author lvweijie
     * @date 2021/8/12 8:38
     */
    @Mappings({
            @Mapping(source = "provinceCode", target = "collectAddress.province.code"),
            @Mapping(source = "provinceName", target = "collectAddress.province.name"),
            @Mapping(source = "collectPersonName", target = "collectPerson.name.value"),
            @Mapping(source = "collectPersonPhone", target = "collectPerson.phone.value"),
            @Mapping(source = "contractId", target = "contract.id"),
            @Mapping(source = "contractCode", target = "contract.code"),
    })
    Order toOrder(OrderDO orderDO);

    /**
     * 会自动用Order toOrder(OrderDO orderDO)进行集合转换
     * 不需要在配置Mapping
     *
     * @param orderDOs
     * @return java.util.List<org.lvwj.service.order.domain.entity.Order>
     * @author lvweijie
     * @date 2021/8/13 15:48
     */
    List<Order> toOrderList(List<OrderDO> orderDOs);

    @Mappings({
            @Mapping(source = "productId", target = "productSnapShot.productId"),
            @Mapping(source = "productName", target = "productSnapShot.productName"),
            @Mapping(source = "productCode", target = "productSnapShot.productCode"),
            @Mapping(source = "purchasePrice", target = "productSnapShot.purchasePrice"),
            @Mapping(source = "indicativePrice", target = "productSnapShot.indicativePrice"),
    })
    OrderItem toOrderItem(OrderItemDO orderItemDO);

    List<OrderItem> toOrderItemList(List<OrderItemDO> orderItemDOs);

    /**
     * 领域实体 -> 数据实体
     *
     * @param order
     * @return org.lvwj.service.order.infra.persistence.mybatis.entity.OrderDO
     * @author lvweijie
     * @date 2021/8/12 8:38
     */
    @Mappings({
            @Mapping(target = "provinceCode", source = "collectAddress.province.code"),
            @Mapping(target = "provinceName", source = "collectAddress.province.name"),
            @Mapping(target = "collectPersonName", source = "collectPerson.name.value"),
            @Mapping(target = "collectPersonPhone", source = "collectPerson.phone.value"),
            @Mapping(target = "contractId", source = "contract.id"),
            @Mapping(target = "contractCode", source = "contract.code"),
    })
    OrderDO toOrderDO(Order order);

    @Mappings({
            @Mapping(target = "productId", source = "productSnapShot.productId"),
            @Mapping(target = "productName", source = "productSnapShot.productName"),
            @Mapping(target = "productCode", source = "productSnapShot.productCode"),
            @Mapping(target = "purchasePrice", source = "productSnapShot.purchasePrice"),
            @Mapping(target = "indicativePrice", source = "productSnapShot.indicativePrice"),
    })
    OrderItemDO toOrderItemDO(OrderItem orderItem);

    /**
     * 数据实体 -> 数据传输实体(DTO)
     *
     * @param orderDO
     * @return org.lvwj.service.order.api.dto.OrderDTO
     * @author lvweijie
     * @date 2021/8/12 8:44
     */
    OrderDTO toOrderDTO(OrderDO orderDO);

    OrderItemDTO toOrderItemDTO(OrderItemDO orderItemDO);
}
