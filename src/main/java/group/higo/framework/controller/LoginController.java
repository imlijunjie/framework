package group.higo.framework.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value = "login")
    public String login(Model model, HttpServletRequest request) {

        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
            String msg = null;
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                msg = "用户名/密码错误";
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                msg = "用户名/密码错误";
            } else if (exceptionClassName != null) {
                msg = "其他错误：" + exceptionClassName;
            }
            model.addAttribute("msg", msg);
            return "login";
        } else {
            return "home";
        }
    }
}
