package com.braincustom.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.braincustom.dsvendas.dto.SaleDTO;
import com.braincustom.dsvendas.dto.SaleSuccessDTO;
import com.braincustom.dsvendas.dto.SaleSumDTO;
import com.braincustom.dsvendas.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	//camada de acesso a dados - CRUD
	//recurso paginado das vendas
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	//endpoint do controller do gráfico de rosca do vendedor SaleSumDTO
	@GetMapping(value="/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	//endpoint do controller da lista de sucesso do vendedor SaleSumDTO
		@GetMapping(value="/success-by-seller")
		public ResponseEntity<List<SaleSuccessDTO>> succecsGroupedBySeller(){
			List<SaleSuccessDTO> list = service.successGroupedBySeller();
			return ResponseEntity.ok(list);
		}
}
