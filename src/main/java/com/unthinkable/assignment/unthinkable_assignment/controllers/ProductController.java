package com.unthinkable.assignment.unthinkable_assignment.controllers;

import java.util.List;

import org.hibernate.validator.constraints.URL;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.unthinkable.assignment.unthinkable_assignment.dtos.ProductResponseDto;
import com.unthinkable.assignment.unthinkable_assignment.services.ProductService;

@RestController
@RequestMapping("/api")
@Validated
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("/search/images")
	public ResponseEntity<List<ProductResponseDto>> searchSimilarProducts(
				@RequestPart(name = "productImage", required = false) MultipartFile productImage,
				@RequestParam(name = "imageUrl", required = false) @URL(message = "Please enter valid URL.") String imageUrl
			) throws Exception {
		List<ProductResponseDto> similarProducts = productService.searchSimilarProducts(productImage, imageUrl);
		return ResponseEntity.ok().body(similarProducts);
	}
		
}
