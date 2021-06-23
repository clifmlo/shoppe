package com.assessment.shoppe.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.shoppe.model.ActiveDay;
import com.assessment.shoppe.repo.ActiveDayRepository;

@Service
public class ActiveDayService {
	Logger logger = LoggerFactory.getLogger(ActiveDayService.class);
    
	@Autowired
	private ActiveDayRepository activeDayRepo;
	
	@Transactional(readOnly=true)
	public Integer getTotalCustomerPoints(int customerId){	
		
		try{		
			ActiveDay activeDay = activeDayRepo.getByCustomerId(customerId);
			
			if(activeDay != null){				
				logger.info("total customer points : " + activeDay.getTotalPoints());
				return Integer.valueOf(activeDay.getTotalPoints());				
			}else{
				logger.info("No active days found.");
				return null;
			}			
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
