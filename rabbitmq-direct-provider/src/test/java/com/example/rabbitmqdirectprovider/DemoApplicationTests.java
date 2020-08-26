package com.example.rabbitmqdirectprovider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private Sender sender;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() throws Exception {
		while (true) {
			Thread.sleep(2000);
			this.sender.send("HALOW INFO  MQ  MQ  MQ  ");
		}
	}

}
