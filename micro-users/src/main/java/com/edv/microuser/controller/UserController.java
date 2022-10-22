package com.edv.microuser.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.edv.microuser.entity.UserEntity;
import com.edv.microuser.model.BikeModel;
import com.edv.microuser.model.CarModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User")
public interface UserController {

	@Operation(summary = "Get All users")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return All users"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<List<UserEntity>> getAll();

	@Operation(summary = "Get users Paginated")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return users paginated"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<Page<UserEntity>> getAllPagination(@PathVariable Integer page, @PathVariable Integer size);

	@Operation(summary = "Get users by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return user by Id"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<UserEntity> getById(int id);

	@Operation(summary = "Save user")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Create User"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<UserEntity> save(UserEntity userEntity);

	@Operation(summary = "Get Cars by id user")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return Cards by id user"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<List<CarModel>> getCars(@PathVariable("userId") int userId);

	@Operation(summary = "Get Bikes by id user")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return Bikes by id user"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content), })
	public ResponseEntity<List<BikeModel>> getBikes(@PathVariable("userId") int userId);
}
