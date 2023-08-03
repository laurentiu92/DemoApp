package com.practice.service;

import com.practice.db.entity.UserEntity;
import com.practice.db.repository.UserRepository;
import com.practice.model.UserDO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	public List<UserDO> getAllUsers() {
		return userRepository.findAll().stream()
				.map(userEntity -> {
					return UserDO.builder()
							.uuid(userEntity.getId())
							.firstName(userEntity.getFirstName())
							.lastName(userEntity.getLastName())
							.age(userEntity.getAge())
							.birthDate(LocalDate.parse(userEntity.getBirthDate()))
							.email(userEntity.getEmail())
							.build();
				}).toList();
	}

	public void createUser(UserDO userDO) {
		var userEntity = UserEntity.builder()
				.firstName(userDO.getFirstName())
				.lastName(userDO.getLastName())
				.age(userDO.getAge())
				.birthDate(userDO.getBirthDate().toString())
				.email(userDO.getEmail())
				.build();

		userRepository.save(userEntity);
	}

	public void deleteUser(UUID uuid){
		userRepository.deleteById(uuid);
	}
}