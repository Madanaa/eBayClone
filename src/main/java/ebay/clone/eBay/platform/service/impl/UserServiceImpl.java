package ebay.clone.eBay.platform.service.impl;

import ebay.clone.eBay.platform.model.User;
import ebay.clone.eBay.platform.payload.UserDTO;
import ebay.clone.eBay.platform.repository.UserRepository;
import ebay.clone.eBay.platform.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User registerUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public User loginUser(String userName, String password) {
        return null;
    }
}
