package davenkin.bookshelf.controller;

import davenkin.bookshelf.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Davenkin on 5/25/14.
 */

@Controller
@RequestMapping("/addBook")
public class AddBookController {

    @RequestMapping(method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book",new Book());
        return "addBook";
    }

    @RequestMapping(method=RequestMethod.POST)
    public void submitForm(@ModelAttribute Book book, Model m) {
        m.addAttribute("message", "Successfully saved person: " + book.getAuthor());
        System.out.println(book.getAuthor());
    }
}
