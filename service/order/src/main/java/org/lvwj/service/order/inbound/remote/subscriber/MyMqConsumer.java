package org.lvwj.service.order.inbound.remote.subscriber;

// 只是复制supply的代码来做演示：(跨进程的消息处理器(消费者/监听器))
//
//import com.alibaba.fastjson.JSONObject;
//import com.yiautos.car.source.query.web.CarSourceDeleteQuery;
//import com.yiautos.car.source.query.web.CarSourceEnterQuery;
//import com.yiautos.car.source.service.SupplyModelsDtlService;
//import com.yiautos.dmt.sdk.mq.annotation.MqConsumerStore;
//import com.yiautos.dmt.sdk.mq.annotation.MyMqConsumerClass;
//import lombok.extern.slf4j.Slf4j;
//import org.springblade.core.tool.utils.Func;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//@MyMqConsumerClass
//@Slf4j
//public class CarSourceConsumerAction {
//
//    @Autowired
//    private SupplyModelsDtlService supplyModelsDtlService;
//
//    @MqConsumerStore(queueName = "mq.carsource.service.enterCarSourcePool", producerGroup = "yiautos-carsource")
//    public void enterCarSourcePool(String data) {
//        if (Func.isBlank(data)) {
//            return;
//        }
//        log.info("录入车源库的消息:{}", data);
//        List<CarSourceEnterQuery> list = JSONObject.parseArray(data, CarSourceEnterQuery.class);
//        supplyModelsDtlService.enterCarSourcePool(list);
//    }
//
//    @MqConsumerStore(queueName = "mq.carsource.service.deleteCarSource", producerGroup = "yiautos-carsource")
//    public void batchDeleteCarSource(String data) {
//        if (Func.isBlank(data)) {
//            return;
//        }
//        log.info("删除车源的消息:{}", data);
//        CarSourceDeleteQuery query = JSONObject.parseObject(data, CarSourceDeleteQuery.class);
//        supplyModelsDtlService.batchDeleteCarSource(query);
//    }
//}
