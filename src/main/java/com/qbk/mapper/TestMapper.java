package com.qbk.mapper;

import com.qbk.entity.TestInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
 *
 * 需要注意的是：这个接口中不可以定义同名的方法，因为会生成相同的id
 * 也就是说这个接口是不支持重载的
 */
@Mapper
public interface TestMapper {

    /**
     * 测试
     * @return TestInfo
     */
    List<TestInfo> getTest();

    int addTest(TestInfo testInfo);

    @Delete("delete from t_test where id = #{id} ")
    int deleteTest(Integer id);
}
