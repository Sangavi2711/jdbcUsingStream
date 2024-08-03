package com.model;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDaO employeeDAO = new EmployeeDaO();

        // Save a new employee with a photo
        
        Employee newEmployee = new Employee(1, "Saranya", "Finance", "Los Angeles", "Analyst", Date.valueOf("2022-09-10"), Date.valueOf("1995-11-22"), null, 70000);
        
        // Path to the photo file
        String photoPath = "C:\\Users\\gsang\\OneDrive\\Desktop\\dq.jpg";
        
        boolean isSaved = employeeDAO.saveEmployee(newEmployee, photoPath);
        if (isSaved) {
            System.out.println("Employee with photo saved successfully.");
        } else {
            System.out.println("Failed to save employee with photo.");
        }
        Employee newEmployee2 = new Employee(2, "Sangavi", "Marketing", "New York", "Manager", Date.valueOf("2021-05-15"), Date.valueOf("1988-02-20"), null, 75000.0);
        String photoPath2 = "C:\\Users\\gsang\\OneDrive\\Desktop\\HD-wallpaper-surya-actor-suriya.jpg"; // Provide the path to the second photo
        if (employeeDAO.saveEmployee(newEmployee2, photoPath2)) {
            System.out.println("Employee 2 saved successfully.");
        } else {
            System.out.println("Failed to save Employee 2.");
        }

        // Save one more employee with a photo
        Employee newEmployee3 = new Employee(3, "Swathika", "IT", "San Francisco", "Developer", Date.valueOf("2023-03-22"), Date.valueOf("1992-08-14"), null, 68000.0);
        String photoPath3 = "C:\\Users\\gsang\\OneDrive\\Desktop\\bts-v.jpg"; // Provide the path to the third photo
        if (employeeDAO.saveEmployee(newEmployee3, photoPath3)) {
            System.out.println("Employee 3 saved successfully.");
        } else {
            System.out.println("Failed to save Employee 3.");
        }

        // Retrieve all employees
        List<Employee> allEmployees = employeeDAO.getAllEmployees();
        System.out.println("\nAll Employees:");
        for (Employee emp : allEmployees) {
            System.out.println(emp.getEname() + " - " + emp.getDept());
        }
        

        // Get employee by ID
        Employee employee = employeeDAO.getEmployeeById(2);
        if (employee != null) {
            System.out.println("\nEmployee with ID 2: " + employee.getEname());
        } else {
            System.out.println("\nEmployee with ID 2 not found.");
        }

        // Update employee salary
        boolean isUpdated = employeeDAO.updateEmployeeSalary(2, 95000);
        if (isUpdated) {
            System.out.println("\nEmployee salary updated successfully.");
        } else {
            System.out.println("\nFailed to update employee salary.");
        }
        //print the employee more than two years
     // Retrieve employees having 2 or more years of experience
        List<Employee> allEmployees1 = employeeDAO.getEmployeesByExp(2);
        System.out.println("\nEmployees having 2 or more years of experience:");
        for (Employee emp : allEmployees1) {
            System.out.println(emp.getEname() + " - " + emp.getDept());
        }

        // Delete employee by ID
        /*
        boolean isDeleted = employeeDAO.deleteEmployeeById(3);
        if (isDeleted) {
            System.out.println("\nEmployee with ID 3 deleted successfully.");
        } else {
            System.out.println("\nFailed to delete employee with ID 3.");
        }*/

//        // Get employee photo by ID and save it to a file
//        byte[] photo = employeeDAO.getEmployeePhotoById(1);
//        employeeDAO.savePhotoToFile(photo, "C:\\Users\\USER\\OneDrive\\Documents\\jdbcprog");
    }
}