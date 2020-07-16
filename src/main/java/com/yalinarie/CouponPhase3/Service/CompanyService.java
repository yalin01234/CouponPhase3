package com.yalinarie.CouponPhase3.Service;

import java.util.List;

import com.yalinarie.CouponPhase3.Bean.Company;
import com.yalinarie.CouponPhase3.Bean.Coupon;

public interface CompanyService {

	public void addCoupon(Coupon coupon) throws Exception;

	public void removeCoupon(Coupon coupon) throws Exception;

	public void updateCoupon(Coupon coupon) throws Exception;

	public Company getCompany(long companyId) throws Exception;

	public Coupon getCoupon(long coponId) throws Exception;

	public List<Coupon> getAllCompanyCoupons() throws Exception;

	public List<Company> getAllCompany() throws Exception;

	public Company getCompany(String compName) throws Exception;

	public Company getCompany();

	public void setCompany(Company company);

}
