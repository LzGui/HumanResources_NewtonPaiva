package com.newton.aaw.hr.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.newton.aaw.hr.api.EmployeeDto;
import com.newton.aaw.hr.domain.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private Gender gender;
	private LocalDate startDate; // yyyy-mm-dd
	private LocalDate endDate;
	private String position;
	private Float monthlySalary;
	private String hourSalary;
	private String area;
	private LocalDateTime createdAt; // yyyy-mm-dd HH:mm:ss
	private LocalDateTime ModifiedAt;
	
	public Employee(EmployeeDto e) {
		this.setFirstName(e.getFirstName());
		this.setLastName(e.getLastName());
		this.setDateOfBirth(e.getDateOfBirth());
		this.setGender(e.getGender());
		this.setStartDate(e.getStartDate());
		this.setEndDate(e.getEndDate());
		this.setPosition(e.getPosition());
		this.setMonthlySalary(e.getMonthlySalary());
		this.setHourSalary(e.getHourSalary());
		this.setArea(e.getArea());
	}
}
