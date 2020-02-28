package com.car.booking.controller;


import com.car.booking.controller.dto.UserDto;
import com.car.booking.entity.User;
import com.car.booking.service.UserService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<User> getUsers() {
    log.debug("Getting all users");
    return userService.findAll();
  }

  @GetMapping(value = "/{id}")
  public User getUserById(@PathVariable("id") Long id) {
    Optional<User> optionalUser = userService.findById(id);
    return optionalUser.orElseThrow(
        () -> new NoSuchElementException("No user found with id " + id)
    );
  }

  @GetMapping("/search")
  public ResponseEntity searchUserByLastName(@RequestParam("last-name") String lastName) {
    log.debug("Searching user with last name {}", lastName);
    List<UserDto> users = userService.findByLastName(lastName);
    if (users.isEmpty()) {
      throw new NoSuchElementException("No users found with last name " + lastName);
    }
    return ResponseEntity.ok(users);
  }
}
