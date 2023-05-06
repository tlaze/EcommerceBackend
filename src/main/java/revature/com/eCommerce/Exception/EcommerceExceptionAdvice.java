package revature.com.eCommerce.Exception;

public class EcommerceExceptionAdvice extends RuntimeException {
    public EcommerceExceptionAdvice(String message){
        super(message);
    }
}
