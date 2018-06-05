package group.higo.framework.util;

import group.higo.framework.po.SysUser;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.ResourceBundle;
import java.util.UUID;

public class SysUserUtil {

    public static  SysUser getEncryptedUser(SysUser sysUser){

        ResourceBundle resource = ResourceBundle.getBundle("system");
        int hashIterations = Integer.parseInt(resource.getString("shiro_hashIterations"));
        sysUser.setSalt(UUID.randomUUID().toString());

        Md5Hash md5Hash = new Md5Hash(sysUser.getPassword(),sysUser.getSalt(),hashIterations);
        sysUser.setPassword(md5Hash.toString());
        return sysUser;
    }

}
