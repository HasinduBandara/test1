package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Employee class represents an employee with basic salary and overtime hours.
 * Provides methods for calculating net salary, tax, and salary after tax.
 */
public class Employee {

    private int empId;
    private String empName;
    private double basicSalary;
    private double overtimeHours;

    /**
     * Main method to demonstrate the functionality of the Employee class.
     */
    public static void main(String[] args) {
        double result = calcNetSalary();
        System.out.println(result);

        if (result > Constants.TAX_THRESHOLD) {
            System.out.println("You are subjected to Tax Payment");
        }

        double tax = calcTax();
        System.out.println("You have to pay a tax of " + tax);

        double finalTotal = calcSalaryAfterTax();
        System.out.println("Your salary after deducting tax is " + finalTotal);

        getDBDetails();
    }

    /**
     * Retrieves database details from the configuration file.
     */
    public static void getDBDetails() {
        Connection connection;
        Properties properties = new Properties();

        try {
            properties.load(Employee.class.getResourceAsStream("config.properties"));
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String tableName = properties.getProperty("tablename");
            String password = properties.getProperty("password");

            connection = DriverManager.getConnection(url, username, password);

            System.out.println("You are connected to database through " + url + " as " + username +
                    " user. All your details are stored in " + tableName + " table.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates the net salary based on basic salary and overtime hours.
     *
     * @return the net salary
     */
    public static double calcNetSalary() {
        double overtimeRate = Constants.OVERTIME_RATE;
        double netTotal = 0;

        Employee employee = new Employee();
        employee.empId = 1;
        employee.empName = "John";
        employee.basicSalary = 50000;
        employee.overtimeHours = 2;

        netTotal = employee.basicSalary + employee.overtimeHours * overtimeRate;
        return netTotal;
    }

    /**
     * Calculates the tax amount based on net salary.
     *
     * @return the tax amount
     */
    public static double calcTax() {
        double overtimeRate = Constants.OVERTIME_RATE;
        double netTotal = 0;
        double taxAmount = 0;

        Employee employee = new Employee();
        employee.empId = 1;
        employee.empName = "John";
        employee.basicSalary = 50000;
        employee.overtimeHours = 2;

        netTotal = employee.basicSalary + employee.overtimeHours * overtimeRate;
        taxAmount = netTotal * Constants.TAX_RATE;

        return taxAmount;
    }

    /**
     * Calculates the salary after deducting tax.
     *
     * @return the salary after tax
     */
    public static double calcSalaryAfterTax() {
        double overtimeRate = Constants.OVERTIME_RATE;
        double netTotal = 0;
        double taxAmount = 0;
        double finalSalary = 0;

        Employee employee = new Employee();
        employee.empId = 1;
        employee.empName = "John";
        employee.basicSalary = 50000;
        employee.overtimeHours = 2;

        netTotal = employee.basicSalary + employee.overtimeHours * overtimeRate;
        taxAmount = netTotal * Constants.TAX_RATE;
        finalSalary = netTotal - taxAmount;

        return finalSalary;
    }
}