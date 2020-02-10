package com.controle.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle.estoque.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
