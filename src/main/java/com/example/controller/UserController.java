package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import com.example.validator.UserValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for user management.
 */
//@Slf4j
@Tag(name = "User Management", description = "Operations related to user management")
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    /**
     * Displays the user creation page.
     *
     * @return name of the JSP-page for creating a user
     */
    @Operation(summary = "Display user creation page", description = "Displays the page for creating a new user")
    @GetMapping("/create")
    public String createUserGet(User user, Model model) {
        model.addAttribute("user", user);

        return "createUser";
    }

    /**
     * Processes a Post-request to create a user.
     *
     * @param user user to be created
     * @return redirect to user creation page or user information page
     */
    @Operation(summary = "Create a new user", description = "Creates a new user in the database")
    @PostMapping("/create")
    public String createUserPost(User user) {
        String url = null;

        if (userValidator.isNotValid(user)) {
            url = "createUser";
        } else {
            User createdUser = userService.createUser(user);
            if (createdUser != null) {
                url = "redirect:/user/get?id=" + createdUser.getId();
            }
        }
        return url;
    }

    /**
     * Displays information about the user.
     *
     * @param id    user ID
     * @param model model containing user information
     * @return name of the JSP-page with user information
     */
    @Operation(summary = "Get user by ID", description = "Gets the user by his ID")
    @GetMapping("/get")
    public String getUserGet(@RequestParam Integer id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "userInfo";
    }

    /**
     * Displays the user login change page.
     *
     * @return name of the JSP-page for changing the user login
     */
    @Operation(summary = "Display user login change page", description = "Displays the page for changing a user's login")
    @GetMapping("/change-login")
    public String changeLoginGet(User user, Model model) {
        model.addAttribute("user", user);

        return "changeUserLogin";
    }

    /**
     * Processes a Post-request to change the user login.
     *
     * @param user user whose data will be updated
     * @return redirection to the user login change page or user information page
     */
    @Operation(summary = "Change user login", description = "Changes the login of an existing user")
    @PostMapping("/change-login")
    public String changeLoginPost(User user) {
        String url;

        if (userValidator.isNotValid(user)) {
            url = "changeUserLogin";
        } else {
            userService.updateUser(user.getId(), user.getLogin());
            url = "redirect:/user/get?id=" + user.getId() + "&login=" + user.getLogin();
        }
        return url;
    }

    /**
     * Displays the user deletion page.
     *
     * @return name of the JSP-page for deleting a user
     */
    @Operation(summary = "Display user deletion page", description = "Displays the page for deleting a user")
    @GetMapping("/delete")
    public String deleteUserGet(User user, Model model) {
        model.addAttribute("user", user);

        return "deleteUser";
    }

    /**
     * Processes a Post-request to delete a user.
     *
     * @param id user ID to be deleted
     * @return redirect to user deletion page
     */
    @Operation(summary = "Delete user by ID", description = "Deletes a user by their ID")
    @PostMapping("/delete")
    public String deleteUserPost(@RequestParam Integer id) {
        String url;

        if (id == null) {
            url = "deleteUser";
        } else {
            userService.deleteUser(id);
            url = "redirect:/user/delete";
        }
        return url;
    }
}