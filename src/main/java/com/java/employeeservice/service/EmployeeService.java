package com.java.employeeservice.service;

import com.java.employeeservice.dto.EmployeeDto;
import com.java.employeeservice.entity.Employee;
import com.java.employeeservice.repository.EmployeeRepository;
import com.java.employeeservice.util.EmployeeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto addEmployeeDetails(EmployeeDto employeeDto){
        Employee employee = employeeRepository.save(EmployeeUtil.mapToEmployee(employeeDto));
        return EmployeeUtil.mapToEmployeeDto(employee);
    }

    public List<EmployeeDto> getAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeUtil::mapToEmployeeDto)
                .collect(Collectors.toList());

    }
}
