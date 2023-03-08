package org.mac.urax;

import org.junit.jupiter.api.Test;
import org.mac.urax.ctrl.UraxRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UraxApplicationTests {

	@Autowired
	private UraxRestController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
