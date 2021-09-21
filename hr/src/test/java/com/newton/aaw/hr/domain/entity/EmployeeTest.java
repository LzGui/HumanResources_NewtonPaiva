package com.newton.aaw.hr.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import com.newton.aaw.hr.api.EmployeeDto;
import com.newton.aaw.hr.domain.enums.Gender;

class EmployeeTest {

	@Test
	void test_createFromDto_withValidDto_shouldCreateOk() {
		//given:
		var dto = new EmployeeDto();
		
		dto.setFirstName("Luiz Guilherme");
		dto.setLastName("Costa");
		dto.setDateOfBirth(LocalDate.of(1991, 06, 12));
		dto.setGender(Gender.MALE);
		dto.setStartDate(LocalDate.of(2021, 12, 20));
		dto.setEndDate(LocalDate.of(2025, 05, 12));
		dto.setPosition("Development");
		dto.setMonthlySalary(5000.0f);
		dto.setHourSalary("25.0f");
		dto.setArea("Devs");
		
		//test:
		var result = new Employee(dto);
		
		//assert:
		assertEquals(dto.getFirstName(), result.getFirstName());
		assertEquals(dto.getLastName(), result.getLastName());
		assertEquals(dto.getDateOfBirth(), result.getDateOfBirth());
		assertEquals(dto.getGender(), result.getGender());
		assertEquals(dto.getStartDate(), result.getStartDate());
		assertEquals(dto.getEndDate(), result.getEndDate());
		assertEquals(dto.getPosition(), result.getPosition());
		assertEquals(dto.getMonthlySalary(), result.getMonthlySalary());
		assertEquals(dto.getHourSalary(), result.getHourSalary());
		assertEquals(dto.getArea(), result.getArea());
	}

}
