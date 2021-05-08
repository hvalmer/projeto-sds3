package com.braincustom.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.braincustom.dsvendas.dto.SaleSuccessDTO;
import com.braincustom.dsvendas.dto.SaleSumDTO;
import com.braincustom.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	//método para retornar o gráfico de rosca do SaleSumDTO
	//Consulta(Query) específica, no caso a Jpql da OO do Java
	@Query("SELECT new com.braincustom.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	//método para retornar a lista de sucesso dos vendedores
	@Query("SELECT new com.braincustom.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> succecsGroupedBySeller();
} 
