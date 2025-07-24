package org.example.book_management.controller;


import org.example.book_management.dto.BookDTO;
import org.example.book_management.service.IBookService;
import org.example.book_management.service.IBorrowService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    IBorrowService borrowService;
    @Autowired
    private ModelMapper modelMapper;

    // Danh sách sách
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("books", bookService.findAll()
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .toList());
        return "list";
    }

    // Chi tiết sách
    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable long id, Model model) {
        var book = bookService.finById(id);
        if (book == null) {
            model.addAttribute("error", "Không tìm thấy sách.");
            return "error";
        }
        model.addAttribute("book", modelMapper.map(book, BookDTO.class));
        return "detail";
    }

    // Mượn sách
    @PostMapping("/{id}/borrow")
    public String borrowBook(@PathVariable long id, Model model) {
        String code = borrowService.borrowBook(id);
        if (code == null) {
            model.addAttribute("error", "Không thể mượn sách (có thể đã hết sách).");
            return "error";
        }
        model.addAttribute("code", code);
        return "borrow-success";
    }

    // Form trả sách
    @GetMapping("/return")
    public String showReturnForm() {
        return "return";
    }

    // Xử lý trả sách
    @PostMapping("/return")
    public String returnBook(@RequestParam String code, Model model) {
        boolean success = borrowService.returnBook(code);
        if (!success) {
            model.addAttribute("error", "Mã mượn không hợp lệ hoặc đã trả rồi.");
            return "error";
        }
        return "redirect:/books";
    }
}
