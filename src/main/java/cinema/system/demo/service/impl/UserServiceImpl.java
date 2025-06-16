package cinema.system.demo.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.NotAcceptableStatusException;

import cinema.system.demo.dto.request.UserRequest;
import cinema.system.demo.dto.response.UserResponse;
import cinema.system.demo.mapper.UserMapper;
import cinema.system.demo.model.Profile;
import cinema.system.demo.model.User;
import cinema.system.demo.repository.AdminRepository;
import cinema.system.demo.repository.UserRepository;
import cinema.system.demo.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository; // Thêm repo của Admin

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                // Thử tìm trong bảng User trước
                return userRepository.findByEmail(username)
                        // Nếu không thấy, tìm trong bảng Admin
                        .map(UserDetails.class::cast)
                        .orElseGet(() -> adminRepository.findByEmail(username)
                                .orElseThrow(() -> new UsernameNotFoundException("User or Admin not found")));
            }
        };
    }

    private User getCurrentUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new UsernameNotFoundException("Not found user information");
        }

        return (User)authentication.getPrincipal();
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserInformation() {
        User user = this.userRepository.findByEmail(getCurrentUserDetails().getEmail()).orElseThrow(() -> new UsernameNotFoundException("Not found email"));

        return this.userMapper.toDto(user);
    }

    @Override
    public User updateUserInformation(final UserRequest userRequest) {
        User user = this.userRepository.findByEmail(getCurrentUserDetails().getEmail()).orElseThrow(() -> new UsernameNotFoundException("Not found email"));

        boolean flag = false;

        if (userRequest.getFullName() != null && !user.getFullName().equals(userRequest.getFullName())) {
            user.setFullName(userRequest.getFullName());
            flag = true;
        }

        if (userRequest.getAge() != null && !user.getAge().equals(userRequest.getAge())) {
            user.setAge(userRequest.getAge());
            flag = true;
        }

        if (userRequest.getPhone() != null && !user.getPhone().equals(userRequest.getPhone())) {
            user.setPhone(userRequest.getPhone());
            flag = true;
        }
        
        if (userRequest.getEmail() != null && !user.getEmail().equals(userRequest.getEmail())) {
            user.setEmail(userRequest.getEmail());
            flag = true;
        }

        if (userRequest.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            flag = true;
        }

        if (userRequest.getCccd() != null) {
            Profile profile = user.getProfile();
            if (profile == null) {
                profile = new Profile();
                user.setProfile(profile);
            }

            if (!userRequest.getCccd().equals(profile.getCccd())) {
                profile.setCccd(userRequest.getCccd());
                flag = true;
            }
        }

        if (!flag) throw new NotAcceptableStatusException("Not found any change");

        this.userRepository.save(user);

        return user;
    }

    @Override
    public Boolean deleteUserInformation() {
        User user = this.userRepository.findByEmail(getCurrentUserDetails().getEmail()).orElseThrow(() -> new UsernameNotFoundException("Not found email"));

        this.userRepository.deleteById(user.getId());

        return true;
    }
}
