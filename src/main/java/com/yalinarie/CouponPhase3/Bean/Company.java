package com.yalinarie.CouponPhase3.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "CompanyJPATable")
public class Company {

	private String compName;
	private long companyId;
	private String password;
	private String email;

	public Company() {
	}

	@Id
	@GeneratedValue
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public Company(String compName, long companyId, String password, String email) {

		this.compName = compName;
		this.companyId = companyId;
		this.password = password;
		this.email = email;
	}

	@Column
	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	@Column
	public String getPassword() {
		return password;
	}

	@Column
	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private List<Coupon> coupons = new ArrayList<>();

	// @Entity
	// @Data
	// @NoArgsConstructor
	// @AllArgsConstructor
	// public class Company {
	//
	// @Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	// @Basic(optional = false)
	// @Column(nullable = false)
	// private long companyId;
	//
	// @Basic(optional = false)
	//// @Column(nullable = false , unique = true)
	// @Column(nullable = false)
	// private String compName;
	//
	// @Basic(optional = false)
	// @Column(nullable = false)
	// private String password;
	//
	// @Basic(optional = false)
	// @Column(nullable = false)
	// private String email;
	//
	//// @ToString.Exclude
	//// @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
	//// private List<Coupon> coupons = new ArrayList<>();
	//
	// // @ToString.Exclude
	// @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	// @JoinTable(
	// name = "Company_Coupon",
	// joinColumns = { @JoinColumn(name= "company_id") },
	// inverseJoinColumns = { @JoinColumn(name = "coupon_id") }
	// )
	// private List<Coupon> coupons = new ArrayList<>();

}
