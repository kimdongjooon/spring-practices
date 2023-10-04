package com.poscodx.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.poscodx.container.user.User;

public class XmlConfigTest {
	public static void main(String[] args) {
		// XML Auto Configuration(Annotation Scanning)
		// testApplicationContext01();
		
		// XML Bean Configuration(Explicit Configuration)
		testApplicationContext02();
		
		// XML Auto Configuration(Annotation Scanning)
		// testBeanFactory01();
		
		// XML Bean Configuration(Explicit Configuration)
		// testBeanFactory02();
		

		
		
	}

	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscodx/container/config/user/applicationContext01.xml");
		
		User user =null;
		
		// getBean 함수로 클래스 파일가져오기.
		user = ac.getBean(User.class);
		System.out.println(user.getName());
		
		// id로 접근하여 가져오기(자동)
		// Annotation Scan(Auto Configuration) 에서는 Bean id가 자동으로 부여된다. 
		user = (User)ac.getBean("user");
		System.out.println(user.getName());	
	}
	
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscodx/container/config/user/applicationContext02.xml");
		
		User user =null;
		
		// id로 접근하여 가져오기(자동)
		user = (User)ac.getBean("user");
		System.out.println(user.getName());
		
		user = (User)ac.getBean("user2");
		System.out.println(user.getName());
		
		// name으로 가져오기.
		user = (User)ac.getBean("usr");
		System.out.println(user.getName());	
		
		// Type으로 가져오기.
		// getBean 함수로 클래스 파일가져오기.
		// 같은 타입의 Bean이 2개이상 있으면 Type으로 가져오면 에러남. 그래서 앞에 id명시하여 가져와줄수있음.
		user = ac.getBean("user2",User.class);
		System.out.println(user.getName());
		
		// 파라미터 2개인 생성자로 된 빈 가져오기1(순서대로).
		user = ac.getBean("user3",User.class);
		System.out.println(user);
		
		// 파라미터 2개인 생성자로 된 빈 가져오기2(순서표시).
		user = ac.getBean("user4",User.class);
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기1.
		user = ac.getBean("user5",User.class);
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기2 : DI .
		user = ac.getBean("user6",User.class);
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기3 : Collection Property(리스트) .
		user = ac.getBean("user7",User.class);
		System.out.println(user);
		
	}

	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscodx/container/config/user/applicationContext01.xml"));
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}
	
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscodx/container/config/user/applicationContext02.xml"));
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}
}
