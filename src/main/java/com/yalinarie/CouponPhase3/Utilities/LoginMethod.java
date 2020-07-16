package com.yalinarie.CouponPhase3.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.yalinarie.CouponPhase3.Bean.ClientType;
import com.yalinarie.CouponPhase3.Bean.Company;
import com.yalinarie.CouponPhase3.Bean.Customer;
import com.yalinarie.CouponPhase3.Service.AdminService;
import com.yalinarie.CouponPhase3.Service.CompanyService;
import com.yalinarie.CouponPhase3.Service.CouponClient;
import com.yalinarie.CouponPhase3.Service.CustomerService;
import com.yalinarie.CouponPhase3.repo.CompanyRepository;
import com.yalinarie.CouponPhase3.repo.CustomerRepository;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginMethod {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CompanyRepository companyRepository;

	public CouponClient login(String userName, String password, ClientType clientType) {

		try {
			switch (clientType) {

			case ADMIN:
				if (userName.equals("admin") && password.equals("1234")) {
					// AdminService adminServiceBean = ctx.getBean(AdminServiceImpl.class);
					System.out.println("***** test");
					return (CouponClient) adminService;

				} else {
					System.out.println("null after inputs  (LoginMethod.Class)  ");
					return null;
				}
			case COMPANY:
				Company company = companyRepository.findByCompNameAndPassword(userName, password);
				if (company != null) {
					CompanyService companyServiceBean = companyService;
					companyServiceBean.setCompany(company);
					System.out.println("Company " + company.getCompName() + " logged in to system");
					return (CouponClient) companyServiceBean;
				} else {
					System.out.println("null after inputs  (LoginMethod.Class)  ");
					return null;
				}
			case CUSTOMER:
				Customer customer = customerRepository.findByCustomerNameAndAndPassword(userName, password);
				if (customer != null) {
					CustomerService customerServiceBean = customerService;
					customerServiceBean.setCustomer(customer);
					System.out.println("Customer " + customer.getCustomerName() + " logged in to system");
					return (CouponClient) customerServiceBean;
				} else {
					System.out.println("null after inputs  (LoginMethod.Class)  ");
					return null;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		System.out.println("null return after inputs ...");
		return null;
	}

}