
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.dto.UserDTO;
import com.ejemplo.SpringBoot.exception.UserAlreadyExistAuthenticationException;
import com.ejemplo.SpringBoot.model.User;
import com.ejemplo.SpringBoot.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
	private UserRepository userRepository;

	@Autowired    
        private PasswordEncoder  bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = (User) userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(UserDTO userDTO) {
		
		User userDB = (User) userRepository.findByUsername(userDTO.getUsername());
		if (userDB != null) 
			throw new UserAlreadyExistAuthenticationException(userDTO.getUsername());
		
		User newUser = new User();
		newUser.setUsername(userDTO.getUsername());
		newUser.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		return userRepository.save(newUser);
	}
    
}
