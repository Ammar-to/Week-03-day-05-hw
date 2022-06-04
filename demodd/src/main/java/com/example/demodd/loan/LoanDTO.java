package com.example.demodd.loan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class LoanDTO {
    private Integer userId;
    private Integer bookId;
}
