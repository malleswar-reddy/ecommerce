package com.ecommerce.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.model.Account;
import com.ecommerce.service.AccountService;

@Controller
public class ProfileController {
	
	@Autowired
	private AccountService accountService;

   @GetMapping("/profile-page")
    protected String profilePage() {
       return "profile-page";
    }

    @PostMapping("/profile")
    protected String profileDetails(HttpServletRequest request, HttpServletResponse response,ModelMap model){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        int accountId = account.getId();
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Set default profile image for account.
        InputStream inputStream = null;
		try {
			Part part = request.getPart("profile-image");
			inputStream = part.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println(accountId + " " + firstName + " " + lastName + " " + address + " " + email + " " + phone);

        accountService.editProfileInformation(accountId, firstName, lastName, address, email, phone, inputStream);
        return "login";
    }
}
