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
		// ����ָ��Ŀ¼�µ������ļ����õ�configuration����
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		// ����cfg����õ�session����
		SessionFactory factory = cfg.buildSessionFactory();
		// ʹ�ù������һ��session
		Session session = factory.openSession();
		// ��������
		Transaction tx = session.beginTransaction();
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		User user = (User) context.getBean("user");
		user.setName("test2");
		user.setPassword("123123");
		user.setState("��Ч");
		user.setTelphone("15821292486");
		user.setCreate_time(String.valueOf(new Date()));
		session.save(user);
		tx.commit();
		//�ر���Դ
		session.close();
		factory.close();
	}
	
}
