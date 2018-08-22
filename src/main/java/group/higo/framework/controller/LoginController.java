package group.higo.framework.controller;

import group.higo.framework.util.ValidateCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

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
            } else if ("randomCodeException".equals(exceptionClassName)) {
                msg = "验证码错误";
            } else if (exceptionClassName != null) {
                msg = "其他错误：" + exceptionClassName;
            }
            model.addAttribute("msg", msg);
            return "login";
        } else {
            return "home";
        }
    }

    /**
     * 前台请求得到验证码
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = ValidateCodeUtils.generateCodeAndPic();

        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("validatecode", codeMap.get("code").toString());
        log.info("validatecode:"+codeMap.get("code").toString());

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);

        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = response.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
            log.info("生成二维码成功：code："+codeMap.get("code").toString());
        } catch (IOException e) {
            log.info("生成验证码失败");
            e.printStackTrace();
        }
    }

}
