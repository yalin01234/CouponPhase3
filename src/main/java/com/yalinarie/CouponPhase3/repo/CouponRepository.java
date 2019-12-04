package com.yalinarie.CouponPhase3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yalinarie.CouponPhase3.Bean.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	public Coupon findById(long couponId);

	public List<Coupon> findAllByCompanyId(long companyId);

	public List<Coupon> deleteByCompanyId(long companyId);

}