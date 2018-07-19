package com.movie.validator;

import com.movie.model.User;
import com.movie.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * This class is used to validate the user details during registration
 * @author suprija
 *
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    /**
     * @param  o contains the user data type casted to User class
     * @param  errors holds the errors that has to be displayed to the user
     *
     * This method validates the info entered by the user. 
     * If the user is already registered or information entered doesn't meet the specified criteria, then the information entered by user is discarded
     * 
     */
    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        String uname="username";
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, uname, "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue(uname, "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue(uname, "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
