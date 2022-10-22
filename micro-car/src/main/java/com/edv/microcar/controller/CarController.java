package com.edv.microcar.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.edv.microcar.entity.CarEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface CarController {

	@Operation(summary = "Get All Cars")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return All Cars"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<List<CarEntity>> getAll();

	@Operation(summary = "Get All Cars Paginated")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return All Cars"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<Page<CarEntity>> getAll(@PathVariable Integer page, @PathVariable Integer size);
	
	
	@Operation(summary = "Get cars by id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return cars by id"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<CarEntity> getById(int id);

	@Operation(summary = "Save cars")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Create cars"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<CarEntity> save(CarEntity carEntity);

	@Operation(summary = "Get cars by iduser ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return cars by iduser"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<List<CarEntity>> getbyUserId(int userId);
}
