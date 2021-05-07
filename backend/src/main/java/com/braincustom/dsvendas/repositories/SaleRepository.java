package com.braincustom.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braincustom.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	
} 
