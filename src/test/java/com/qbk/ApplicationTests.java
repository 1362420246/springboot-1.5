package com.qbk;

import com.qbk.entity.TestInfo;
import com.qbk.entity.TestVo;
import com.qbk.mapstuct.ToVoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	//测试mapstuct 实体类转换
	@Test
	public void contextLoads() {
		TestInfo testInfo = TestInfo.builder().id(11).name("kaka").build();
		log.info("mapstuct测试:"+testInfo);
		TestVo testVo = ToVoMapper.MAPPER.testToTestVo(testInfo);
		log.info("mapstuct测试:"+testVo);
		//判断是否相等，可以指定输出错误信息。 第一个参数是期望值，第二个参数是实际的值。
		Assert.assertEquals("比对失败",testInfo.getName(),testVo.getUsername());
	}

}
