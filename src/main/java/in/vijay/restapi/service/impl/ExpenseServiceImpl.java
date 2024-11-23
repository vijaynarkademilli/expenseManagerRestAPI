package in.vijay.restapi.service.impl;

import in.vijay.restapi.dto.ExpensesDTO;
import in.vijay.restapi.entity.ExpenseEntity;
import in.vijay.restapi.repository.ExpenseRepository;
import in.vijay.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ExpensesDTO> getAllExpenses() {
        List<ExpenseEntity> list = expenseRepository.findAll();
        return list.stream().map(this::mapToExpenseDTO).collect(Collectors.toList());
    }

    private ExpensesDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpensesDTO.class);
    }
}
