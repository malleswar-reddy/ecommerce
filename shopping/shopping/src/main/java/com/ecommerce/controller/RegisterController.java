package com.ecommerce.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.service.AccountService;
@Controller
public class RegisterController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/viewRegisterPage")
	public String viewRegisterPage() {
	return "register";
	}
	
	@PostMapping("/create")
	public String registerAccount(HttpServletRequest request,ModelMap model) {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String repeatPassword = request.getParameter("repeat-password");
	        Part part = null;
			try {
				part = request.getPart("profile-image");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        InputStream inputStream = null;
			try {
				inputStream = part.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Check password and repeatPassword are the same.
	        if (!password.equals(repeatPassword)) {
	            String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            Incorrect password!\n" +
	                    "                        </p>\n" +
	                    "                    </div>";
	            request.setAttribute("alert", alert);
	            return "register";
	        }
	        // Check username is existed or not from database.
	        else if (accountService.checkUsernameExists(username)) {
	            String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            Username already exist!\n" +
	                    "                        </p>\n" +
	                    "                    </div>";
	            model.addAttribute("alert", alert);
	            return "register";
	        }
	        // Insert username, password to database and create account.
	        else {
	            accountService.createAccount(username, password, inputStream);
	            String alert = "<div class=\"alert alert-success wrap-input100\">\n" +
	                    "                        <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
	                    "                            Create account successfully!\n" +
	                    "                        </p>\n" +
	                    "                    </div>";
	            model.addAttribute("alert", alert);
	            
		return "login";
		}
	}
	
	@GetMapping("/loginpage")
	public String loginPage() {
		return "login";
	}
}
