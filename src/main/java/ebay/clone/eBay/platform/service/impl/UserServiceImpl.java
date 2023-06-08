package ebay.clone.eBay.platform.service.impl;

import ebay.clone.eBay.platform.exception.UserAlreadyExitsException;
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
        // Check if the username or email already exists in the database
        User userExits = userRepository.findByUserName(userDTO.getUserName());
        if (userExits != null) {
            throw new UserAlreadyExitsException("Username already exists");
        }
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String userName, String password) {
        return null;
    }
}
