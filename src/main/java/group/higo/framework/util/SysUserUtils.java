package group.higo.framework.util;

import group.higo.framework.po.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.ResourceBundle;
import java.util.UUID;

public class SysUserUtils {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("system");

    public static  SysUser getEncryptedUser(SysUser sysUser){

        int hashIterations = Integer.parseInt(resourceBundle.getString("shiro_hashIterations"));
        sysUser.setSalt(UUID.randomUUID().toString());

        Md5Hash md5Hash = new Md5Hash(sysUser.getPassword(),sysUser.getSalt(),hashIterations);
        sysUser.setPassword(md5Hash.toString());
        return sysUser;
    }

    public static boolean isAdministrator(){
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String administrator =resourceBundle.getString("administrator");
        boolean result = administrator != null && administrator.contains(user.getUsername());
        return result;
    }

}
