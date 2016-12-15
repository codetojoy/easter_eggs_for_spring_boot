
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController {
    def id = 1
    def books = [] 

    BookController() {
        books << new Book(id: 11, title: "The Undoing Project", author: "Michael Lewis")
        books << new Book(id: 22, title: "Blink", author: "Malcolm Gladwell")
        books << new Book(id: 33, title: "Freakonomics", author: "Levitt,Dubner")
        id = 34
    }

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    @ResponseBody def getBooks() {    
        return ["books": books]
    }

    @RequestMapping(method=RequestMethod.POST, produces="application/json")
    @ResponseBody Book createBook(@RequestBody Book book) {
        book.id = id++
        books << book
        return book
    }
}
