package com.unthinkable.assignment.unthinkable_assignment.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.unthinkable.assignment.unthinkable_assignment.dtos.ProductResponseDto;
import com.unthinkable.assignment.unthinkable_assignment.entities.Product;
import com.unthinkable.assignment.unthinkable_assignment.exceptions.ResourceNotFoundException;
import com.unthinkable.assignment.unthinkable_assignment.repositories.ProductRepository;
import com.unthinkable.assignment.unthinkable_assignment.services.EmbeddingService;
import com.unthinkable.assignment.unthinkable_assignment.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	private EmbeddingService embeddingService;
	
	@Value("${similarity.threshold}")
	private double similarityThreshold;
	
	public ProductServiceImpl(ProductRepository productRepository, EmbeddingService embeddingService) {
		this.productRepository = productRepository;
		this.embeddingService = embeddingService;
	}
	
	@Override
	public List<ProductResponseDto> searchSimilarProducts(MultipartFile productImage, String imageUrl) throws IOException, InterruptedException {
		List<Product> products = productRepository.findAll();
		if(products.isEmpty()) {
			throw new ResourceNotFoundException("No products found in the database");
		}
		if(productImage == null && imageUrl == null) {
			throw new IllegalArgumentException("Either productImage or imageUrl must be provided");
		}
		
		List<ProductResponseDto> similarProducts = new ArrayList<>();
		
		if(productImage != null) {
			float[] productImageEmbedding = embeddingService.embedFromBytes(productImage);
			getSimilarProducts(products, similarProducts, productImageEmbedding);
		}
		else {
			float[] productImageEmbedding = embeddingService.embedFromUrl(imageUrl);
			getSimilarProducts(products, similarProducts, productImageEmbedding);
		}
		return similarProducts;
	}

	private void getSimilarProducts(List<Product> products, List<ProductResponseDto> similarProducts,
			float[] productImageEmbedding) {
		products.forEach(product -> {
			double similarityScore = cosineSimilarity(productImageEmbedding, product.getEmbedding());
			if(similarityScore >= similarityThreshold) {
				ProductResponseDto dto = new ProductResponseDto();
				dto.setId(product.getId());
				dto.setName(product.getName());
				dto.setImageUrl(product.getImageUrl());
				dto.setSimilarityScore(similarityScore);
				dto.setCategory(product.getCategory());
				similarProducts.add(dto);
			}
		});
	}
	
	private double cosineSimilarity(float[] vec1, float[] vec2) {
		
		if(vec1 == null || vec2 == null) {
			return 0.0;
		}
		
	    if (vec1.length != vec2.length) {
	        throw new IllegalArgumentException("Vectors must have same length");
	    }

	    double dot = 0.0;
	    double normA = 0.0;
	    double normB = 0.0;

	    for (int i = 0; i < vec1.length; i++) {
	        dot += vec1[i] * vec2[i];
	        normA += vec1[i] * vec1[i];
	        normB += vec2[i] * vec2[i];
	    }
	    if (normA == 0.0 || normB == 0.0) {
	        return 0.0;
	    }
	    return dot / (Math.sqrt(normA) * Math.sqrt(normB));
	}

}
