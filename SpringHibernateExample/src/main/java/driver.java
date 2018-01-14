import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;

@ComponentScan(basePackages = "com.websystique.springmvc")
public class driver {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
//		createPassword();
//		driver x = new driver();


		System.out.println(System.getProperty("java.home"));
	}

	private static void createPassword() {
		// TODO Auto-generated method stub
        String password = "abc125";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
	}

}
