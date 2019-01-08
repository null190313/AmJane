package org.lxrookie.start.substance.controller;

import org.lxrookie.start.substance.services.UserCustomerOperationTopicServices;
import org.lxrookie.start.substance.services.component.kafka.KafkaComponentProducerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *------------------------------.
 * @name : UserCustomerOperationTopicController
 * @author : 沐惜
 * @createTime : 2018/11/30 18:30
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@RestController
@RequestMapping(value = "/logs")
public class UserCustomerOperationTopicController {

    @Autowired
    private KafkaComponentProducerServices kafkaComponentProducerServices;
    @Autowired
    private UserCustomerOperationTopicServices userCustomerOperationTopicServices;

        @PostMapping(value = "/theUserLoginRecord.html")
        public String theUserLoginRecord(@RequestParam(name="logRecordEntity",required=true) String logRecordEntity){
            return userCustomerOperationTopicServices.theUserLoginInToRegisterOperation(logRecordEntity);
        }


        @GetMapping(value = "/testCloudFeignClient.html")
        public void testFegin(String testStr){
            System.out.println("testStr="+testStr);
        }

}
