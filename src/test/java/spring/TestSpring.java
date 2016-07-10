package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lose.ssh.model.User;

public class TestSpring {
	
	@Test
	public void testSpring(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		User user = (User) context.getBean("user");
		System.out.println(user.getName());
	}

}
