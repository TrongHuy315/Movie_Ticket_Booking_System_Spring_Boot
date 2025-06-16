package cinema.system.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import cinema.system.demo.dto.request.UserRequest;
import cinema.system.demo.dto.response.UserResponse;
import cinema.system.demo.model.User;

public interface UserService {
    UserDetailsService userDetailsService();
    public UserResponse getUserInformation();
    public User updateUserInformation(final UserRequest userRequest);
    public Boolean deleteUserInformation();
}
