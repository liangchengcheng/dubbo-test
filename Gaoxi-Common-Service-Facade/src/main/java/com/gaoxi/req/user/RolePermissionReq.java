package com.gaoxi.req.user;

import com.gaoxi.req.AbsReq;
import java.util.List;

/**
 * 角色对应权限的修改请求
 */
public class RolePermissionReq extends AbsReq {

    /** 角色ID */
    private String roleId;

    /** 权限ID列表 */
    private List<String> permissionIdList;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getPermissionIdList() {
        return permissionIdList;
    }

    public void setPermissionIdList(List<String> permissionIdList) {
        this.permissionIdList = permissionIdList;
    }

    @Override
    public String toString() {
        return "RolePermissionReq{" +
                "roleId='" + roleId + '\'' +
                ", permissionIdList=" + permissionIdList +
                '}';
    }
}
