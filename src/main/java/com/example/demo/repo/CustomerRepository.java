package com.example.demo.repo;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.*;
@CrossOrigin(origins = "http://localhost:4200")
public interface CustomerRepository extends CrudRepository< Customer, Long> {
	List<Customer> findBylastname(String lastname);

}
