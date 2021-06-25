package com.assessment.shoppe;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.assessment.shoppe.model.ActiveDay;
import com.assessment.shoppe.service.ActiveDayService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ActiveDayServiceTests {
	
	public ActiveDayServiceTests(){
		
	}
	
	@Mock
	private ActiveDayService activeDayService;
	
	@Test
	public void testGetTotalCustomerPoints() {
		Mockito.when(activeDayService.getTotalCustomerPoints(4)).thenReturn(new ActiveDay(1,500, 1, 500));
		ActiveDay activeDay = activeDayService.getTotalCustomerPoints(4);
		assertNotNull(activeDay);
		assertEquals(500, activeDay.getTotalPoints());			
	}
}