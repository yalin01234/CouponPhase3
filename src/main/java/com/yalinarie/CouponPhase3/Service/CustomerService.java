package com.yalinarie.CouponPhase3.Service;

import java.util.List;

import com.yalinarie.CouponPhase3.Bean.Coupon;
import com.yalinarie.CouponPhase3.Bean.CouponType;
import com.yalinarie.CouponPhase3.Bean.Customer;

public interface CustomerService {

	public Customer getCustomers(Long CustomerID) throws Exception;

	public Customer getCustomersname(String customerName) throws Exception;

	public void SetCustomer(Customer customer) throws Exception;

	public void purchaseCoupon(Coupon coupon) throws Exception;

	public List<Coupon> getAllPurchaseCoupons() throws Exception;

	public List<Coupon> getAllAvailableCoupons() throws Exception;

	public Customer getCustomerspassword(String password) throws Exception;

	public Coupon getAvailableCouponById(long couponId) throws Exception;

	public List<Coupon> getAllAvailableCouponsByType(CouponType couponType) throws Exception;

}
