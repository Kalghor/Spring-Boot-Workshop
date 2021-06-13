package pl.coderslab.workshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.workshop.domain.model.Book;
import pl.coderslab.workshop.domain.service.BookService;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/add")
    public String prepareAdd(Model model){
        model.addAttribute("book", new Book());
        return "add-book-form";
    }

    @PostMapping("/add")
    public String processAdd(Book book, BindingResult result){
        if(result.hasErrors()){
            return "add-book-form";
        }
        bookService.add(book);
        return "redirect:/books/all";
    }

    @GetMapping("/delete")
    public String prepareDelete(Model model, Long id){
        model.addAttribute("book", bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "confirm-delete";
    }

    @PostMapping("/delete")
    public String processDelete(Long id){
        bookService.delete(id);
        return "redirect:/books/all";
    }

    @GetMapping("/edit")
    public String prepareEdit(Long id, Model model){
        model.addAttribute("book", bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "edit";
    }

    @PostMapping("/edit")
    public String processEdit(Book book, BindingResult result){
        if(result.hasErrors()){
            return "edit";
        }
        bookService.edit(book);
        return "redirect:/books/all";
    }

    @GetMapping("/show")
    public String showOneBook(Model model, Long id){
        model.addAttribute("book", bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "show";
    }

    @GetMapping("/all")
    public String getBooks(Model model){
        model.addAttribute("books",bookService.getBooks());
        return "list";
    }
}
