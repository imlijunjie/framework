package group.higo.framework.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private static final transient Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("loginpage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "login")
    public String doLogin(String username, String password, Model model, HttpServletRequest request) {

        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        Exception ex = null;
        // 测试当前的用户是否已经被认证，即是否已经登陆
        // 调用Subject的isAuthenticated
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException e) {
                ex = e;
                logger.error(String.format("user not found: %s", username), e);
            } catch(IncorrectCredentialsException e) {
                ex = e;
                logger.error(String.format("user: %s pwd: %s error", username, password), e);
            } catch (ConcurrentAccessException e) {
                ex = e;
                logger.error(String.format("user has been authenticated: %s", username), e);
            } catch (AuthenticationException e) {
                ex = e;
                logger.error(String.format("account except: %s", username), e);
            }
        }

        if(ex != null) {
            model.addAttribute("ex",ex);
            return "login";
        }

        SavedRequest savedRequest= WebUtils.getSavedRequest(request);
        if(null!=savedRequest){
            String contextPath = request.getSession().getServletContext().getContextPath();
            return "redirect:"+savedRequest.getRequestUrl().replaceFirst(contextPath,"");
        }

        return "home";
    }
}
