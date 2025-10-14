package com.unthinkable.assignment.unthinkable_assignment.dtos;

import com.unthinkable.assignment.unthinkable_assignment.utils.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
	private Long id;
	private Double similarityScore;
	private String name;
	private Category category;
	private String imageUrl;
}
