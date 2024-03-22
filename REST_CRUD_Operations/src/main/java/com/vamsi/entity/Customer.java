package com.vamsi.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="CUSTOMER")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {

	@Id
	@SequenceGenerator(name="gen1", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator ="gen1", strategy = GenerationType.SEQUENCE )
	@Column(name="C_ID")
	private Integer id;
	
	@Column(name="C_NAME")
	private String cName;
	@Column(name="C_ADDRS")
	private String cAddress;
	@Column(name="C_DESTINATION")
	private String destination;
	@Column(name="TRIP_PRICE")
	private Double price;
	@Column(name="START_DATE")
	private LocalDate startDate;
	@Column(name="END_DATE")
	private LocalDate endDate;
}
