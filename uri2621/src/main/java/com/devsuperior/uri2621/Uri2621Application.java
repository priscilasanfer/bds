package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projection.ProductMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Integer min = 10;
		Integer max = 20;
		String name = "P";

		List<ProductMinProjection> list1 = repository.search1(min, max, name);
		List<ProductMinDTO> result1 = list1.stream()
				.map(ProductMinDTO::new).collect(Collectors.toList());

		System.out.println("\n****  Resultado SQL Raiz  **** ");
		result1.forEach(System.out::println);
		System.out.println("\n\n");

		List<ProductMinDTO> result2 = repository.search2(min, max, name);

		System.out.println("\n****  Resultado JPQL  **** ");
		result2.forEach(System.out::println);
		System.out.println("\n\n");
	}
}
