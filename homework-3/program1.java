import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

class program1 {
    public static void main(String[] args) {
        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
        Employee e1 = new Employee(2000, 21), e2 = new Employee(3000, 19);
        employeeArrayList.add(e1);
        employeeArrayList.add(e2);
        Comparator<Employee> compareBySalary;
        compareBySalary = (Employee o1, Employee o2) -> o1.getSalary().compareTo( o2.getSalary() );
        Collections.sort(employeeArrayList, compareBySalary);


        System.out.println(e1.equals(e2));

    }
}

class Employee{

    public Integer salary;
    public Integer age;
    Employee(Integer salary, Integer age) {
        this.age = age;
        this.salary = salary;
    }

    Integer getSalary() {
        return this.salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, age);
    }
}