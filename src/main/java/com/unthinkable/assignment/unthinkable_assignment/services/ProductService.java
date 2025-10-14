package com.unthinkable.assignment.unthinkable_assignment.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unthinkable.assignment.unthinkable_assignment.dtos.ProductResponseDto;

public interface ProductService {
	List<ProductResponseDto> searchSimilarProducts(
			    MultipartFile productImage,
			    String imageUrl
			) throws IOException, InterruptedException;
}
