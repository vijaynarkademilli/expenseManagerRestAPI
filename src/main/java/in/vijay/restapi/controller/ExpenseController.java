package in.vijay.restapi.controller;

import in.vijay.restapi.dto.ExpensesDTO;
import in.vijay.restapi.io.ExpenseResponse;
import in.vijay.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses() {
        log.info("GET/expenses called");
        List<ExpensesDTO> allExpenses = expenseService.getAllExpenses();
        return allExpenses.stream().map(this::mapToExpenseResponse).collect(Collectors.toList());
    }

    private ExpenseResponse mapToExpenseResponse(ExpensesDTO expensesDTO) {
        return modelMapper.map(expensesDTO, ExpenseResponse.class);
    }

}
