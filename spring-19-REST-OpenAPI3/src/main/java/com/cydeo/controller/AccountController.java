package com.cydeo.controller;

import com.cydeo.dto.AccountDTO;
import com.cydeo.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//How can modify controller endpoints? @Tag or @Tags
@RestController
@RequestMapping("/api/v1/accounts")
@Tag(name = "Account", description = "Account CRUD Operations")
@Tags(value = {@Tag(name = "Account", description = "Account CRUD Operations"),
        @Tag(name = "Account2", description = "Account2 CRUD Operations")})
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/list")
    @Operation(summary = "Read all accounts") // some summary for endpoints
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping("{id}")
    @Operation(summary = "Read an account by id")
    public ResponseEntity<AccountDTO> getById(@RequestParam("id") Long id) throws Exception {
        return ResponseEntity.ok(accountService.getById(id));
    }

}
