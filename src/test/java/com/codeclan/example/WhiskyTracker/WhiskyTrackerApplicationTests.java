package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;



@RunWith(SpringRunner.class)
@SpringBootTest

public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void findDistByReg(){
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Highland");
		assertEquals("Glendronach",found.get(0).getName());

	}
}
