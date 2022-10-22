package com.edv.microuser.controller.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edv.microuser.controller.UserController;
import com.edv.microuser.entity.UserEntity;
import com.edv.microuser.model.BikeModel;
import com.edv.microuser.model.CarModel;
import com.edv.microuser.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserControllerImpl implements UserController {

	private UserService userService;

	@GetMapping
	@Override
	public ResponseEntity<List<UserEntity>> getAll() {
		List<UserEntity> users = userService.getAll();
		if (users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}

//paginado
	@GetMapping("/{page}/{size}")
	@Override
	public ResponseEntity<Page<UserEntity>> getAllPagination(@PathVariable Integer page, @PathVariable Integer size) {
		Page<UserEntity> users = userService.getAll(page, size);
		if (users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<UserEntity> getById(@PathVariable int id) {
		UserEntity user = userService.getUserById(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}

	@PostMapping()
	@Override
	public ResponseEntity<UserEntity> save(@RequestBody UserEntity userEntity) {
		UserEntity userNew = userService.save(userEntity);
		return ResponseEntity.ok(userNew);
	}

	@GetMapping("/cars/{userId}")
	@Override
	public ResponseEntity<List<CarModel>> getCars(@PathVariable("userId") int userId) {
		UserEntity user = userService.getUserById(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		List<CarModel> cars = userService.getCars(userId);
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/bikes/{userId}")
	public ResponseEntity<List<BikeModel>> getBikes(@PathVariable("userId") int userId) {
		UserEntity user = userService.getUserById(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		List<BikeModel> bikes = userService.getBikes(userId);
		return ResponseEntity.ok(bikes);
	}
}
