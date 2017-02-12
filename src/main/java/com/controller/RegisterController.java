package com.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.model.User;

@SuppressWarnings("serial")
@Controller
public class RegisterController implements Serializable, Cloneable {

	@Autowired
	private UserDao userDao;
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/registerform", method = RequestMethod.GET)
	public ModelAndView getRegisterForm() {
		return new ModelAndView("register");

	}

	@RequestMapping(value = "/submitRegisterform", method = RequestMethod.POST)
	public ModelAndView submitAdmission(@ModelAttribute("user") User user) {
		String generatedkey = RandomStringUtils.random(10, new char[] { 'a',
				'b', 'c', 'd' });
		user.setRandomkey(generatedkey);

		String email = user.getEmail();
		User user1 = userDao.verifyUserEmail(email);
		if (user1 != null) {
			return new ModelAndView("emailVerify");

		} else {

			/*
			 * System.out.println(user.getFirstname());
			 * System.out.println(user.getLastname());
			 * System.out.println(user.getEmail());
			 * System.out.println(user.getPassword());
			 * test
			 */

			userDao.saveUser(user);

			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(user.getEmail());
			simpleMailMessage.setSubject("User Activation Link");
			String body = "hello " + user.getFirstname() + "," + "\n"
					+ "Click the below link to Activate your Account ";
			String url = "http://localhost:8081/MailVerification/activate?randomkey="
					+ generatedkey;
			body = body + "\n" + url;
			simpleMailMessage.setText(body);

			// sends the e-mail

			mailSender.send(simpleMailMessage);
			return new ModelAndView("registersuccess");
		}
	}

	@RequestMapping(value = "/activate**", method = RequestMethod.GET)
	public ModelAndView activeteAccount(HttpServletRequest httpRequest) {

		String randomkey = (String) httpRequest.getParameter("randomkey");
		// System.out.println("user activated= "+randomkey);
		User user = userDao.getUserWithKey(randomkey);
		if (user.getActive() == 1) {
			return new ModelAndView("alreadyActivated");
		} else {
			user.setActive(1);
			userDao.updateUser(user);
			return new ModelAndView("successaccount");
		}
	}

	@RequestMapping("/listUserAccounts")
	public ModelAndView getAllInfo() {
		List<User> list = userDao.getAllUserAccounts();
		return new ModelAndView("userAccountList", "user", list);
	}

	@RequestMapping(value = "/editUser/{id}")
	public ModelAndView edit(@PathVariable int id) {
		User user = userDao.getUserById(id);
		return new ModelAndView("usereditform", "command", user);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("user") User user) {
		user.setActive(1);
		userDao.updateUser(user);
		return new ModelAndView("redirect:/listUserAccounts");

	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		userDao.deleteUser(id);
		return new ModelAndView("redirect:/listUserAccounts");
	}

	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView getAllInfo1() {
		List<User> list = userDao.getAllUserAccounts();
		return new ModelAndView("excelView", "list", list);
	}
}
