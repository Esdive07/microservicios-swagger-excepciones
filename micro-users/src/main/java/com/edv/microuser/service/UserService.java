package com.edv.microuser.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edv.microuser.entity.UserEntity;
import com.edv.microuser.model.BikeModel;
import com.edv.microuser.model.CarModel;
import com.edv.microuser.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private UserRepository userRepository;
	private RestTemplate restTemplate;

	public List<UserEntity> getAll() {
		return userRepository.findAll();
	}

	public Page<UserEntity> getAll(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return userRepository.findAll(pageable);
	}

	public UserEntity getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public UserEntity save(UserEntity userEntity) {
		UserEntity usernew = userRepository.save(userEntity);
		return usernew;
	}

	@SuppressWarnings("unchecked")
	public List<CarModel> getCars(int userId) {
		List<CarModel> cars = restTemplate.getForObject("http://localhost:8002/car/byUserId/" + userId, List.class);
		return cars;
	}

	@SuppressWarnings("unchecked")
	public List<BikeModel> getBikes(int userId) {
		List<BikeModel> bikes = restTemplate.getForObject("http://localhost:8003/bike/byUserId/" + userId, List.class);
		return bikes;
	}
}
