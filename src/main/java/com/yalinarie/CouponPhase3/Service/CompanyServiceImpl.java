package com.yalinarie.CouponPhase3.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.yalinarie.CouponPhase3.Bean.ClientType;
import com.yalinarie.CouponPhase3.Bean.Company;
import com.yalinarie.CouponPhase3.Bean.Coupon;
import com.yalinarie.CouponPhase3.repo.CompanyRepository;
import com.yalinarie.CouponPhase3.repo.CouponRepository;
import com.yalinarie.CouponPhase3.repo.CustomerRepository;

public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CouponRepository couponRepository;

	private ClientType clientType = ClientType.COMPANY;

	private Company company;

	@Override
	@Transactional
	public void addCoupon(Coupon coupon) throws Exception {

		// couponRepository.save(coupon);
		List<Coupon> companyCoupons = getAllCompanyCoupons();
		companyCoupons.add(coupon);
		this.company.setCoupons(companyCoupons);
		companyRepository.save(this.company);

	}

	@Override
	@Transactional
	public void removeCoupon(Coupon coupon) throws Exception {
		List<Coupon> companyCoupons = getAllCompanyCoupons();
		companyCoupons.remove(coupon);
		this.company.setCoupons(companyCoupons);
		companyRepository.save(this.company);
		couponRepository.delete(coupon);

	}

	@Override
	@Transactional
	public void updateCoupon(Coupon coupon) throws Exception {
		couponRepository.save(coupon);

	}

	@Override
	@Transactional
	public Company getCompany(long companyId) throws Exception {
		Company company = companyRepository.findByCompanyId(companyId);
		return company;
	}

	@Override
	@Transactional
	public List<Company> getAllCompany() throws Exception {
		List<Company> Companies = companyRepository.findAll();

		return Companies;
	}

	@Override
	@Transactional
	public Company getCompany(String compName) throws Exception {
		Company company = companyRepository.findByCompName(compName);
		return company;
	}

	@Override
	@Transactional
	public List<Coupon> getAllCompanyCoupons() throws Exception {
		List<Coupon> coupons = couponRepository.findAllByCompanyId(getCompany().getCompanyId());
		return coupons;
	}

	@Transactional
	public void setCompany(Company company) {
		this.company = company;
	}

	@Transactional
	public Company getCompany() {
		return this.company;
	}
}
