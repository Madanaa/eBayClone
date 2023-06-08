package ebay.clone.eBay.platform.exception;

public class UserAlreadyExitsException extends RuntimeException {
    public UserAlreadyExitsException(String username_already_exists) {
        super(username_already_exists);
    }
}
