package cinema.system.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.system.demo.dto.request.UserRequest;
import cinema.system.demo.dto.response.UserResponse;
import cinema.system.demo.model.User;
import cinema.system.demo.response.SuccessResponse;
import cinema.system.demo.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping(path = "/get")
    public UserResponse getUserInformation() {
        return this.userServiceImpl.getUserInformation();
    }

    @PostMapping(path = "/update")
    public SuccessResponse<User> updateUserInformation(@RequestBody UserRequest request) {
        return SuccessResponse.of(this.userServiceImpl.updateUserInformation(request));
    }

    @GetMapping(path = "/delete")
    public SuccessResponse<Boolean> deleteUserInformation() {
        return SuccessResponse.of(this.userServiceImpl.deleteUserInformation());
    }
}
