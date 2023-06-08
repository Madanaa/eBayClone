package ebay.clone.eBay.platform.service;

import ebay.clone.eBay.platform.model.User;
import ebay.clone.eBay.platform.payload.UserDTO;

public interface UserService {
   User registerUser(UserDTO userDTO);
   User loginUser(String userName,String password);
}
