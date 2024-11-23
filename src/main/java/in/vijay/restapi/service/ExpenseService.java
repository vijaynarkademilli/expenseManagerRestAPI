package in.vijay.restapi.service;

import in.vijay.restapi.dto.ExpensesDTO;

import java.util.List;

public interface ExpenseService {

    List<ExpensesDTO> getAllExpenses();

}
