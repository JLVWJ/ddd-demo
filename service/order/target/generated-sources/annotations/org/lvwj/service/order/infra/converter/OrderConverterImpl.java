package org.lvwj.service.order.infra.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.lvwj.service.order.api.dto.OrderDTO;
import org.lvwj.service.order.api.dto.OrderItemDTO;
import org.lvwj.service.order.domain.entity.Order;
import org.lvwj.service.order.domain.entity.Order.OrderBuilder;
import org.lvwj.service.order.domain.entity.OrderItem;
import org.lvwj.service.order.domain.entity.OrderItem.OrderItemBuilder;
import org.lvwj.service.order.domain.valobj.Address;
import org.lvwj.service.order.domain.valobj.Address.AddressBuilder;
import org.lvwj.service.order.domain.valobj.Contract;
import org.lvwj.service.order.domain.valobj.Contract.ContractBuilder;
import org.lvwj.service.order.domain.valobj.Name;
import org.lvwj.service.order.domain.valobj.Name.NameBuilder;
import org.lvwj.service.order.domain.valobj.OrderStatus;
import org.lvwj.service.order.domain.valobj.Person;
import org.lvwj.service.order.domain.valobj.Person.PersonBuilder;
import org.lvwj.service.order.domain.valobj.Phone;
import org.lvwj.service.order.domain.valobj.Phone.PhoneBuilder;
import org.lvwj.service.order.domain.valobj.ProductSnapShot;
import org.lvwj.service.order.domain.valobj.ProductSnapShot.ProductSnapShotBuilder;
import org.lvwj.service.order.domain.valobj.Province;
import org.lvwj.service.order.domain.valobj.Province.ProvinceBuilder;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderDO;
import org.lvwj.service.order.infra.persistence.mybatis.entity.OrderItemDO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-13T15:50:32+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class OrderConverterImpl implements OrderConverter {

    @Override
    public Order toOrder(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        OrderBuilder order = Order.builder();

        order.collectAddress( orderDOToAddress( orderDO ) );
        order.collectPerson( orderDOToPerson( orderDO ) );
        order.contract( orderDOToContract( orderDO ) );
        order.orderNo( orderDO.getOrderNo() );
        if ( orderDO.getStatus() != null ) {
            order.status( Enum.valueOf( OrderStatus.class, orderDO.getStatus() ) );
        }
        order.orderItems( orderItemDOListToOrderItemSet( orderDO.getOrderItems() ) );

        return order.build();
    }

    @Override
    public List<Order> toOrderList(List<OrderDO> orderDOs) {
        if ( orderDOs == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( orderDOs.size() );
        for ( OrderDO orderDO : orderDOs ) {
            list.add( toOrder( orderDO ) );
        }

        return list;
    }

    @Override
    public OrderItem toOrderItem(OrderItemDO orderItemDO) {
        if ( orderItemDO == null ) {
            return null;
        }

        OrderItemBuilder orderItem = OrderItem.builder();

        orderItem.productSnapShot( orderItemDOToProductSnapShot( orderItemDO ) );
        orderItem.num( orderItemDO.getNum() );
        orderItem.orderId( orderItemDO.getOrderId() );

        return orderItem.build();
    }

    @Override
    public List<OrderItem> toOrderItemList(List<OrderItemDO> orderItemDOs) {
        if ( orderItemDOs == null ) {
            return null;
        }

        List<OrderItem> list = new ArrayList<OrderItem>( orderItemDOs.size() );
        for ( OrderItemDO orderItemDO : orderItemDOs ) {
            list.add( toOrderItem( orderItemDO ) );
        }

        return list;
    }

    @Override
    public OrderDO toOrderDO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDO orderDO = new OrderDO();

        orderDO.setProvinceCode( orderCollectAddressProvinceCode( order ) );
        orderDO.setProvinceName( orderCollectAddressProvinceName( order ) );
        orderDO.setCollectPersonName( orderCollectPersonNameValue( order ) );
        orderDO.setCollectPersonPhone( orderCollectPersonPhoneValue( order ) );
        orderDO.setContractId( orderContractId( order ) );
        orderDO.setContractCode( orderContractCode( order ) );
        orderDO.setId( order.getId() );
        orderDO.setOrderNo( order.getOrderNo() );
        if ( order.getStatus() != null ) {
            orderDO.setStatus( order.getStatus().name() );
        }
        orderDO.setOrderItems( orderItemSetToOrderItemDOList( order.getOrderItems() ) );

        return orderDO;
    }

    @Override
    public OrderItemDO toOrderItemDO(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDO orderItemDO = new OrderItemDO();

        orderItemDO.setProductId( orderItemProductSnapShotProductId( orderItem ) );
        orderItemDO.setProductName( orderItemProductSnapShotProductName( orderItem ) );
        orderItemDO.setProductCode( orderItemProductSnapShotProductCode( orderItem ) );
        orderItemDO.setPurchasePrice( orderItemProductSnapShotPurchasePrice( orderItem ) );
        orderItemDO.setIndicativePrice( orderItemProductSnapShotIndicativePrice( orderItem ) );
        orderItemDO.setId( orderItem.getId() );
        orderItemDO.setNum( orderItem.getNum() );
        orderItemDO.setOrderId( orderItem.getOrderId() );

        return orderItemDO;
    }

    @Override
    public OrderDTO toOrderDTO(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( orderDO.getId() );
        orderDTO.setOrderNo( orderDO.getOrderNo() );
        if ( orderDO.getStatus() != null ) {
            orderDTO.setStatus( Integer.parseInt( orderDO.getStatus() ) );
        }
        orderDTO.setProvinceName( orderDO.getProvinceName() );
        orderDTO.setProvinceCode( orderDO.getProvinceCode() );
        orderDTO.setCollectPersonName( orderDO.getCollectPersonName() );
        orderDTO.setCollectPersonPhone( orderDO.getCollectPersonPhone() );
        orderDTO.setContractId( orderDO.getContractId() );
        orderDTO.setContractCode( orderDO.getContractCode() );
        orderDTO.setOrderItems( orderItemDOListToOrderItemDTOList( orderDO.getOrderItems() ) );

        return orderDTO;
    }

    @Override
    public OrderItemDTO toOrderItemDTO(OrderItemDO orderItemDO) {
        if ( orderItemDO == null ) {
            return null;
        }

        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setNum( orderItemDO.getNum() );
        orderItemDTO.setOrderId( orderItemDO.getOrderId() );
        orderItemDTO.setProductId( orderItemDO.getProductId() );
        orderItemDTO.setProductCode( orderItemDO.getProductCode() );
        orderItemDTO.setProductName( orderItemDO.getProductName() );
        orderItemDTO.setPurchasePrice( orderItemDO.getPurchasePrice() );
        orderItemDTO.setIndicativePrice( orderItemDO.getIndicativePrice() );

        return orderItemDTO;
    }

    protected Province orderDOToProvince(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        ProvinceBuilder province = Province.builder();

        province.code( orderDO.getProvinceCode() );
        province.name( orderDO.getProvinceName() );

        return province.build();
    }

    protected Address orderDOToAddress(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        AddressBuilder address = Address.builder();

        address.province( orderDOToProvince( orderDO ) );

        return address.build();
    }

    protected Name orderDOToName(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        NameBuilder name = Name.builder();

        name.value( orderDO.getCollectPersonName() );

        return name.build();
    }

    protected Phone orderDOToPhone(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        PhoneBuilder phone = Phone.builder();

        phone.value( orderDO.getCollectPersonPhone() );

        return phone.build();
    }

    protected Person orderDOToPerson(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        PersonBuilder person = Person.builder();

        person.name( orderDOToName( orderDO ) );
        person.phone( orderDOToPhone( orderDO ) );

        return person.build();
    }

    protected Contract orderDOToContract(OrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        ContractBuilder contract = Contract.builder();

        contract.id( orderDO.getContractId() );
        contract.code( orderDO.getContractCode() );

        return contract.build();
    }

    protected Set<OrderItem> orderItemDOListToOrderItemSet(List<OrderItemDO> list) {
        if ( list == null ) {
            return null;
        }

        Set<OrderItem> set = new HashSet<OrderItem>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( OrderItemDO orderItemDO : list ) {
            set.add( toOrderItem( orderItemDO ) );
        }

        return set;
    }

    protected ProductSnapShot orderItemDOToProductSnapShot(OrderItemDO orderItemDO) {
        if ( orderItemDO == null ) {
            return null;
        }

        ProductSnapShotBuilder productSnapShot = ProductSnapShot.builder();

        productSnapShot.productId( orderItemDO.getProductId() );
        productSnapShot.productName( orderItemDO.getProductName() );
        productSnapShot.productCode( orderItemDO.getProductCode() );
        productSnapShot.purchasePrice( orderItemDO.getPurchasePrice() );
        productSnapShot.indicativePrice( orderItemDO.getIndicativePrice() );

        return productSnapShot.build();
    }

    private String orderCollectAddressProvinceCode(Order order) {
        if ( order == null ) {
            return null;
        }
        Address collectAddress = order.getCollectAddress();
        if ( collectAddress == null ) {
            return null;
        }
        Province province = collectAddress.getProvince();
        if ( province == null ) {
            return null;
        }
        String code = province.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String orderCollectAddressProvinceName(Order order) {
        if ( order == null ) {
            return null;
        }
        Address collectAddress = order.getCollectAddress();
        if ( collectAddress == null ) {
            return null;
        }
        Province province = collectAddress.getProvince();
        if ( province == null ) {
            return null;
        }
        String name = province.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String orderCollectPersonNameValue(Order order) {
        if ( order == null ) {
            return null;
        }
        Person collectPerson = order.getCollectPerson();
        if ( collectPerson == null ) {
            return null;
        }
        Name name = collectPerson.getName();
        if ( name == null ) {
            return null;
        }
        String value = name.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private String orderCollectPersonPhoneValue(Order order) {
        if ( order == null ) {
            return null;
        }
        Person collectPerson = order.getCollectPerson();
        if ( collectPerson == null ) {
            return null;
        }
        Phone phone = collectPerson.getPhone();
        if ( phone == null ) {
            return null;
        }
        String value = phone.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private String orderContractId(Order order) {
        if ( order == null ) {
            return null;
        }
        Contract contract = order.getContract();
        if ( contract == null ) {
            return null;
        }
        String id = contract.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String orderContractCode(Order order) {
        if ( order == null ) {
            return null;
        }
        Contract contract = order.getContract();
        if ( contract == null ) {
            return null;
        }
        String code = contract.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    protected List<OrderItemDO> orderItemSetToOrderItemDOList(Set<OrderItem> set) {
        if ( set == null ) {
            return null;
        }

        List<OrderItemDO> list = new ArrayList<OrderItemDO>( set.size() );
        for ( OrderItem orderItem : set ) {
            list.add( toOrderItemDO( orderItem ) );
        }

        return list;
    }

    private String orderItemProductSnapShotProductId(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        ProductSnapShot productSnapShot = orderItem.getProductSnapShot();
        if ( productSnapShot == null ) {
            return null;
        }
        String productId = productSnapShot.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    private String orderItemProductSnapShotProductName(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        ProductSnapShot productSnapShot = orderItem.getProductSnapShot();
        if ( productSnapShot == null ) {
            return null;
        }
        String productName = productSnapShot.getProductName();
        if ( productName == null ) {
            return null;
        }
        return productName;
    }

    private String orderItemProductSnapShotProductCode(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        ProductSnapShot productSnapShot = orderItem.getProductSnapShot();
        if ( productSnapShot == null ) {
            return null;
        }
        String productCode = productSnapShot.getProductCode();
        if ( productCode == null ) {
            return null;
        }
        return productCode;
    }

    private BigDecimal orderItemProductSnapShotPurchasePrice(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        ProductSnapShot productSnapShot = orderItem.getProductSnapShot();
        if ( productSnapShot == null ) {
            return null;
        }
        BigDecimal purchasePrice = productSnapShot.getPurchasePrice();
        if ( purchasePrice == null ) {
            return null;
        }
        return purchasePrice;
    }

    private BigDecimal orderItemProductSnapShotIndicativePrice(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        ProductSnapShot productSnapShot = orderItem.getProductSnapShot();
        if ( productSnapShot == null ) {
            return null;
        }
        BigDecimal indicativePrice = productSnapShot.getIndicativePrice();
        if ( indicativePrice == null ) {
            return null;
        }
        return indicativePrice;
    }

    protected List<OrderItemDTO> orderItemDOListToOrderItemDTOList(List<OrderItemDO> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemDTO> list1 = new ArrayList<OrderItemDTO>( list.size() );
        for ( OrderItemDO orderItemDO : list ) {
            list1.add( toOrderItemDTO( orderItemDO ) );
        }

        return list1;
    }
}
