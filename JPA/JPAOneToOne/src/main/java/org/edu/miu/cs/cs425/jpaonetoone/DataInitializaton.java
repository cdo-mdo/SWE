package org.edu.miu.cs.cs425.jpaonetoone;

import org.edu.miu.cs.cs425.jpaonetoone.model.Account;
import org.edu.miu.cs.cs425.jpaonetoone.model.Department;
import org.edu.miu.cs.cs425.jpaonetoone.model.Employee;
import org.edu.miu.cs.cs425.jpaonetoone.model.Person;
import org.edu.miu.cs.cs425.jpaonetoone.repository.AccountRepository;
import org.edu.miu.cs.cs425.jpaonetoone.repository.DepartmentRepository;
import org.edu.miu.cs.cs425.jpaonetoone.repository.EmployeeRepository;
import org.edu.miu.cs.cs425.jpaonetoone.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializaton implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    Account account1;
    Account account2;
    Account account3;

    Person person1;
    Person person2;
    Person person3;

    Department department1;
    Employee employee1;
    Employee employee2;
    Employee employee3;

    private void createEmployee() {
        employee1 = new Employee("employee1");
        employee2 = new Employee("employee2");
        employee3 = new Employee("employee3");
    }

    private void createDepartment() {
        department1 = new Department("department1");
        department1.addEmployee(employee1);
        department1.addEmployee(employee2);
        department1.addEmployee(employee3);
        departmentRepository.save(department1);
    }

    private void createAccount() {
        account1 = new Account("user1", "user1123");
        account2 = new Account("user2", "user2123");
        account3 = new Account("user3", "user3123");
    }

    private void createPerson() {
        person1 = new Person("person1");
        person2 = new Person("person2");
        person3 = new Person("person3");
        person1.setAccount(account1);
        person2.setAccount(account2);
        person3.setAccount(account3);
        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
    }

    @Override
    public void run(String... args) throws Exception {
        createAccount();
        createPerson();
        createEmployee();
        createDepartment();
    }
}
