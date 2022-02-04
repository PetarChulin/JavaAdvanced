package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {

    public String name;
    public int capacity;
    public List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.employees.size();
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        if (this.getCapacity() > employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int oldestEmployee = 0;
        int index = 0;

        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getAge() >= oldestEmployee) {
                index = i;
                oldestEmployee = this.employees.get(i).getAge();
            }
        }
        return this.employees.get(index);

    }

    public String report() {
        StringBuilder build = new StringBuilder();

        build.append(String.format("Employees working at Cafe %s:\n" , getName()));
        for (Employee employee : employees) {
            build.append(employee.toString()).append("\n");
        }
        return build.toString();
    }
}
