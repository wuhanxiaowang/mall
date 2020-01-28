package com.github.mall.authority;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.mall.dao.UmsAdminDao;
import com.github.mall.entity.UmsAdmin;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName ShiroRealm
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/25 13:47
 * @ModifyDate 2019/9/25 13:47
 * @Version 1.0
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UmsAdminDao umsAdminDao;

    /**
     * 提供用户信息返回权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        log.info("doGetAuthorizationInfo()==================用户名:" + userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
       /* Set<Role> roles = userService.findRoles(username);
        Set<String> roleNames = new HashSet<String>();
        for (Role role : roles) {
            roleNames.add(role.getRole());
        }*/
        // 将角色名称提供给info
       /* authorizationInfo.setRoles(roleNames);
        // 根据用户名查询当前用户权限
        Set<Permission> permissions = userService.findPermissions(username);
        Set<String> permissionNames = new HashSet<String>();
        for (Permission permission : permissions) {
            permissionNames.add(permission.getPermission());
        }*/
        // 将权限名称提供给info
        //   authorizationInfo.setStringPermissions(permissionNames);
        return null;
    }

    /**
     * 提供账户信息返回认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AccountException {
        // 获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        char[] passwordNew = (char[]) token.getCredentials();
        String password=String.valueOf(passwordNew);
        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        // 通过用户名到数据库查询用户信息
        QueryWrapper<UmsAdmin> umsAdmin = new QueryWrapper<>();
        umsAdmin.eq("username", userName);
        UmsAdmin user = umsAdminDao.selectOne(umsAdmin);
        log.info("用户{}", user);
        if (user == null) {
            throw new AccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new AccountException("用户名或密码错误！");
        }
        if (user.getStatus().equals("0")) {
            throw new AccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
