package com.assessment.shoppe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.assessment.shoppe.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.id = :id")
	public Product getById(@Param("id") int id);
	
	@Query("SELECT p FROM Product p WHERE p.code = :code")
	public Product getByCode(@Param("code") String code);
	
	//	@Query()
//	public Product findProductById(@Param int id){
//		//return productRepo.findProductById(id);
//	}
//	
//	@Query()
//	public Product findProductByCode(@Param String code){
//		//return productRepo.findProductByCode(code);
//	}
}