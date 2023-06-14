package ebay.clone.eBay.platform;

import ebay.clone.eBay.platform.model.User;
import ebay.clone.eBay.platform.payload.UserDTO;
import ebay.clone.eBay.platform.security.JwtTokenProvider;
import ebay.clone.eBay.platform.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;


   @Autowired
    public UserController(UserService userService,JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;

    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User registeredUser = userService.registerUser(userDTO);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
   @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String userName,@RequestParam String password){
       Authentication user = (Authentication) userService.loginUser(userName,password);
       String token =jwtTokenProvider.generateToken(user);
       return new ResponseEntity<>(token,HttpStatus.OK);
   }



}
