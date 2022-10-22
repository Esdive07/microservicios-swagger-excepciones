package com.edv.microbike.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.edv.microbike.entity.BikeEntity;
import com.edv.microbike.repository.BikeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BikeService {

	private BikeRepository bikeRepository;

	public List<BikeEntity> getAll() {
		return bikeRepository.findAll();
	}

	public Page<BikeEntity> getAll(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return bikeRepository.findAll(pageable);
	}

	public BikeEntity getById(int id) {
		return bikeRepository.findById(id).orElse(null);
	}

	public BikeEntity save(BikeEntity bikeEntity) {
		BikeEntity usernew = bikeRepository.save(bikeEntity);
		return usernew;
	}

	public List<BikeEntity> byUserId(int userId) {
		return bikeRepository.findByUserId(userId);
	}
}
