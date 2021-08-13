package org.lvwj.service.order.outbound.adapter.publisher;

//代码演示说明：MQ发布者的使用举例

//import com.yiautos.dmt.sdk.mq.annotation.MqProducerStore;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springblade.sync.constant.BeiSenConstant;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * 通知发送到MQ的处理器
// * @author males
// */
//@Slf4j
//@Component
//@AllArgsConstructor
//public class SyncMqProducer {
//
//    /**
//     * 同步人员后回调通知部门需要修改负责人
//     * @param deptIdList
//     */
//    @MqProducerStore(producerGroup = BeiSenConstant.SYNC_DEPT_PERSON_IN_CHARGE_CALLBACK,
//            queueName = BeiSenConstant.SYNC_DEPT_PERSON_IN_CHARGE_CALLBACK_QUEUE_NAME)
//    public void syncDeptPersonInChargeCallback(List<String> deptIdList) {
//    }
//}
