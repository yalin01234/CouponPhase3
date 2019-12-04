package com.yalinarie.CouponPhase3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yalinarie.CouponPhase3.Bean.Customer;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findCustomerById(long customerId);

	public Customer findCustomerByCustomerName(String customerName);

	public Customer findByCustomerNameAndAndPassword(String name, String password);

	public boolean existsById(long id);

}
