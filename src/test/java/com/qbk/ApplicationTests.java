package com.qbk;

import com.qbk.entity.TestInfo;
import com.qbk.entity.TestVo;
import com.qbk.kafka.MsgConsumer;
import com.qbk.kafka.MsgProducer;
import com.qbk.mapstuct.ToVoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private MsgProducer msgProducer ;



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


	@Test
	public void kafkaTest(){
		//msgProducer.send();

		for (int i = 10; i < 20; i++) {
			log.info("Hello---" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}


}
