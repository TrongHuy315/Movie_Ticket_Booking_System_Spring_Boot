package cinema.system.demo.service;

import cinema.system.demo.dto.response.JwtAuthenticationResponse;
import cinema.system.demo.dto.request.SignInRequest;
import cinema.system.demo.dto.request.SignUpRequest;
import cinema.system.demo.model.Role;
import cinema.system.demo.model.User;
import cinema.system.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public User signup(SignUpRequest request) {
        var user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setAge(request.getAge());
        user.setRole(Role.USER); // Mặc định là USER
        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        
        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);
        // Bạn có thể tạo refresh token ở đây nếu cần
        // response.setRefreshToken("..."); 
        return response;
    }
}
