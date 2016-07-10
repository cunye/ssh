package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lose.ssh.model.User;


public class TestHibernate {
	
	@Test
	public void testHibernate(){
		// 加载指定目录下的配置文件，得到configuration对象
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		// 根据cfg对象得到session工厂
		SessionFactory factory = cfg.buildSessionFactory();
		// 使用工程类打开一个session
		Session session = factory.openSession();
		// 开启事物
		Transaction tx = session.beginTransaction();
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		User user = (User) context.getBean("user");
		user.setName("test2");
		user.setPassword("123123");
		user.setState("有效");
		user.setTelphone("15821292486");
		user.setCreate_time(String.valueOf(new Date()));
		session.save(user);
		tx.commit();
		//关闭资源
		session.close();
		factory.close();
	}
	
}
