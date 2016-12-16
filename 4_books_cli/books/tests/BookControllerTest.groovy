import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.mockito.Mockito.*

class BookControllerTest {

	@Test
	void shouldReturnBooksFromRepository() {
		def expectedList = []
		expectedList.add(new Book(
				id: 1,
				title: "Spring Boot in Action",
				author: "Craig Walls"
			))

		def mockRepo = mock(BookRepository.class)
		when(mockRepo.findAll()).thenReturn(expectedList)
		
        def controller = new BookController()
		controller.bookRepository = mockRepo

		MockMvc mvc = standaloneSetup(controller)
						.build()
		mvc.perform(get("/books"))
			.andExpect(view().name("bookList"))
			.andExpect(model().attribute("books", expectedList))
	}
}
