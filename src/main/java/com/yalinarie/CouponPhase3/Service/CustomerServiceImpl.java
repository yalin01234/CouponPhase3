package com.yalinarie.CouponPhase3.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.yalinarie.CouponPhase3.Bean.ClientType;
import com.yalinarie.CouponPhase3.Bean.Coupon;
import com.yalinarie.CouponPhase3.Bean.CouponType;
import com.yalinarie.CouponPhase3.Bean.Customer;
import com.yalinarie.CouponPhase3.repo.CompanyRepository;
import com.yalinarie.CouponPhase3.repo.CouponRepository;
import com.yalinarie.CouponPhase3.repo.CustomerRepository;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerServiceImpl implements CustomerService, CouponClient {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CouponRepository couponRepository;

	private Customer customer;

	private Coupon coupon;

	@Override
	@Transactional

	public CouponClient login(String userName, String password, ClientType clientType) {

		return null;
	}

	@Override
	@Transactional
	public Customer getCustomers(Long CustomerID) throws Exception {
		Customer customer = customerRepository.findCustomerById(CustomerID);
		return customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	@Transactional
	public Customer getCustomersname(String customerName) throws Exception {
		Customer customer = customerRepository.findCustomerByCustomerName(customerName);
		return customer;
	}

	@Override
	@Transactional
	public void purchaseCoupon(Coupon coupon) throws Exception {

		Coupon couponFromDB = couponRepository.findById(coupon.getId());
		if (couponFromDB == null) {
			throw new Exception("Coupon Not Available");
		}
		if (couponFromDB.getAmount() <= 0) {

			throw new Exception("Coupon Not Available");
		}
		if (getAllPurchaseCoupons().contains(couponFromDB)) {
			throw new Exception("Already bought");
		}

		couponRepository.save(coupon);

	}

	@Override
	@Transactional
	public List<Coupon> getAllPurchaseCoupons() throws Exception {

		// List<Coupon> coupons =
		// customerRepository.findOne(this.customer.getId()).getCoupons();
		// return coupons;
		return null;
	}

	@Override
	@Transactional
	public List<Coupon> getAllAvailableCoupons() throws Exception {
		List<Coupon> allCoupons = couponRepository.findAll();
		List<Coupon> customerCoupons = getAllPurchaseCoupons();
		allCoupons.removeAll(customerCoupons);

		List<Coupon> notMyCoupons = allCoupons;
		for (Iterator<Coupon> iterator = notMyCoupons.iterator(); iterator.hasNext();) {
			Coupon coupon = iterator.next();
			// remove from list if out of stock
			if (coupon.getAmount() < 1) {
				iterator.remove();
			}
		}
		return notMyCoupons;

	}

	@Override
	@Transactional
	public Customer getCustomerspassword(String password) throws Exception {
		// Customer customer =
		// customerRepository.findCustomerByCustomerPassword(password);
		// return customer;
		return null;
	}

	@Override
	@Transactional
	public Coupon getAvailableCouponById(long couponId) throws Exception {
		Coupon requestedCoupon = couponRepository.findById(couponId);
		Collection<Coupon> coupons = getAllAvailableCoupons();
		for (Iterator<Coupon> iterator = coupons.iterator(); iterator.hasNext();) {
			Coupon coupon = iterator.next();
			if (coupon.getId() == requestedCoupon.getId()) {
				return requestedCoupon;
			}
		}
		System.out.println("Can't get coupon - not available for this user.");
		return null;
	}

	@Override
	@Transactional
	public List<Coupon> getAllAvailableCouponsByType(CouponType couponType) throws Exception {
		List<Coupon> allAvailableCoupons = getAllAvailableCoupons();
		for (Iterator<Coupon> iterator = allAvailableCoupons.iterator(); iterator.hasNext();) {
			Coupon coupon = iterator.next();
			if (coupon.getType() != couponType) {
				iterator.remove();
			}
		}
		return allAvailableCoupons;
	}

	@Override
	public List<Customer> getAllCustomer() throws Exception {

		List<Customer> AllCustomer = customerRepository.findAll();

		return AllCustomer;
	}

}
