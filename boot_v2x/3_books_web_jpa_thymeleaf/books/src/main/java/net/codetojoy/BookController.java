package net.codetojoy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BookController {

	private BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);

		return "bookList";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addBook(Book book) {
		bookRepository.save(book);
		return "redirect:/books";
	}
}
