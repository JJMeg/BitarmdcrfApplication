package com.bit.armdcrf;

import com.bit.armdcrf.service.Interface.CrfWordResolve;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BitarmdcrfApplicationTests {
	@Autowired
	private CrfWordResolve wordResolve;

	@Test
	public void contextLoads() {
		wordResolve.toString();

	}




}
