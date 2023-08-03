package com.practice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserDO {
	private UUID uuid;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private Integer	age;
	private String email;
}
