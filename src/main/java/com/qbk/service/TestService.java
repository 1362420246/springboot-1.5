package com.qbk.service;

import com.qbk.entity.TestInfo;

import java.util.List;

/**
 * @Author: quboka
 * @Date: 2018/10/23 23:01
 * @Description: 测试
 */
public interface TestService {

    /**
     * 测试
     * @return TestInfo
     */
    public List<TestInfo> getTest();

    public int addTest(TestInfo testInfo);

    public int deleteTest(Integer id);
}
