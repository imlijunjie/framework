package group.higo.framework.test;

import group.higo.framework.po.User;
import group.higo.framework.service.IUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@WebAppConfiguration
public class MyTest {

    private static Logger logger = Logger.getLogger(MyTest.class);

    @Autowired
    public IUserService userService;

    @Test
    public void test() {
        User u = userService.selectByPrimaryKey(1);
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
}