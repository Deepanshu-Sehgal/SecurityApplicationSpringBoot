package com.datricle.SpringSecurityDemo.SecurityApplication.utils;

import com.datricle.SpringSecurityDemo.SecurityApplication.entities.enums.Permission;
import com.datricle.SpringSecurityDemo.SecurityApplication.entities.enums.Role;

import java.util.Map;
import java.util.Set;

import static com.datricle.SpringSecurityDemo.SecurityApplication.entities.enums.Permission.USER_VIEW;
import static com.datricle.SpringSecurityDemo.SecurityApplication.entities.enums.Role.USER;

public class PermissionMapping {
    Map<Role, Set<Permission>> map = Map.of(
      USER, Set.of(USER_VIEW)
    );
}