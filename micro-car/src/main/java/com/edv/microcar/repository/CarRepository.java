package com.edv.microcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edv.microcar.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

	List<CarEntity> findByUserId(Integer UserId);
}
