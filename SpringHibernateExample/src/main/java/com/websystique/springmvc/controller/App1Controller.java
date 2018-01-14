package com.websystique.springmvc.controller;

//import java.text.SimpleDateFormat;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.joda.time.DateTime;
//import org.joda.time.LocalDate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Scope;
//import org.springframework.security.authentication.AuthenticationTrustResolver;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import com.websystique.springmvc.comparators.EmployeeSalaryComparator;
//import com.websystique.springmvc.model.Employee;
//import com.websystique.springmvc.model.LoggUserName;
//import com.websystique.springmvc.model.User;
//import com.websystique.springmvc.model.UserProfile;
//import com.websystique.springmvc.service.EmployeeService;
//import com.websystique.springmvc.service.UserProfileService;
//import com.websystique.springmvc.service.UserService;
//
//@Controller
////@Scope("session")
////@Scope("singleton")
////@Scope("prototype")
////@Scope("global")
//@RequestMapping("/")
//@SessionAttributes("roles")
//public class App1Controller extends AbstractController {
//
//	@Autowired
//	EmployeeService employeeService;
//	
//	@Autowired
//	UserService userService;
//
//	@Autowired
//	UserProfileService userProfileService;
//	
//	@Autowired
//	MessageSource messageSource;
//
//	@Autowired
//	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
//	
//	@Autowired
//	AuthenticationTrustResolver authenticationTrustResolver;
//	
//	@Autowired
//	LoggUserName loggUserName;
//	
//	@Autowired
//	LoggUserName loggUserName2;
//
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(LocalDate.class, "manager.dateOfBirth", new CustomDateEditor(dateFormat, false));
//
//		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		dateTimeFormat.setLenient(false);
//		binder.registerCustomEditor(DateTime.class, "manager.dateOfHire", new CustomDateEditor(dateTimeFormat, false));
//	}
//
//	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
//	public String loginPageLoader(ModelMap model ) {
//		User user = new User();
//		model.addAttribute("user", user);
//		model.addAttribute("edit", false);
//		
//		return LOGIN;
//	}
//
//	@RequestMapping(value = { "/index2" }, method = RequestMethod.GET)
//	public String indexPageLoader(ModelMap model,HttpServletRequest req) {
//		model.addAttribute("loggedinuser", getPrincipal());    
//		req.getSession().setAttribute("username", getPrincipal());
//		loggUserName.setLoginuser(getPrincipal());
//		model.addAttribute("testuser", loggUserName);
//		model.addAttribute("testuser2", loggUserName2);
//		return INDEX;
//	}
//
//	@ModelAttribute("roles")
//	public List<UserProfile> initializeProfiles() {
//		return userProfileService.findAll();
//	}
//	
//	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
//	public String accessDeniedPage(ModelMap model) {
//		model.addAttribute("loggedinuser", getPrincipal());
//		return ACCESSDENIED;
//	}
//
//	@RequestMapping(value = "/login2", method = RequestMethod.GET)
//	public String loginPage2() {
//		if (isCurrentAuthenticationAnonymous()) {
//			return "login2";
//	    } else {
//	    	return "redirect:/index2";  
//	    }
//	}
//
//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null){    
//			persistentTokenBasedRememberMeServices.logout(request, response, auth);
//			SecurityContextHolder.getContext().setAuthentication(null);
//		}
//		return "redirect:/login2?logout";
//	}
//	
//	private boolean isCurrentAuthenticationAnonymous() {
//	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	    return authenticationTrustResolver.isAnonymous(authentication);
//	}
//	@RequestMapping(value = {"employee/EmployeesSalariesSummary"}, method = RequestMethod.GET)
//	public String getDepartmentsEmployeeCount(ModelMap model){
//		List<Employee> employees = employeeService.findAllEmployees();
//		employees.sort(new EmployeeSalaryComparator());
//		model.addAttribute("employeesReport", employees);
//		model.addAttribute("loggedinuser", getPrincipal()); 
//		model.addAttribute("testuser" , loggUserName);
//		model.addAttribute("testuser2", loggUserName2);
//		return REPORT3;
//	}
//
//	
//
//}

