# Visual Product Matcher - Backend

This repository contains the **backend** of the Visual Product Matcher app, implemented in **Spring Boot**.

---

## 🛠 Tech Stack

- **Backend:** Spring Boot (Maven)  
- **Image vector embedding:** Jina AI for vector embeddings  
- **Similarity Metric:** Cosine Similarity  
- **Database:** H2 (in-memory for demo)
- **Storage:** Amazon S3 (sample product storage)

---

## 🚀 Deployment

- **Backend (Railway):** [Backend Link](https://unthinkable-visual-product-backend-production-0a98.up.railway.app)

---

## ⚙️ How It Works

1. Receives image uploads or image URLs from the frontend.  
2. Make call to Jina AI API for image embedding.  
3. Applies **Cosine Similarity** to find visually similar products.  
4. Returns matching results with similarity score >= 0.7 to the frontend.

---

## 👨‍💻 Author

**Ritik Raj**  
MCA, VIT Vellore