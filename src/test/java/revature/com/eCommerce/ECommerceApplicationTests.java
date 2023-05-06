package revature.com.eCommerce;

import org.h2.engine.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import revature.com.eCommerce.Controller.EcommerceController;
import revature.com.eCommerce.Model.EcommerceUser;
import revature.com.eCommerce.Service.EcommerceService;
import revature.com.eCommerce.Service.UserInterface;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class ECommerceApplicationTests {

	@Mock
	UserInterface userInterface;

	@InjectMocks
	EcommerceService ecommerceService;

	@InjectMocks
	EcommerceController ecommerceController;

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Registering A User Test")
	public void signup(){
		EcommerceUser user = new EcommerceUser();
		EcommerceUser mockUser = new EcommerceUser();
		when(userInterface.save(user)).thenReturn(mockUser);

		EcommerceUser result = ecommerceService.signup(user);

		assertEquals("Register User", mockUser, result);

		Mockito.verify(userInterface, times(1)).save(user);
	}

}
