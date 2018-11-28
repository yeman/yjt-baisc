package com.yjt.basic.controller;

import com.yjt.basic.common.SysUser;
import com.yjt.basic.message.kafka.KafkaProducer;
import com.yjt.basic.search.solr.SolrCloudRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description "TODO"
 * @Author :ym
 * @Date: 2018/11/26 11:40
 **/
@Api(value="/test",tags = "测试类")
@RestController
@RequestMapping(value = "/test")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private SolrCloudRepository solrCloudRepository;

    @ApiOperation(value = "测试",notes = "测试")
    @RequestMapping(value = "/sendMsg",method = RequestMethod.GET)
    @ResponseBody
    public void  sendMsg(@RequestParam String topic,@RequestParam String msg){
        String test = "";
        System.out.println(msg);
        logger.info(msg);
       /* kafkaProducer.sendMsg(topic, msg, new SuccessCallback() {
            @Override
            public void onSuccess(Object result) {
                logger.info(""+result);
            }
        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info(""+ex.getMessage());
            }
        });*/
    }

    @ApiOperation(value = "测试solr索引",notes = "测试solr索引")
    @RequestMapping(value = "/testSolrIndex",method = RequestMethod.GET)
    @ResponseBody
    public void  testSolrIndex(@RequestBody SysUser sysUser) throws Exception {
        solrCloudRepository.saveSolrData(sysUser,true);
    }

}
