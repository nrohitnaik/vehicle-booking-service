package com.car.booking.service;

import com.car.booking.controller.dto.UserDto;
import com.car.booking.entity.User;
import com.car.booking.mapper.UserMapper;
import com.car.booking.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public User saveUser(User user) {
    Assert.notNull(user, "User must not be null");
    return userRepository.saveAndFlush(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public Optional<User> findById(Long id) {
    Assert.notNull(id, "Id must not be null");
    return userRepository.findById(id);
  }

  public Optional<User> findByEmail(String email) {
    Assert.hasLength(email, "Email must not be empty");
    return userRepository.findByEmail(email);
  }

  public List<UserDto> findByLastName(String lastName) {
    Assert.hasLength(lastName, "LastName must not be empty");
    User user = new User();
    user.setLastName(lastName);
    return mapToUserDto(userRepository.findAll(Example.of(user)));
  }

  private List<UserDto> mapToUserDto(List<User> users) {
    return users.stream()
                .map(user -> userMapper.userToUserDto(user))
                .collect(Collectors.toList());
  }
}