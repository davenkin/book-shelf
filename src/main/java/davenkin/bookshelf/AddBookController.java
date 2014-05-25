package davenkin.bookshelf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Davenkin on 5/25/14.
 */

@Controller
@RequestMapping("/addBook")
public class AddBookController {

    @RequestMapping(method = RequestMethod.GET)
    public String addBook() {
        return "jsp/addBook.jsp";
    }
}
