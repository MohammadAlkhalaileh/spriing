package com.websystique.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.websystique.springmvc.model.Global;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserProfileService;
import com.websystique.springmvc.service.UserService;

@Controller
@RequestMapping("/")

@SessionAttributes("roles")
public class AppController extends AbstractController {


	@Autowired
	UserService userService;

	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	
	
	
	
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.setValidator(userFormValidator);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(LocalDate.class, "manager.dateOfBirth", new CustomDateEditor(dateFormat, false));

		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dateTimeFormat.setLenient(false);
		binder.registerCustomEditor(DateTime.class, "manager.dateOfHire", new CustomDateEditor(dateTimeFormat, false));
		
	}

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
//	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String loginPageLoader(ModelMap model ) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		
		return LOGIN;
	}

	@RequestMapping(value = { LOGIN }, method = RequestMethod.POST)
	public String validateUser(User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return LOGIN;
		}
		
		User tempUser = userService.findBySSO(user.getSsoId());
		if (tempUser == null) {
			FieldError usernameError = new FieldError("user", "username",
					messageSource.getMessage("NotFound.user.username", new String[] { user.getSsoId() }, Locale.getDefault()));
			result.addError(usernameError);
			return LOGIN;
		}
		else if (!tempUser.equals(user)) {
			FieldError passwordError = new FieldError("user", "password",
					messageSource.getMessage("Mismatch.user.password", new String[] { user.getSsoId() }, Locale.getDefault()));
			result.addError(passwordError);
			return LOGIN;
		} else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String indexPageLoader(ModelMap model,HttpServletRequest req) {
		model.addAttribute("loggedinuser", getPrincipal());    
		//req.getSession().setAttribute("username", getPrincipal());
		
		HttpSession httpSession=req.getSession();
		
		int count=Global.getCount();
//		session.getUser();
//		global.setCount(count);
		
		model.addAttribute("total", count);
		httpSession.setAttribute("toot", count);
		
		return INDEX;
		}
	////////////////////////////////////////////Spring Security////////////////////////////////////////////////
	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return ACCESSDENIED;
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String loginPage2() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login2";
	    } else {
	    	return "redirect:/index";  
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);	
		}
//		 Global.decreaseCount();
		request.getSession().invalidate();
		//global.setCount(count);
		
		return "redirect:/login2?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 * Methods in controller class are trivial. Method getPrincipal is a generic function which returns the logged in user name from 
	 * Spring SecurityContext. Method logoutPage handles the logging out with a simple call to 
	 * SecurityContextLogoutHandler().logout(request, response, auth);. 
	 * It’s handy and saves you from putting cryptic logout logic in your JSP’s which is not really manageable. 
	 * You might have noticed that ‘/login’ is missing, it is because it will be generated and handled by default by Spring Security.
	 */
//	private String getPrincipal(){
//		String userName = null;
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof UserDetails) {
//			userName = ((UserDetails)principal).getUsername();
//		} else {
//			userName = principal.toString();
//		}
//		return userName;
//	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}

}
