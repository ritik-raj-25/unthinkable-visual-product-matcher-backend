package com.unthinkable.assignment.unthinkable_assignment.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unthinkable.assignment.unthinkable_assignment.entities.Product;
import com.unthinkable.assignment.unthinkable_assignment.repositories.ProductRepository;
import com.unthinkable.assignment.unthinkable_assignment.services.EmbeddingService;

@Component
public class DataLoader implements CommandLineRunner {

	private ProductRepository productRepository;
	private EmbeddingService embeddingService;

	public DataLoader(ProductRepository productRepository, EmbeddingService embeddingService) {
		this.productRepository = productRepository;
		this.embeddingService = embeddingService;
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		if (productRepository.count() > 0) {
			return; // products table is already populated
		}

		List<Product> products = List.of(
				new Product(null, "Watch", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/watch-1.jpg", null),
				new Product(null, "Watch", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/watch-2.jpg", null),
				new Product(null, "Watch", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/watch-3.jpg", null),
				new Product(null, "Watch", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/watch-4.jpg", null),
				new Product(null, "Smartphone", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/smartPhone-1.jpg", null),
				new Product(null, "Smartphone", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/smartPhone-2.jpg", null),
				new Product(null, "Smartphone", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/smartPhone-3.jpg", null),
				new Product(null, "Smartphone", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/smartPhone-4.jpg", null),
				new Product(null, "laptop", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/laptop-1.jpg", null),
				new Product(null, "laptop", Category.ELECTRONICS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/laptop-2.jpg", null),
				new Product(null, "tshirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/tshirt-1.jpg", null),
				new Product(null, "tshirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/tshirt-2.jpg", null),
				new Product(null, "tshirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/tshirt-3.jpg", null),
				new Product(null, "tshirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/tshirt-4.jpg", null),
				new Product(null, "tshirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/tshirt-5.jpg", null),
				new Product(null, "shirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/shirt-1.jpg", null),
				new Product(null, "shirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/shirt-2.jpg", null),
				new Product(null, "shirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/shirt-3.jpg", null),
				new Product(null, "shirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/shirt-4.jpg", null),
				new Product(null, "shirt", Category.CLOTHING,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/shirt-5.jpg", null),
				new Product(null, "fan", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/fan-1.jpg", null),
				new Product(null, "fan", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/fan-2.jpg", null),
				new Product(null, "fan", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/fan-3.jpg", null),
				new Product(null, "fan", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/fan-4.jpg", null),
				new Product(null, "refrigerator", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/refrigerator-1.jpg", null),
				new Product(null, "refrigerator", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/refrigerator-2.jpg", null),
				new Product(null, "refrigerator", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/refrigerator-3.jpg", null),
				new Product(null, "washing machine", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/washingMachine-1.jpg",
						null),
				new Product(null, "washing machine", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/washingMachine-2.jpg",
						null),
				new Product(null, "washing machine", Category.HOME_APPLIANCES,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/washingMachine-3.jpg",
						null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-1.jpg", null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-2.jpg", null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-3.jpg", null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-4.jpg", null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-5.jpg", null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-6.jpg", null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-7.jpg", null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-8.jpg", null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-9.jpg", null),
				new Product(null, "book", Category.BOOKS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/book-10.jpg", null),
				new Product(null, "teddy bear", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/teddyBear-1.jpg", null),
				new Product(null, "teddy bear", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/teddyBear-2.jpg", null),
				new Product(null, "teddy bear", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/teddyBear-3.jpg", null),
				new Product(null, "teddy bear", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/teddyBear-4.jpg", null),
				new Product(null, "doll", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/doll-1.jpg", null),
				new Product(null, "doll", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/doll-2.jpg", null),
				new Product(null, "doll", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/doll-3.jpg", null),
				new Product(null, "doll", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/doll-4.jpg", null),
				new Product(null, "toy car", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/toyCar-1.jpg", null),
				new Product(null, "toy car", Category.TOYS,
						"https://unthinkable-assignment-products.s3.ap-south-1.amazonaws.com/toyCar-2.jpg", null));

		productRepository.saveAll(products);

		for (Product product : products) {
			try {
				float[] embedding = embeddingService.embedFromUrl(product.getImageUrl());
				product.setEmbedding(embedding);
			} catch (Exception e) {
				System.out.println("Failed embedding for: " + product.getImageUrl());
			}
			Thread.sleep(10000); // to avoid hitting rate limits
		}

		productRepository.saveAll(products);
	}
}
