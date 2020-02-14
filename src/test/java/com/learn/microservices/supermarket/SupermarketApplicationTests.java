package com.learn.microservices.supermarket;

import com.learn.microservices.supermarket.domain.Order;
import com.learn.microservices.supermarket.domain.Product;
import com.learn.microservices.supermarket.predicate.ProductPredicates;
import com.learn.microservices.supermarket.service.OrderService;
import com.learn.microservices.supermarket.service.RandomService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class SupermarketApplicationTests {

	@Autowired
	private OrderService orderService;

	@MockBean
	private RandomService randomProductService;

	@Test
	public void createOrderTest() {
		// given
		given(randomProductService.generate())
				.willReturn(new Product("name1", "product1", new BigDecimal(5)));

		// when
		Order order = orderService.build();

		// then
		assertThat(order.getTotal()).isEqualTo(new BigDecimal(5));
	}

	@Test
	public void filterOrderTest() {
		// given
		given(randomProductService.generate())
				.willReturn(new Product("name1", "product1", new BigDecimal("5")))
				.willReturn(new Product("name2", "subfamily1", new BigDecimal("25")))
				.willReturn(new Product("family1", "product2", new BigDecimal("3")));

		// Create list of predicates
		List<Predicate> predicates = new ArrayList<>();
		Predicate<Product> p1 = ProductPredicates.isNameStarting("na");
		Predicate<Product> p2 = ProductPredicates.isPriceBiggerThan(new BigDecimal("5"));
		predicates.add(p1);
		predicates.add(p2);

		// when
		Order order = orderService.filter(predicates);

		// then
		assertThat(order.getProducts().size() == 1);
		assertThat(order.getProducts().get(0).getName().equals("name2"));
	}

}
