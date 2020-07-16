package com.yalinarie.CouponPhase3.Service;

import java.util.List;

import com.yalinarie.CouponPhase3.Bean.Company;
import com.yalinarie.CouponPhase3.Bean.Customer;

public interface AdminService {

	public void addCompany(Company company) throws Exception;

	public void removeCompany(Company company) throws Exception;

	public void updateCompany(Company company) throws Exception;

	public Company getCompany(long companyId) throws Exception;

	public Company getCompanybyName(String compName) throws Exception;

	public List<Company> getAllCompanies() throws Exception;

	public void addCustomer(Customer customer) throws Exception;

	public void removeCustomer(Customer customer) throws Exception;

	public void updateCustomer(Customer customer) throws Exception;

	public Customer getCustomer(long customerId) throws Exception;

	public List<Customer> getAllCustomers() throws Exception;

}
