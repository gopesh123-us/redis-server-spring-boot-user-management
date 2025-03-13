package live.learnjava.redisusermanagement.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import live.learnjava.redisusermanagement.entity.UserEntity;
import live.learnjava.redisusermanagement.service.IUserService;

@RestController
@RequestMapping("/api/v1")
public class UserOperationsController {

	// user service
	@Autowired
	private IUserService service;

	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody UserEntity user) {
		service.saveUser(user);
		String message = "Saved: " + user;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserEntity> getUser(@PathVariable String userId) {
		UserEntity user = service.getUser(userId);
		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		service.deleteUser(userId);
		String message = "Deleted user with id " + userId;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/allKeys")
	public ResponseEntity<Set<String>> getAllKeys() {
		Set<String> keys = service.getAllUserKeys();
		return new ResponseEntity<Set<String>>(keys, HttpStatus.OK);
	}

}
