package com.edv.microcar.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.edv.microcar.entity.CarEntity;
import com.edv.microcar.repository.CarRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarService {

	private CarRepository carRepository;

	public List<CarEntity> getAll() {
		return carRepository.findAll();
	}

	public Page<CarEntity> getAll(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return carRepository.findAll(pageable);
	}

	public CarEntity getById(int id) {
		return carRepository.findById(id).orElse(null);
	}

	public CarEntity save(CarEntity carEntity) {
		CarEntity usernew = carRepository.save(carEntity);
		return usernew;
	}

	public List<CarEntity> byUserId(int userId) {
		return carRepository.findByUserId(userId);
	}
}
