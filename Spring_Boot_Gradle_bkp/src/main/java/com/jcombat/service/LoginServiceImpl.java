package com.jcombat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcombat.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginData;
}
