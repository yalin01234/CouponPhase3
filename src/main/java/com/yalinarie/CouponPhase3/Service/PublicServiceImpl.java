package com.yalinarie.CouponPhase3.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.yalinarie.CouponPhase3.Bean.Coupon;
import com.yalinarie.CouponPhase3.Bean.Customer;
import com.yalinarie.CouponPhase3.repo.CouponRepository;
import com.yalinarie.CouponPhase3.repo.CustomerRepository;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PublicServiceImpl implements PublicService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CouponRepository couponRepository;

	@Override
	@Transactional
	public void register(Customer customer) throws Exception {
		customerRepository.save(customer);
	}

	@Override
	@Transactional
	public List<Coupon> getAllCoupons() throws Exception {
		List<Coupon> coupons = couponRepository.findAll();
		return coupons;
	}

}
