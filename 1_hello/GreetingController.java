
@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    def hello() {    
        return "Hello World"  
    }
}
