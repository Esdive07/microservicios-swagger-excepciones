package com.edv.microbike.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edv.microbike.entity.BikeEntity;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity, Integer> {

	List<BikeEntity> findByUserId(int userId);
}
