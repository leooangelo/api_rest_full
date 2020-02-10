package com.controle.estoque.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.controle.estoque.entity.Product;
import com.controle.estoque.repository.ProductRepository;
import com.controle.estoque.service.exception.DataBaseException;
import com.controle.estoque.service.exception.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> list = productRepository.findById(id);
		return list.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Product insert(Product produto) {
		return productRepository.save(produto);
	}

	public void delete(Long id) {
		try {
			productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}

	}

	public Product update(Long id, Product produto) {
		try {
			Product entity = productRepository.getOne(id);
			updateData(entity, produto);
			return productRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, Product produto) {
		entity.setNome(produto.getNome());
		entity.setImgUrl(produto.getImgUrl());
		entity.setCategories(produto.getCategories());

	}
}
