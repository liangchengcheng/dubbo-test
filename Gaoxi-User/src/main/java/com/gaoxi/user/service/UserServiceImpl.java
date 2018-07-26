package com.gaoxi.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaoxi.entity.user.*;
import com.gaoxi.facade.user.UserService;
import com.gaoxi.req.BatchReq;
import com.gaoxi.req.user.*;

import java.util.List;

@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    @Override
    public UserEntity login(LoginReq loginReq) {
        return null;
    }

    @Override
    public List<UserEntity> findUsers(UserQueryReq userQueryReq) {
        return null;
    }

    @Override
    public UserEntity register(RegisterReq registerReq) {
        return null;
    }

    @Override
    public void batchUpdateUserState(BatchReq<UserStateReq> userStateReqs) {

    }

    @Override
    public void createAdminUser(AdminCreateReq adminCreateReq) {

    }

    @Override
    public List<RoleEntity> findRoles() {
        return null;
    }

    @Override
    public void deleteRole(String roleId) {

    }

    @Override
    public void updateMenuOfRole(RoleMenuReq roleMenuReq) {

    }

    @Override
    public void updatePermissionOfRole(RolePermissionReq rolePermissionReq) {

    }

    @Override
    public List<PermissionEntity> findPermissions() {
        return null;
    }

    @Override
    public List<MenuEntity> findMenus() {
        return null;
    }

    @Override
    public List<LocationEntity> findLocations(String userId) {
        return null;
    }

    @Override
    public String createLocation(LocationCreateReq locationCreateReq, String userId) {
        return null;
    }

    @Override
    public void deleteLocation(String locationId, String userId) {

    }

    @Override
    public void modifyLocation(LocationUpdateReq locationUpdateReq, String userId) {

    }
}