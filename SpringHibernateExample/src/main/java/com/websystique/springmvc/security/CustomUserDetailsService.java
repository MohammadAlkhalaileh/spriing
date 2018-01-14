package com.websystique.springmvc.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Privilege;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
		User user = userService.findBySSO(ssoId);
		logger.info("User : {}", user);
		if (user == null) {
			logger.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		// return new
		// org.springframework.security.core.userdetails.User(user.getSsoId(),
		// user.getPassword(), true, true,
		// true, true, getGrantedAuthorities(user));
		return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(), true, true,
				true, true, getAuthorities(user.getUserProfiles()));
	}

	// private List<GrantedAuthority> getGrantedAuthorities(User user) {
	// List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	//
	// for (UserProfile userProfile : user.getUserProfiles()) {
	// logger.info("UserProfile : {}", userProfile);
	// authorities.add(new SimpleGrantedAuthority("ROLE_" +
	// userProfile.getType()));
	// }
	// logger.info("authorities : {}", authorities);
	// return authorities;
	// }

	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + privilege));
		}
		return authorities;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Collection<UserProfile> userProfiles) {
		return getGrantedAuthorities(getPrivileges(userProfiles));
	}

	private List<String> getPrivileges(Collection<UserProfile> userProfiles) {
		List<String> privileges = new ArrayList<>();
		List<Privilege> collection = new ArrayList<>();
		Privilege RoleAsPrivilege = null;
//		List<Privilege> tempUserPrivileges;
		for (UserProfile userProfile : userProfiles) {
			RoleAsPrivilege = new Privilege();
//			tempUserPrivileges = new ArrayList<Privilege>();
			RoleAsPrivilege.setName(userProfile.getType());
//			tempUserPrivileges.add(RoleAsPrivilege);
//			collection.addAll(userProfile.getPrivileges());
			collection.add(RoleAsPrivilege);
		}
		for (UserProfile userProfile : userProfiles) {
			collection.addAll(userProfile.getPrivileges());
		}
		for (Privilege item : collection) {
			privileges.add(item.getName());
		}
		return privileges;
	}
}
