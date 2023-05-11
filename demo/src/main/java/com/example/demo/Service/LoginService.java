package com.example.demo.Service;

import com.example.demo.model.base.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.example.demo.utils.Common;
import com.example.demo.utils.Login;
import com.example.demo.model.LoginModel;

@Component
public class LoginService{

        @Bean
        public LoginModel login(LoginModel model) {

            if (model.getUserName().length() < 8) {
                Message message = new Message(Login.MESSAGE_USERNAME_REQUIRE_8_DIGITS, Login.FIELD_USERNAME);
                model.getMessages().add(message);
                return model;
            }
            if (model.getPassWord().length() < 8) {
                Message message = new Message(Login.MESSAGE_PASSWORD_REQUIRE_8_DIGITS, Login.FIELD_PASSWORD);
                model.getMessages().add(message);
                return model;
            }

            boolean flag = false;
            for (char a : Common.SPECIAL_SYMBOLS.toCharArray()) {
                if (model.getPassWord().indexOf(a) != -1) {
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                Message message = new Message(Login.MESSAGE_PASSWORD_REQUIRE_SPECIAL_SYMBOLS,Login.FIELD_PASSWORD);
                model.getMessages().add(message);
                return model;
            }

            flag = false;
            for (char a : model.getPassWord().toCharArray()) {
                if (Character.isUpperCase(a)) {
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                Message message = new Message(Login.MESSAGE_PASSWORD_REQUIRE_UPPER_CASE,Login.FIELD_PASSWORD);
                model.getMessages().add(message);
                return model;
            }
            if(model == null){
                Message mUsername = new Message(Login.MESSAGE_USERNAME_PASSWORD_INCORRECT,Login.FIELD_USERNAME);
                Message mPassword = new Message(Login.MESSAGE_USERNAME_PASSWORD_INCORRECT,Login.FIELD_PASSWORD);
                model.getMessages().add(mUsername);
                model.getMessages().add(mPassword);
                return model;
            }
        return model;
    }
}
