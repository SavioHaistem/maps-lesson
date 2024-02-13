import entities.Students;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Students, Integer> bimester = new HashMap<>();
        Students student1 = new Students(1,"Savio");
        Students student2 = new Students(2,"Maria");

        bimester.put(student1,10);
        bimester.put(student2,10);
        bimester.put(student1,8);
        bimester.put(student2,9);

        for (Students student : bimester.keySet()) {
            System.out.print(student.getName());
            System.out.print(" ");
            System.out.print(student.getId());
            System.out.print(" ");
            System.out.print(bimester.get(student));
            System.out.print(" ");
            System.out.print(student.getClass());
            System.out.print("\n");
        }
    }
}