package com.websystique.springmvc.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.data.repo.UserRepo;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;

@Service("userService")
@Transactional
public class UserDataServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public User findById(int id) {
		return userRepo.findOne(id);		
	}

	@Override
	public User findBySSO(String sso) {
		return userRepo.findBySsoId(sso);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}

	@Override
	public void updateUser(User user) {
		User entity = userRepo.findOne(user.getId());
		if(entity!=null){
			entity.setSsoId(user.getSsoId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
//		userDao.save(user);
	}

	@Override
	public void deleteUserBySSO(String sso) {
		userRepo.deleteBySsoId(sso);
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public boolean isUserSSOUnique(Integer id, String sso) {
		return userRepo.exists(id);
	}

}
