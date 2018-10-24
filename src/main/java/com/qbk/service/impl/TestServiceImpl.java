package com.qbk.service.impl;

import com.qbk.entity.TestInfo;
import com.qbk.mapper.TestMapper;
import com.qbk.service.TestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: quboka
 * @Date: 2018/10/23 23:02
 * @Description: 测试
 */
@Log4j2
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestMapper testMapper ;

    @Override
    public List<TestInfo> getTest() {
        List<TestInfo> list = testMapper.getTest();
        log.info("测试："+list);
        //int i = 10/0 ;
        return list;
    }

    @Override
    public int addTest(TestInfo testInfo) {
        return testMapper.addTest(testInfo);
    }

    @Override
    public int deleteTest(Integer id) {
        return testMapper.deleteTest(id);
    }
}
