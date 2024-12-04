package com.example.demo_crud_hibernate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoCrudHibernateApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void databaseSetsUp() {
		DemoCrudHibernateApplication.main(new String[] {});
		assertNotNull(applicationContext.getBean("dataSource"), "Database should be set up and DataSource bean should be available");
	}

	// @Test
	// void addBook() {
	// 	DemoCrudHibernateApplication.main(new String[] {});
	// 	BookController controller = applicationContext.getBean(BookController.class);
	// 	controller.createBook( new Book("The Great Gatsby", "F. Scott Fitzgerald", 19.00));
	// 	Book book = controller.getBookById(1);
	// 	assertNotNull(book, "Book should be added to the database");
	// }

}
