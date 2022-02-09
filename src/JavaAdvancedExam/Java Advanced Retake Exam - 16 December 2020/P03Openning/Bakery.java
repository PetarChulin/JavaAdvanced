package bakery;



import java.util.ArrayList;
import java.util.List;

public class Bakery {

    public String name;
    public int capacity;
    public List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }
    public void add(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }
    public boolean remove(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int oldest = 0;
        int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getAge() >= oldest) {
                index = i;
                oldest = employees.get(i).getAge();
            }
        }
        return employees.get(index);
    }
    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
    public int getCount() {return employees.size();}

    public String report() {
        StringBuilder build = new StringBuilder();
        build.append(String.format("Employees working at Bakery %s:\n" , name));
        for (Employee employee : employees) {
            build.append(employee).append("\n");
        }
        return build.toString();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
