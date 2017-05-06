package com.revature.main;

import org.springframework.context.support.*;

import com.revature.dao.*;

public class Driver {

	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		
		System.out.println(dao.loadAll());
		
		ac.close();

	}

}
