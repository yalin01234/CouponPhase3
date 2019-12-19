package com.yalinarie.CouponPhase3.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerJPATable")

public class Customer {
	public Customer(long id, String customerName, String password) {

		this.id = id;
		this.customerName = customerName;
		this.password = password;
	}

	public Customer() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(nullable = false)
	private long id;

	@Basic(optional = false)
	@Column(nullable = false)
	private String customerName;

	@Basic(optional = false)
	@Column(nullable = false)
	private String password;

	// import javax.persistence.*;
	// import java.util.ArrayList;
	// import java.util.List;

	// @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "Customer_Coupon", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = {
			@JoinColumn(name = "coupon_id") })
	// private List<Coupon> coupons = new ArrayList<>();

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", password=" + password + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private List<Coupon> coupons = new ArrayList<>();

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	public List<Coupon> getCoupons() {
		// TODO Auto-generated method stub
		return coupons;
	}

}