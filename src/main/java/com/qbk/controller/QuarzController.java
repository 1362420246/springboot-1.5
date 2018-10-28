package com.qbk.controller;


import com.qbk.quarz.job.GrdbJob;
import com.qbk.quarz.manager.QuartzManager;
import com.qbk.quarz.util.TimeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: quboka
 * @Date: 2018/10/19 10:39
 * @Description:
 */
@RestController
@RequestMapping("/quarz")
public class QuarzController {

    @Resource
    private QuartzManager quartzManager ;

    /**
     * 添加
     * @param jobGroupName
     * @param jobName
     * @param param
     * @return
     */
    @GetMapping("/add/{jobGroupName}/{jobName}")
    public String add(@PathVariable("jobGroupName") String jobGroupName ,@PathVariable("jobName") String jobName,String param){
        try {

            String cron = TimeUtil.getCron(new Date());
            quartzManager.addJob(jobName, jobGroupName , GrdbJob.class, "0/1 * * * * ?", param);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "ss" ;

    }

    /**
     * 删除
     * @param jobGroupName
     * @param jobName
     * @return
     */
    @GetMapping("/delete/{jobGroupName}/{jobName}")
    public String delete(@PathVariable("jobGroupName") String jobGroupName ,@PathVariable("jobName") String jobName){
        try {
            quartzManager.removeJob(jobName, jobGroupName , jobName, jobGroupName );
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "ss" ;
    }

    /**
     * 暂停
     * @param jobGroupName
     * @param jobName
     * @return
     */
    @GetMapping("/pause/{jobGroupName}/{jobName}")
    public String pauseJob(@PathVariable("jobGroupName") String jobGroupName ,@PathVariable("jobName") String jobName){
        try {
            quartzManager.pauseJob(jobName, jobGroupName );
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "ss" ;
    }

    /**
     * 恢复
     * @param jobGroupName
     * @param jobName
     * @return
     */
    @GetMapping("/resume/{jobGroupName}/{jobName}")
    public String resumeJob(@PathVariable("jobGroupName") String jobGroupName ,@PathVariable("jobName") String jobName){
        try {
            quartzManager.resumeJob(jobName, jobGroupName );
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "ss" ;
    }
}
