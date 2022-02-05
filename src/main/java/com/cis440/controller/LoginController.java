package com.cis440.controller;

import com.cis440.model.User;
import com.cis440.model.UserLogin;
import com.cis440.service.LoginService;
import com.cis440.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

	private LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Deprecated
	@GetMapping(value = "/login", produces = "application/json")
	public ResponseEntity<User> checkLogin(@RequestParam String username, @RequestParam String password) {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(loginService.checkLogin(username, password));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Login Success"),
			@ApiResponse(responseCode = "401", description = "Login Failed", content = @Content)
	})
	@Operation(summary = "Login", description = "Checks username and password. Eg.\n'username': 'test'\n'password':'test12'\nwill be successful.")
	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<User> checkLogin(@RequestBody UserLogin userLogin) {
		try{
			User loggedUser = loginService.checkLogin(userLogin);
			return ResponseEntity.status(HttpStatus.OK).body(loggedUser);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

}
