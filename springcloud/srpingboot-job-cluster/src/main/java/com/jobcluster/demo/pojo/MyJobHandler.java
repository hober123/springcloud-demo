package com.jobcluster.demo.pojo;

import org.springframework.stereotype.Component;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;

import lombok.extern.slf4j.Slf4j;

@JobHandler(value = "myJobHandler")
@Component
@Slf4j
public class MyJobHandler extends IJobHandler {
	
	@Override
    public ReturnT<String> execute(String param) {
        
		XxlJobLogger.log("自定义job开始执行。.");
        log.info("开始定时任务执行");
        
        return SUCCESS;
    }

}
