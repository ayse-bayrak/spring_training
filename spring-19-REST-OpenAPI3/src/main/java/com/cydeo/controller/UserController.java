package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User", description = "User CRUD Operations")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // How we can modify response and media type modify?  (@ApiResponses)
    @GetMapping("/list")
    @Operation(summary = "Read all users")
    @ApiResponses(value = { // for more than one ApiResponse in method level
            @ApiResponse(responseCode = "200", description = "Successfully retrieved users (OK)",
            content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),// content, leave it empty
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content) // content, leave it empty
    })
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    //if we do like this our API is going to be able to work with xml and Json
    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Create a user")
    @ApiResponse(responseCode = "201", description = "User created successfully (CREATED)",
                    content = {@Content(mediaType = "application/xml"), @Content(mediaType = "application/json")},
                    headers = {@Header(name = "Connection", description = "keep-alive")})
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDTO));
    }

}
