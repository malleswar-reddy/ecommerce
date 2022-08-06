package com.ecommerce.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.model.Account;
import com.ecommerce.service.AccountService;
import com.ecommerce.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private AccountService accountService;

	
	@GetMapping("/login")
	public String loginPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return login(request,response,model);
	}
	
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Account account = getAccountCookie(request);
		if (account == null) {
			// Check if account login first time or not.
			return checkLoginAccountFirstTime(request, response);
		} else {
			// Execute login if exist account cookie.
			return executeLogin(request, response, account);
		}
	}

	private String executeLogin(HttpServletRequest request, HttpServletResponse response, Account account) {
		// Get the status of remember me checkbox.
		HttpSession session = request.getSession();
		boolean rememberMe = (request.getParameter("remember-me-checkbox") != null);

		session.setAttribute("account", account);
		if (rememberMe) {
			Cookie usernameCookie = new Cookie("username", account.getUsername());
			usernameCookie.setMaxAge(600);
			response.addCookie(usernameCookie);

			Cookie passwordCookie = new Cookie("password", account.getPassword());
			passwordCookie.setMaxAge(600);
			response.addCookie(passwordCookie);
		}

		return "index";
		// response.sendRedirect("/ecommerce");

	}

	private String checkLoginAccountFirstTime(HttpServletRequest request, HttpServletResponse response) {
		// Check status is typed wrong input or not.
		String status = "";
		if (request.getParameter("status") != null) {
			status = request.getParameter("status");
		}
		// Get the submitted username and password.
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Check account in database.
		Account account = loginService.checkLoginAccount(username, password);
		if (account == null && status.equals("typed")) {
			// An alert to send to login page.
			String alert = "<div class=\"alert alert-danger wrap-input100\">\n"
					+ "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n"
					+ "                            Wrong username or password!\n" + "                        </p>\n"
					+ "                    </div>";
			// Set attribute for alert tag in login.jsp page.
			request.setAttribute("alert", alert);
			// Resend to login page.
			return "login";
		} else if (account == null) {
			// Send to login page if the user have not typed input yet.
			return "login";
		} else {
			// Login when all information are correct.
			return	executeLogin(request, response, account);
		}

	}

	private Account getAccountCookie(HttpServletRequest request) {
		// Get list cookies of the browser.
		Cookie[] cookies = request.getCookies();

		Account account;
		String username = "";
		String password = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				username = cookie.getValue();
			}
			if (cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
		}
		account = accountService.checkLoginAccount(username, password);
		return account;
	}

}
