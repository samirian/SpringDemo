package com.springAop.restControllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springAop.schemas.Book;

@RestController
@RequestMapping("/book")
public class BookController {
	@GetMapping
	public Map<String, Book> getBooks() {
		return Map.of(
				"b1", new Book(1, "b1", "a1"),
				"b2", new Book(1, "b2", "a2"),
				"b3", new Book(1, "b3", "a9")
				);
	}
}
