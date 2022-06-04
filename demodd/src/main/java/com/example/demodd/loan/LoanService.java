package com.example.demodd.loan;


import com.example.demodd.book.Book;
import com.example.demodd.book.BookService;
import com.example.demodd.user.MyUser;
import com.example.demodd.user.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final MyUserService myUserService;
    private final BookService bookService;

    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }

    public Loan getLoan(Integer loanId){
        return loanRepository.findById(loanId).get();
    }

    public void addLoan(Loan loan){
        loanRepository.save(loan);
    }

    public void loanOutBook(Integer userId, Integer bookId){
        MyUser user = myUserService.getMyUser(userId);
        Book book =bookService.getBook(bookId);
        Loan loan = new Loan(null, user.getId(), book.getId());
        book.getLoans().add(loan);
        loan.getBooks().add(book);
        loanRepository.save(loan);
    }

    public void returnBook(Integer bookId){
        Book book = bookService.getBook(bookId);
        for(Loan loan: loanRepository.findAll()){
            if(loan.getBooks().contains(book)){
                loan.getBooks().remove(book);
            }
        }
    }
}
