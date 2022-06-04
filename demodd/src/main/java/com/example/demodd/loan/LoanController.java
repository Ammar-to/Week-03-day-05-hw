package com.example.demodd.loan;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController @RequestMapping("loan/")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;
    Logger logger = LoggerFactory.getLogger(LoanController.class);

    @GetMapping("")
    public ResponseEntity getLoans(){
        logger.info("Invoked get all loans");
        return ResponseEntity.status(200).body(loanService.getLoans());
    }
    @GetMapping("{id}")
    public ResponseEntity getLoan(@PathVariable Integer id){
        logger.info("Invoked get a loan");
        return ResponseEntity.status(200).body(loanService.getLoan(id));
    }

    @PostMapping("out/{userId}/{bookId}")
    public ResponseEntity loanOutABook(@PathVariable Integer userId, Integer bookId){
        loanService.loanOutBook(userId,bookId);
        return ResponseEntity.status(201).body("Loaned out a book!");
    }

    @PostMapping("return/{bookId}")
    public ResponseEntity returnBook(@PathVariable Integer bookId){
        loanService.returnBook(bookId);
        return ResponseEntity.status(201).body("Book returned!");
    }

}
