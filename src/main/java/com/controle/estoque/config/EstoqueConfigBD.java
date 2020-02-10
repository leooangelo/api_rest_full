package com.controle.estoque.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.controle.estoque.entity.Product;
import com.controle.estoque.entity.User;
import com.controle.estoque.repository.CategoryRepository;
import com.controle.estoque.repository.ProductRepository;
import com.controle.estoque.repository.UserRepository;

@Configuration
@Profile("dev")
public class EstoqueConfigBD implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Leonardo Angelo", "leoz@gmail.com", "124");
		userRepository.saveAll(Arrays.asList(u1));

		Product p1 = new Product(null, "Palmeiras",
				"https://www.netshoes.com.br/camisa-palmeiras-i-1920-sn-torcedor-puma-masculina-verde-D14-6289-060?campaign=gglepqpla&gclid=EAIaIQobChMI4uH2xrvH5wIVFwiRCh3OPgbyEAYYASABEgI9W_D_BwE&gclsrc=aw.ds",
				null);
		productRepository.saveAll(Arrays.asList(p1));
	}

}
