package com.yalinarie.CouponPhase3.Bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "CouponJPATable")
public class Coupon {

	public Coupon(long id, String title, Date startDate, Date endDate, int amount, CouponType type, String message,
			double price, String image, long companyId, boolean isActive) {

		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.type = type;
		this.message = message;
		this.price = price;
		this.image = image;
		this.companyId = companyId;
		this.isActive = isActive;
	}

	public Coupon() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column
	private long id;

	@Basic(optional = false)
	// @Column(nullable = false , unique = true)
	@Column
	private @NonNull String title;

	@Basic(optional = false)
	@Column
	private @NonNull Date startDate;

	@Basic(optional = false)
	@Column
	private @NonNull Date endDate;

	@Basic(optional = false)
	@Column(nullable = false)
	private @NonNull int amount;

	@Basic(optional = false)
	@Column
	@Enumerated(EnumType.STRING)
	private @NonNull CouponType type;

	@Basic(optional = false)
	@Column
	private @NonNull String message;

	@Basic(optional = false)
	@Column
	private @NonNull double price;

	@Basic(optional = false)
	@Column
	private @NonNull String image;

	@Basic(optional = false)
	@Column
	private @NonNull long companyId;

	@Basic(optional = false)
	@Column
	private @NonNull boolean isActive;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public CouponType getType() {
		return type;
	}

	public void setType(CouponType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}