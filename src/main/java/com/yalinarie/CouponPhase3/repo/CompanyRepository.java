package com.yalinarie.CouponPhase3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yalinarie.CouponPhase3.Bean.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	public Company findByCompanyId(long companyId);

	public Company findByCompName(String compName);

	public Company findCompanyByCompanyPassword(String password);

	public Company findCompanyByCompanyPasswordAndCompanyNameAndCompanyId(long companyId, String companyName,
			String password);

	public Company findByCompNameAndPassword(String companyName, String password);

}
