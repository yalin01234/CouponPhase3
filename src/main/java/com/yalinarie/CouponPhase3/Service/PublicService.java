package com.yalinarie.CouponPhase3.Service;

import java.util.List;

import com.yalinarie.CouponPhase3.Bean.Coupon;
import com.yalinarie.CouponPhase3.Bean.Customer;

public interface PublicService {

	public void register(Customer customer) throws Exception;

	public List<Coupon> getAllCoupons() throws Exception;

}
