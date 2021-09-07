package com.devsuperior.uri2737;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import com.devsuperior.uri2737.repositories.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

    @Autowired
    private LawyerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Uri2737Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<LawyerMinProjection> list1 = repository.search1();
        List<LawyerMinDTO> result1 = list1.stream()
                .map(LawyerMinDTO::new).collect(Collectors.toList());

        System.out.println("\n****  Resultado SQL Raiz Primeira Opção de Query **** ");
        result1.forEach(System.out::println);
        System.out.println("\n\n");

        List<LawyerMinProjection> list2 = repository.search2();
        List<LawyerMinDTO> result2 = list2.stream()
                .map(LawyerMinDTO::new).collect(Collectors.toList());

        System.out.println("\n****  Resultado SQL Raiz Segunda Opção de Query  **** ");
        result2.forEach(System.out::println);
        System.out.println("\n\n");

    }
}
