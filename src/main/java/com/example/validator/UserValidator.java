package com.example.validator;

import com.example.model.User;
import org.springframework.stereotype.Component;

/**
 * Class for checking the correctness of user data
 * This class checks whether the User object meets the given validity criteria.
 */
@Component
public class UserValidator {

    /**
     * Checks whether the user object is invalid based on the given criteria.
     * @param user user object to check
     * @return true if the user is invalid, false otherwise
     */
    public boolean isNotValid(User user) {
        return user.getEmail() == null || user.getEmail().isEmpty()
                || user.getLogin() == null || user.getLogin().isEmpty()
                || user.getEmail().length() > 25 || user.getLogin().length() > 20;
    }
}
