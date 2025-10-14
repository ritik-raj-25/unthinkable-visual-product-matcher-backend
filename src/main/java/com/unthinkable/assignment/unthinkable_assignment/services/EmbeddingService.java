package com.unthinkable.assignment.unthinkable_assignment.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface EmbeddingService {
	float[] embedFromUrl(String imageUrl) throws IOException, InterruptedException;

	float[] embedFromBytes(MultipartFile productImage) throws IOException, InterruptedException;
}
