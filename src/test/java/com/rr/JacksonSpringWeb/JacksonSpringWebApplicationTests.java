package com.rr.JacksonSpringWeb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rr.JacksonSpringWeb.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JacksonSpringWebApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testThatObjectMapperCanCreateJSONFromObject() throws JsonProcessingException {
		ObjectMapper ojectMapper = new ObjectMapper();
		Book book = Book.builder()
				.isbn("978-02411-894-50")
				.title("Who Rules the World?")
				.author("Noam Chomsky")
				.yearPublished("2017")
				.build();

		String result = ojectMapper.writeValueAsString(book);
		assertThat(result).isEqualTo("{\"isbn\":\"978-02411-894-50\",\"title\":\"Who Rules the World?\",\"author\":\"Noam Chomsky\",\"year\":\"2017\"}");
	}

	@Test
	void testThatObjectMapperCanCreateJavaFromJSONObject() throws JsonProcessingException {

		Book book = Book.builder()
				.isbn("978-02411-894-50")
				.title("Who Rules the World?")
				.author("Noam Chomsky")
				.yearPublished("2017")
				.build();

		String json = "{\"foo\":\"bar\",\"isbn\":\"978-02411-894-50\",\"title\":\"Who Rules the World?\",\"author\":\"Noam Chomsky\",\"year\":\"2017\"}";

		ObjectMapper objectMapper = new ObjectMapper();
		Book result = objectMapper.readValue(json, Book.class);

		assertThat(result).isEqualTo(book);
	}

}