package DefiningClassesExercise.P07Google;

public class Company {

    private String companyName;
    private String department;
    private double salary;

    public Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }
    public static Company setCompany(Person person, String[] data) {
        String companyName = data[2];
        String department = data[3];
        double salary = Double.parseDouble(data[4]);
        Company company = new Company(companyName, department, salary);
        person.setCompany(company);
        return company;
    }


    public String companyInfo() {
        return String.format("%s %s %.2f", companyName, department, salary);
    }
}
