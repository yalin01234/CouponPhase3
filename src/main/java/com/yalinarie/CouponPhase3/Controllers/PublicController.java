package com.yalinarie.CouponPhase3.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yalinarie.CouponPhase3.Bean.Coupon;
import com.yalinarie.CouponPhase3.Bean.Customer;
import com.yalinarie.CouponPhase3.Service.PublicService;
import com.yalinarie.CouponPhase3.Utilities.Validations;

public class PublicController {

	@Autowired
	private PublicService publicService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Customer customer) throws Exception {
		if (customer != null) {
			if (!Validations.checkIfCustomerExist(customer)) {
				if (!customer.getCustomerName().contains(" ") && !customer.getPassword().contains(" ")
						&& !customer.getPassword().equals("") && !customer.getCustomerName().equals("")) {
					publicService.register(customer);
					return new ResponseEntity<>("Customer " + customer.getCustomerName() + " registered successfully. ",
							HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Bad request inserted, please try again.", HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<>("Customer already exist", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Null inserted, please try again.", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAllCoupons")
	public ResponseEntity<?> getAllCoupons() throws Exception {
		List<Coupon> couponList = publicService.getAllCoupons();
		if (couponList != null) {
			return new ResponseEntity<>(couponList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No coupons", HttpStatus.NOT_FOUND);
		}
	}

}
