package group.higo.framework.test;

import group.higo.framework.po.SysUser;
import group.higo.framework.service.ISysUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ResourceBundle;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@WebAppConfiguration
public class MyTest {

    private static Logger logger = Logger.getLogger(MyTest.class);

    @Autowired
    public ISysUserService userService;

    @Test
    public void test() {
        SysUser u = userService.selectByPrimaryKey(1);
        logger.info(u.getUsername());
    }

    @Test
    public void test1(){
        String password = "lijunjie";
        String salt = UUID.randomUUID().toString();
        int hashIterations = 1;
        System.out.println("salt:"+salt);
        Md5Hash md5Hash = new Md5Hash(password,salt,hashIterations);
        String passwordMd5 = md5Hash.toString();
        System.out.println("passwordMd5:"+passwordMd5);
    }

    @Test
    public void test2(){
        ResourceBundle resource = ResourceBundle.getBundle("system");
        String shiro_hashIterations = resource.getString("shiro_hashIterations");
        System.out.println("shiro_hashIterations:"+shiro_hashIterations);
    }

    @Test
    public void test3(){
        SimpleHash hash = new SimpleHash("SHA1", "admin", "5298a9e4-b4ca-4088-bfea-b9f7fda7eb61", 1);
        String encodedPassword = hash.toHex();
        System.out.println(encodedPassword);
    }
}