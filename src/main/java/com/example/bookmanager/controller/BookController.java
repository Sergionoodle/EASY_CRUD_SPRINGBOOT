package com.example.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.example.bookmanager.model.Book;
import com.example.bookmanager.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("allBooks", bookService.getAllBooks());
		return "index";
	}
	
	@GetMapping("/addNewBook")
	public String addNewBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "new_book";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book)
	{
		bookService.saveBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") long id, Model model)
	{
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "update_book";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteThroughId(@PathVariable(value = "id") long id)
	{
		bookService.deleteBook(id);
		return "redirect:/";
	}
}
