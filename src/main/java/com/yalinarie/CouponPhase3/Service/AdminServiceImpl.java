package com.yalinarie.CouponPhase3.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.yalinarie.CouponPhase3.Bean.Company;
import com.yalinarie.CouponPhase3.Bean.Customer;
import com.yalinarie.CouponPhase3.repo.CompanyRepository;
import com.yalinarie.CouponPhase3.repo.CouponRepository;
import com.yalinarie.CouponPhase3.repo.CustomerRepository;

public class AdminServiceImpl implements AdminService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CouponRepository couponRepository;

	@Override
	@Transactional
	public void addCompany(Company company) throws Exception {
		companyRepository.save(company);

	}

	@Override
	@Transactional
	public void removeCompany(Company company) throws Exception {
		companyRepository.delete(company);
	}

	@Override
	@Transactional
	public void updateCompany(Company company) throws Exception {
		companyRepository.save(company);
	}

	@Override
	@Transactional
	public Company getCompany(long companyId) throws Exception {
		Company company = companyRepository.findByCompanyId(companyId);
		return company;

	}

	@Override
	@Transactional
	public List<Company> getAllCompanies() throws Exception {
		List<Company> companies = companyRepository.findAll();
		return companies;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) throws Exception {
		customerRepository.save(customer);

	}

	@Override
	@Transactional
	public void removeCustomer(Customer customer) throws Exception {
		customerRepository.delete(customer);

	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) throws Exception {
		customerRepository.save(customer);

	}

	@Override
	@Transactional
	public Customer getCustomer(long customerId) throws Exception {
		Customer customer = customerRepository.findCustomerById(customerId);
		return customer;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() throws Exception {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

}
