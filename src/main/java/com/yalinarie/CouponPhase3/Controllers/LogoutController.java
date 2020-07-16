package com.yalinarie.CouponPhase3.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class LogoutController {

	@Autowired
	private HttpServletRequest request;

	@GetMapping("/logout")
	public ResponseEntity<?> logout() throws Exception {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("service1");
			session.invalidate();
			System.out.println("Logout DEBUG");
			return new ResponseEntity<>("You logged out successfully !", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Could not log out ", HttpStatus.BAD_REQUEST);

		}
	}
}
