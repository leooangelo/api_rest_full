package com.controle.estoque.entity.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.estoque.entity.Product;
import com.controle.estoque.service.ProductService;

@RestController
@RequestMapping(value = "produtos")
public class ProductResources {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> produto = productService.findAll();

		return ResponseEntity.ok().body(produto);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product produto = productService.findById(id);

		return ResponseEntity.ok().body(produto);
	}

	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product produto) {
		produto = productService.insert(produto);
		return ResponseEntity.ok().body(produto);
	}

	@DeleteMapping(value = "{/id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "{/id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product produto) {
		produto = productService.update(id, produto);
		return ResponseEntity.ok().body(produto);
	}

}
