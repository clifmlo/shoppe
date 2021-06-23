package com.assessment.shoppe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.assessment.shoppe.model.ActiveDay;

@Repository
public interface ActiveDayRepository extends CrudRepository<ActiveDay, Integer> {
	@Query("SELECT a FROM ActiveDay a WHERE a.customerId = :customerId")
	public ActiveDay getByCustomerId(@Param("customerId") int customerId);
}
