package group.higo.framework.shiro;

import group.higo.framework.po.SysUser;
import group.higo.framework.service.ISysService;
import group.higo.framework.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.*;

public class CustomRealm extends AuthorizingRealm {

    @Resource(name = "sysUserService")
    private ISysUserService sysUserService;

    @Resource(name = "sysService")
    private ISysService sysService;

    // 设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    // 用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // token是用户输入的
        // 第一步从token中取出身份信息（token代表用户输入的传下来的信息）
        String username = (String) token.getPrincipal();

        SysUser u = sysUserService.selectByUsername(username);

        // 如果查询不到返回null
        if(null == u){
             return null;
        }

        // 如果查询到返回认证信息AuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(u,
                u.getPassword(), ByteSource.Util.bytes(u.getSalt()),
                this.getName());

        return simpleAuthenticationInfo;
    }

    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        Set<String> permissions = new HashSet<>();
        // 从 principals获取主身份信息
        // 将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
        SysUser user = (SysUser) principals.getPrimaryPrincipal();
        //判断当前用户是否是配置的全权限账号
        user.getUsername();
        ResourceBundle resource = ResourceBundle.getBundle("system");
        String administrator = resource.getString("administrator");

        if(administrator.contains(user.getUsername())){
            permissions.add("*");
        }else{
            List permissionList = sysService.getSysPermissionByUserid(user.getId());
            permissions.addAll(permissionList);
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}