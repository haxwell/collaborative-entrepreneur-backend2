package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.entities.User;
import com.savvato.collaborativeentrepreneur.backend.repositories.UserRepository;
import com.savvato.collaborativeentrepreneur.backend.utils.ValidationUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserRoleMapService userRoleMapService;

	@Autowired
	PasswordEncoder passwordEncoder;

	// TODO: Implement the preferredContactMethod behavior
	public User createNewUser(String name, String password, String phone, String email, String preferredContactMethod) {
		if (password != null && ValidationUtil.isPhoneValid(phone) && ValidationUtil.isEmailValid(email)
				&& name.length() >= 3) {

			Optional<User> opt = this.userRepo.findByNamePhoneOrEmail(name, phone, email);

			if (!opt.isPresent()) {
				User user = new User(name, passwordEncoder.encode(password), phone, email);

				User rtn = userRepo.save(user);

				userRoleMapService.addRoleToUser(rtn.getId(), UserRoleMapService.ROLES.BRANDSPANKINNEWBIE);

				this.sendNewUserSMS();
				this.sendNewUserEmail();

				return rtn;
			} else {
				throw new IllegalArgumentException("This user already exists: " + name + " " + phone + " " + email);
			}
		}

		return null;
	}

	public User find(String query) {
		Optional<User> opt = userRepo.findByPhoneOrEmail(query);
		User rtn = null;

		if (opt.isPresent())
			rtn = opt.get();

		return rtn;
	}

	public User findById(Long id) {
		Optional<User> opt = userRepo.findById(id);
		User rtn = null;

		if (opt.isPresent())
			rtn = opt.get();

		return rtn;
	}

	private void sendNewUserSMS() {
		// if the user prefers sms, they can respond to the link in this sms.
		// that will confirm their account, set their preference.

		// when they log in next time, we will confirm their attendance by sending an
		// sms.
	}

	private void sendNewUserEmail() {
		// if the user prefers email, they can respond to the link in this email.
		// that will confirm their account, set their preference.

		// when they log in next time, we will confirm their attendance by sending an
		// email.
	}
}
