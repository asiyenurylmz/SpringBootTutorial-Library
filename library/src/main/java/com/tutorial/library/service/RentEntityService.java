package com.tutorial.library.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tutorial.library.dto.RentDTO;
import com.tutorial.library.entity.RentEntity;
import com.tutorial.library.repository.RentRepository;
import com.tutorial.library.util.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentEntityService {

	private final RentRepository repository;
	private final CustomerEntityService customerEntityService;
	private final StockEntityService stockEntityService;
	private final Mapper mapper;

	public Optional<RentEntity> findById(Long id) {
		return repository.findById(id);
	}

	public RentEntity save(RentDTO rentDTO) {
		RentEntity rentEntity = mapper.mapDtoToEntity(rentDTO);
		rentEntity.setCustomer(customerEntityService.findById(rentDTO.getCustomer().getId()).orElseThrow());
		rentEntity.setStock(stockEntityService.findById(rentDTO.getStock().getId()).orElseThrow());
		if (rentEntity.getStock().getCount() >= 1) {
			stockEntityService.update(rentEntity.getStock().getId(), -1);
			return repository.save(rentEntity);

		}
		return null;
	}

	public void delete(RentDTO rentDTO) {
//		rentDTO.setStock(mapper.mapEntityToDto(this.findById(rentDTO.getId()).orElseThrow()).getStock());
		rentDTO = mapper.mapEntityToDto(this.findById(rentDTO.getId()).orElseThrow());
		repository.delete(this.findById(rentDTO.getId()).orElseThrow());
		stockEntityService.update(rentDTO.getStock().getId(), +1);

	}
}
