package com.java.employeeservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.employeeservice.dto.EmployeeDto;
import com.java.employeeservice.entity.Employee;

public class EmployeeUtil {

    public static Employee mapToEmployee(EmployeeDto employeeDto){
       return objectMapper().convertValue(employeeDto, Employee.class);
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return objectMapper().convertValue(employee, EmployeeDto.class);
    }

    private static ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
