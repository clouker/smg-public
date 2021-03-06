package com.alibaba.nacos.controller;

import com.alibaba.nacos.auth.annotation.Secured;
import com.alibaba.nacos.auth.common.ActionTypes;
import com.alibaba.nacos.common.model.RestResult;
import com.alibaba.nacos.security.nacos.NacosAuthConfig;
import com.alibaba.nacos.security.nacos.roles.NacosRoleServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Permission operation controller.
 *
 * @author nkorange
 * @since 1.2.0
 */
@RestController
@RequestMapping("/v1/auth/permissions")
public class PermissionController {

	@Autowired
	private NacosRoleServiceImpl nacosRoleService;

	/**
	 * Query permissions of a role.
	 * @param role the role
	 * @param pageNo page index
	 * @param pageSize page size
	 * @return permission of a role
	 */
	@GetMapping
	@Secured(resource = NacosAuthConfig.CONSOLE_RESOURCE_NAME_PREFIX + "permissions", action = ActionTypes.READ)
	public Object getPermissions(@RequestParam int pageNo, @RequestParam int pageSize,
			@RequestParam(name = "role", defaultValue = StringUtils.EMPTY) String role) {
		return nacosRoleService.getPermissionsFromDatabase(role, pageNo, pageSize);
	}

	/**
	 * Add a permission to a role.
	 * @param role the role
	 * @param resource the related resource
	 * @param action the related action
	 * @return ok if succeed
	 */
	@PostMapping
	@Secured(resource = NacosAuthConfig.CONSOLE_RESOURCE_NAME_PREFIX + "permissions", action = ActionTypes.WRITE)
	public Object addPermission(@RequestParam String role, @RequestParam String resource, @RequestParam String action) {
		nacosRoleService.addPermission(role, resource, action);
		return new RestResult<>(200, "add permission ok!");
	}

	/**
	 * Delete a permission from a role.
	 * @param role the role
	 * @param resource the related resource
	 * @param action the related action
	 * @return ok if succeed
	 */
	@DeleteMapping
	@Secured(resource = NacosAuthConfig.CONSOLE_RESOURCE_NAME_PREFIX + "permissions", action = ActionTypes.WRITE)
	public Object deletePermission(@RequestParam String role, @RequestParam String resource,
			@RequestParam String action) {
		nacosRoleService.deletePermission(role, resource, action);
		return new RestResult<>(200, "delete permission ok!");
	}

}
