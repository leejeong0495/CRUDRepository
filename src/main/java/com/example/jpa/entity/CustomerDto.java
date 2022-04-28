package com.example.jpa.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
	private String name;
	private String address;
}
