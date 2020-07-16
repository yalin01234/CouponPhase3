package com.yalinarie.CouponPhase3.Utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yalinarie.CouponPhase3.Bean.Company;
import com.yalinarie.CouponPhase3.Bean.Coupon;
import com.yalinarie.CouponPhase3.Bean.Customer;
import com.yalinarie.CouponPhase3.repo.CompanyRepository;
import com.yalinarie.CouponPhase3.repo.CouponRepository;
import com.yalinarie.CouponPhase3.repo.CustomerRepository;

@Component
public class Validations {

	private static CompanyRepository companyRepository;

	private static CustomerRepository customerRepository;

	private static CouponRepository couponRepository;

	@Autowired
	public Validations(CompanyRepository companyRepository, CustomerRepository customerRepository) {
		Validations.companyRepository = companyRepository;
		Validations.customerRepository = customerRepository;
	}

	public static boolean checkIfCouponExist(Coupon coupon) throws Exception {
		boolean couponExist = false;
		List<Coupon> allCoupons = new ArrayList<Coupon>();
		allCoupons = couponRepository.findAll();
		Iterator<Coupon> itr = allCoupons.iterator();
		while (itr.hasNext()) {
			Coupon tempCoupon = new Coupon();
			tempCoupon = itr.next();
			if (tempCoupon.getImage().equals(coupon.getImage())) {
				couponExist = true;
				return couponExist;
			}
		}
		return couponExist;

	}

	public static boolean checkIfCustomerExist(Customer customer) throws Exception {
		boolean customerExist = false;

		List<Customer> allCustomers = new ArrayList<Customer>();
		allCustomers = customerRepository.findAll();
		System.out.println(allCustomers);
		Iterator<Customer> itr = allCustomers.iterator();

		while (itr.hasNext()) {
			Customer tempCustomer = new Customer();
			tempCustomer = itr.next();
			if (tempCustomer.getCustomerName().equals(customer.getCustomerName())) {
				customerExist = true;

				return customerExist;
			}
		}
		return customerExist;
	}

	public static boolean checkIfCompanyExist(Company company) throws Exception {
		boolean companyExist = false;
		List<Company> allCompanies = new ArrayList<>();// Import all the companies from the DB.
		allCompanies = companyRepository.findAll(); // //Import all the companies from the DB.
		Iterator<Company> itr = allCompanies.iterator();// The aim of Iterator is to import the object form the DB till
														// the last one.

		while (itr.hasNext()) {
			Company tempCompany = new Company();
			tempCompany = itr.next();
			if (tempCompany.getCompName().equals(company.getCompName())) {
				companyExist = true;
				return companyExist;
			}
		}
		return companyExist; // In case company doesnt exist will return false.
	}

}