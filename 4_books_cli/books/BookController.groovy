
@Grab("h2")
@Grab("spring-boot-starter-thymeleaf")

@Controller
@RequestMapping("/books")
class BookController {

	BookRepository bookRepository

	@Autowired
	BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository
	}
	
	@RequestMapping(method=RequestMethod.GET)
	def getBooks(Model model) {
		def books = bookRepository.findAll()
        model.addAttribute("books", books)

		return "bookList"
	}
	
	@RequestMapping(method=RequestMethod.POST)
	def addBook(Book book) {
		bookRepository.save(book)
		return "redirect:/books"
	}
}
