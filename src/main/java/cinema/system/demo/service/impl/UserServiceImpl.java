package cinema.system.demo.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cinema.system.demo.repository.AdminRepository;
import cinema.system.demo.repository.UserRepository;
import cinema.system.demo.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository; // Thêm repo của Admin

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
}
