package com.braincustom.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braincustom.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

	
}
