package services;

import dao.LoanDao;
import entity.Loan;

import java.util.List;

public class LoanService {
    private LoanDao loanDao;

    public LoanService(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    public List<Loan> getLoansByUserId(Long userId) {
        return loanDao.getLoansByUserId(userId);
    }

    public List<Loan> getExpiredLoans() {
        return loanDao.getExpiredLoans();
    }
}

