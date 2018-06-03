package group.higo.framework.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        HttpSession session = httpServletRequest.getSession();

        String validateCode = (String) session.getAttribute("validateCode");

        String randomcode = httpServletRequest.getParameter("randomcode");

        if(randomcode!=null && validateCode!=null && !randomcode.equals(validateCode)){
            httpServletRequest.setAttribute("shiroLoginFailure","randomcodeError");
            return true;
        }
        return super.onAccessDenied(request, response);
    }
}
