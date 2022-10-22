package com.edv.microbike.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.edv.microbike.entity.BikeEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface BikeController {

	@Operation(summary = "Get All Bikes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return All Bikes"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<List<BikeEntity>> getAll();

	@Operation(summary = "Get Bikes By Id Paginated")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return Bikes By Id Paginated"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<Page<BikeEntity>> getAll(@PathVariable Integer page, @PathVariable Integer size);

	@Operation(summary = "Get cars by id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return Bikes by id"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<BikeEntity> getById(int id);

	@Operation(summary = "Save Bikes")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Create Bikes"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<BikeEntity> save(BikeEntity bikeEntity);

	@Operation(summary = "Get Bikes by iduser ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return Bikes by iduser"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<List<BikeEntity>> getbyUserId(int userId);
}
