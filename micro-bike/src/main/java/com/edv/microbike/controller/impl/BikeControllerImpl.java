package com.edv.microbike.controller.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edv.microbike.controller.BikeController;
import com.edv.microbike.entity.BikeEntity;
import com.edv.microbike.service.BikeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bike")
@AllArgsConstructor
public class BikeControllerImpl implements BikeController {

	private BikeService bikeService;

	@GetMapping
	@Override
	public ResponseEntity<List<BikeEntity>> getAll() {
		List<BikeEntity> bikes = bikeService.getAll();
		if (bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(bikes);
	}

	@GetMapping("/{page}/{size}")
	@Override
	public ResponseEntity<Page<BikeEntity>> getAll(@PathVariable Integer page, @PathVariable Integer size) {
		Page<BikeEntity> bikes = bikeService.getAll(page, size);
		if (bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(bikes);
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<BikeEntity> getById(@PathVariable int id) {
		BikeEntity bike = bikeService.getById(id);
		if (bike == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bike);
	}

	@PostMapping()
	@Override
	public ResponseEntity<BikeEntity> save(@RequestBody BikeEntity bikeEntity) {
		BikeEntity bikeNew = bikeService.save(bikeEntity);
		return ResponseEntity.ok(bikeNew);
	}

	@GetMapping("/byUserId/{userId}")
	@Override
	public ResponseEntity<List<BikeEntity>> getbyUserId(@PathVariable int userId) {
		List<BikeEntity> bikes = bikeService.byUserId(userId);
		if (bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(bikes);
	}

}
