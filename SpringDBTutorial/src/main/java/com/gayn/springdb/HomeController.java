package com.gayn.springdb;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gayan.spring.dao.UserDao;
import com.gayan.spring.domain.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
    @Autowired
    private UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
	    String greetings = "Greetings, Spring MVC!";
	    model.addAttribute("message", greetings);
	 
	    return "test";
	}
	
	
    @RequestMapping(value="/user")
    public ModelAndView home() throws IOException{
        List<User> listUsers = userDao.list();
        ModelAndView model = new ModelAndView("home");
        model.addObject("userList", listUsers);
        return model;
    }
	
    
	@RequestMapping(value="/user/create", method=RequestMethod.GET)
	public ModelAndView createUserForm(
			@RequestParam(value="userId", required=false) Long userId,
			@RequestParam(value="searchValue", required=false) String searchTerm,
			@RequestParam(value="updateStatus", required=false) String updateStatus,
			ModelMap model, 
			HttpSession session,
			HttpServletRequest req){
		
		User user = new User();
		model.addAttribute("user",user);
		
		
		
		return new ModelAndView("create", model);
	}
	
	
	@RequestMapping(value="/user/create", method=RequestMethod.POST )
	public Object post( 
			@RequestParam(value="userId", required=false) Long userId,
			@ModelAttribute("user") User user,
			BindingResult errors,
			ModelMap model,
			HttpSession session,
			HttpServletRequest req,
			HttpServletResponse resp) {
		

		
		model.addAttribute("userId", userId);
		
		//return "redirect:/assign/userList";
		return new ModelAndView( "redirect:/user/create", model);
		 
	}
}
