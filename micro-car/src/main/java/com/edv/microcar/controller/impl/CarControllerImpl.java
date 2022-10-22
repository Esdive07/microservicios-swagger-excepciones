package com.edv.microcar.controller.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edv.microcar.controller.CarController;
import com.edv.microcar.entity.CarEntity;
import com.edv.microcar.service.CarService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarControllerImpl implements CarController {

	private CarService carService;

	@GetMapping
	@Override
	public ResponseEntity<List<CarEntity>> getAll() {
		List<CarEntity> cars = carService.getAll();
		if (cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/{page}/{size}")
	@Override
	public ResponseEntity<Page<CarEntity>> getAll(@PathVariable Integer page, @PathVariable Integer size) {
		Page<CarEntity> cars = carService.getAll(page, size);
		if (cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<CarEntity> getById(@PathVariable int id) {
		CarEntity car = carService.getById(id);
		if (car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(car);
	}

	@PostMapping()
	@Override
	public ResponseEntity<CarEntity> save(@RequestBody CarEntity carEntity) {
		CarEntity carNew = carService.save(carEntity);
		return ResponseEntity.ok(carNew);
	}

	@GetMapping("/byUserId/{userId}")
	@Override
	public ResponseEntity<List<CarEntity>> getbyUserId(@PathVariable("userId") int userId) {
		List<CarEntity> cars = carService.byUserId(userId);
		if (cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}

}
