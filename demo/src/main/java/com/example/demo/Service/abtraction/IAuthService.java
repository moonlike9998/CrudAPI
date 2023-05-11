package com.example.demo.Service.abtraction;

import com.example.demo.Service.LoginService;
import com.example.demo.model.LoginModel;
import org.springframework.stereotype.Service;

@Service
public interface IAuthService {
    public LoginModel auth(LoginModel loginModel);
}
