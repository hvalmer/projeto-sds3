package com.braincustom.dsvendas.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.braincustom.dsvendas.dto.SaleDTO;
import com.braincustom.dsvendas.entities.Sale;
import com.braincustom.dsvendas.repositories.SaleRepository;
import com.braincustom.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	//declarando a dependência
	//para evitar que a busca seja feita várias vezes do Seller(vendedor)
	//nesse caso de poucos vendedores, o método roda bem...buscar no BD, trazer
	//todos os vendedores e a Jpa gerencia um cash, evitando ir e vir na memória p/ buscar esses vendedores
	@Autowired
	private SellerRepository sellerRepository;

	//Pageable - para fazer a paginação, busca paginada de vendas
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();//antes de buscar a página(Page), se busca os vendedores primeiro
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
}
