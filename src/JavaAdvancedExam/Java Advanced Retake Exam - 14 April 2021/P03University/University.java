package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(student.getFirstName())
                    && students.get(i).getLastName().equals(student.getLastName())) {
                return "Student is already in the university";
            }
        }
        if (this.getCapacity() > this.getStudents().size()) {
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(student.getFirstName())
                    && students.get(i).getLastName().equals(student.getLastName())) {
                this.students.remove(i);
                return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(firstName)
                    && students.get(i).getLastName().equals(lastName)) {
                return students.get(i);
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder build = new StringBuilder();
        for (Student student : students) {
            build.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s\n",
                    student.getFirstName(), student.getLastName(), student.getBestSubject()));
        }
        return build.toString();
    }
}

