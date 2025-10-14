package com.unthinkable.assignment.unthinkable_assignment.services.impl;

import com.unthinkable.assignment.unthinkable_assignment.services.EmbeddingService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class EmbeddingServiceJinaImpl implements EmbeddingService {

	@Value("${jina.api.key}")
	private String apiKey;

	private static final String JINA_EMBED_URL = "https://api.jina.ai/v1/embeddings";
	private static final String MODEL = "jina-embeddings-v4";

	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public float[] embedFromUrl(String imageUrl) throws IOException {
		Map<String, Object> requestBody = Map.of("model", MODEL, "input", List.of(Map.of("image", imageUrl)));

		HttpHeaders headers = buildHeaders();
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.exchange(JINA_EMBED_URL, HttpMethod.POST, request, String.class);

		if (response.getStatusCode() != HttpStatus.OK) {
			throw new IOException("Jina API failed: " + response.getBody());
		}

		return parseEmbedding(response.getBody());
	}

	@Override
	public float[] embedFromBytes(MultipartFile productImage) throws IOException {
		String base64 = Base64.getEncoder().encodeToString(productImage.getBytes());
		String base64Image = "data:image/jpeg;base64," + base64;

		Map<String, Object> requestBody = Map.of("model", MODEL, "input", List.of(Map.of("image", base64Image)));

		HttpHeaders headers = buildHeaders();
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.exchange(JINA_EMBED_URL, HttpMethod.POST, request, String.class);

		if (response.getStatusCode() != HttpStatus.OK) {
			throw new IOException("Jina API failed: " + response.getBody());
		}

		return parseEmbedding(response.getBody());
	}

	private HttpHeaders buildHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + apiKey);
		return headers;
	}

	private float[] parseEmbedding(String responseBody) {
		JSONObject json = new JSONObject(responseBody);
		JSONArray dataArray = json.getJSONArray("data");
		JSONObject firstItem = dataArray.getJSONObject(0);
		JSONArray embeddingArray = firstItem.getJSONArray("embedding");

		float[] embedding = new float[embeddingArray.length()];
		for (int i = 0; i < embeddingArray.length(); i++) {
			embedding[i] = (float) embeddingArray.getDouble(i);
		}
		return embedding;
	}
}