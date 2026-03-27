import java.util.*;

class Student {
    String id;
    String name;
    int age;

    Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
public String toString() {
    return String.format("%-12s %-22s %-3d", id, name, age);
}
}

public class StudentRecord {
    static TreeMap<String,Student> students=new TreeMap<>();
    static Scanner sc = new Scanner(System.in);
    
static int getValidAge() {
    while (true) {
        try {
            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            if (age <= 0) {
                throw new Exception("Age must be greater than 0");
            }

            return age;

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

    // Add Method
    static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.next();
        sc.nextLine();
        if(students.containsKey(id)){
                System.out.println("\nID already exists!");
                return;
            
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        int age = getValidAge();

        students.put(id,new Student(id, name, age));
        System.out.println("\nStudent added successfully!\n");
    }

    // View Method
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo records found.\n");
            return;
        }
        System.out.printf("%-12s %-22s %-3s\n","ID","Name","Age");

        for (Student s : students.values()) {
            System.out.println(s);
        }
    }

    // Search Method
    static void searchStudent() {
        if (students.isEmpty()) {
            System.out.println("\nNo records to Search!\n");
            return;
        }
        System.out.print("Enter ID to search: ");
        String id = sc.next();
        Student s=students.get(id);
        if(s!=null){
            System.out.printf("%-12s %-22s %-3s\n","ID","Name","Age");
            System.out.println(s);
               
                return;
        }
        
        System.out.println("Student not found!");
    }

    // Update Method
    static void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("\nNo records to update!\n");
            return;
        }
        System.out.print("Enter ID to update: ");
        String id = sc.next();
        sc.nextLine();
        Student s=students.get(id);
        if(s!=null){
             System.out.print("Enter new name: ");
                s.name = sc.nextLine();
                s.age = getValidAge();
                
                System.out.println("\nUpdated successfully!\n");
                return;
        }
       
        System.out.println("Student not found!");
    }

    // Delete Method
    static void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("\nNo records to Delete!\n");
            return;
        }
        System.out.print("Enter ID to delete: ");
        String id = sc.next();
        if(students.remove(id)!=null){
            
             System.out.println("\nDeleted successfully!\n");
                return;
        }
        
        System.out.println("\nStudent not found!\n");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Record System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("\nChoose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.out.println("\n-----Program Existed Successfully-----\n");
                        System.exit(0);
                default: System.out.println("\nInvalid choice!\n");
            }
        }
    }
}