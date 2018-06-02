/**
 * 
 */
package group.higo.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	@RequestMapping("/error")
	public String error() {
		return "error/error";
	}
	
	/**
	 * 未被认证
	 */
	@RequestMapping("/unauthorized")
	public ModelAndView unauthorized() {
		return new ModelAndView("error/unauthorized");
	}
}
