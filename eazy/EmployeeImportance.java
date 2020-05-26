import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EmployeeImportance
 * @Description #690 员工的重要性
 * @Author MatthewHan
 * @Date 2020/5/26 16:51
 * @Version 1.0
 **/
public class EmployeeImportance {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    /**
     * 执行用时 : 14 ms , 在所有 Java 提交中击败了 25.68% 的用户
     * 内存消耗 : 41.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     * @param employees
     * @param id
     * @return
     */
    public static int getImportance(List<Employee> employees, int id) {

        for (Employee employee : employees) {
            if (id == employee.id) {
                int sum = employee.importance;
                List<Integer> list = employee.subordinates;
                for (Integer integer : list) {
                    sum += getImportance(employees, integer);
                }
                return sum;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Employee> employees=  new ArrayList<>();
        Employee employee1= new Employee();
        List<Integer> list1 = new ArrayList<Integer>() {
            {
                this.add(2);
                this.add(3);
            }
        };
        employee1.id = 1;
        employee1.importance = 10;
        employee1.subordinates = list1;

        Employee employee2= new Employee();
        List<Integer> list2 = new ArrayList<Integer>();
        employee2.id = 2;
        employee2.importance = 5;
        employee2.subordinates = list2;

        Employee employee3= new Employee();
        List<Integer> list3 = new ArrayList<Integer>();
        employee3.id = 3;
        employee3.importance = 2;
        employee3.subordinates = list3;

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        System.out.println(getImportance(employees, 1));
    }
}

