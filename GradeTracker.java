import apple.Student;
import apple.Module;
import java.util.*;

public class GradeTracker {
    private static ArrayList<Student> Students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // obj............

        Students.add(new Student("MGMG", "1"));
        Students.add(new Student("AUNGAUNG", "2"));

        while (true) {
            System.out.print(
                    "1:Student Management\n2:Module Management\n3:Assessment Management\n4:End Program\nEnter Option: ");
            int main_option = scan.nextInt();

            // Students..................
            if (main_option == 1) {

                while (true) {
                    System.out.print(
                            "1:Create new students\n2:Delete new students\n3:Calculate GPA\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();
                    // create new students............
                    if (sm_option == 1) {
                        Student std = new Student();
                        // name...............
                        System.out.print("Enter student name; ");
                        String std_name = scan.next();
                        std.setName(std_name);

                        // id.....................
                        System.out.print("Enter student id; ");
                        String std_id = scan.next();
                        std.setStudentID(std_id);

                        Students.add(std);
                        System.out.println("New student is created successfully:\nName: "
                                + Students.get(Students.indexOf(std)).getName() + "\nid: "
                                + Students.get(Students.indexOf(std)).getStudentID());
                        System.out.println(Students);

                    }

                    // delete new students..............
                    else if (sm_option == 2) {
                        System.out.println("Enter the student id to delete: ");
                        String del_id = scan.next();
                        for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
                            Student Student = x.next();
                            if (Student.getStudentID().equals(del_id)) {
                                x.remove();
                            }
                        }
                        System.out.println(Students);

                    }
                    // GPA....................
                    else if (sm_option == 3) {
                        System.out.println("mango");
                    } else if (sm_option == 0) {
                        break;
                    } else {
                        System.out.println("\nInvalid Input.Please Try Again!!\n");
                    }

                }

            }
            // Modules........................

            else if (main_option == 2) {

                while (true) {
                    System.out.print(
                            "1:Add modules number of a student\n2:Delete modules from a student\n3:Get student mark\n4:Get student grade\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();
                    // Add Module................
                    if (sm_option == 1) {
                        String module_loop = "y";
                        while (true) {
                            if (module_loop.equals("y")) {
                                System.out.print("Enter student id to add modules; ");
                                String mod_std_id = scan.next();

                                for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
                                    Student Student = x.next();
                                    if (Student.getStudentID().equals((mod_std_id))) {

                                        do {
                                            Module std_module = new Module();
                                            System.out.print("add module name: ");
                                            String module_name = scan.next();
                                            std_module.setModuleName(module_name);

                                            System.out.print("add module code: ");
                                            String module_code = scan.next();
                                            std_module.setModuleCode(module_code);

                                            System.out.print("add module description: ");
                                            String module_description = scan.next();
                                            std_module.setDescription(module_description);

                                            System.out.print("Do you want to add more module(y/n): ");
                                            module_loop = scan.next();
                                            Student.setModules(std_module);
                                            System.out.print(Student);
                                            System.out.print(Student.getModules());

                                        } while (module_loop.equals("y"));
                                    }
                                }
                            } else {
                                break;
                            }
                        }

                    }

                    // Delete Modules....................

                    else if (sm_option == 2) {

                        while (true) {

                            System.out.print("Enter student id to remove modules; ");
                            String mod_std_id = scan.next();

                            for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
                                Student Student = x.next();
                                if (Student.getStudentID().equals((mod_std_id))) {

                                    System.out.print(Student.getModules());

                                    System.out.print("Enter module code to remove: ");
                                    String del_module_code = scan.next();

                                    for (Iterator<Module> y = Student.getModules().iterator(); y.hasNext();) {
                                        Module Module = y.next();
                                        if (del_module_code.equals(Module.getModuleCode())) {
                                            y.remove();

                                        }
                                    }
                                    System.out.print(Student.getModules());

                                }
                            }
                        }

                    } else if (sm_option == 3) {
                        System.out.println("mango");
                    } else if (sm_option == 4) {
                        System.out.println("pineapple");
                    } else if (sm_option == 0) {
                        break;
                    } else {
                        System.out.println("\nInvalid Input.Please Try Again!!\n");
                    }
                }

            }

            // Assessment.....................
            else if (main_option == 3) {

                while (true) {
                    System.out.print(
                            "1:Add assessment numbers of a student\n2:Remove assessment numbers of a student\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();
                    if (sm_option == 1) {
                        System.out.println(Students);
                    } else if (sm_option == 2) {
                        System.out.println("banana");
                    } else if (sm_option == 0) {
                        break;
                    } else {
                        System.out.println("\nInvalid Input.Please Try Again!!\n");
                    }
                }

            } else if (main_option == 4) {
                System.out.println("\nProgram is terminated");
                System.exit(0);
            }

            else {
                System.out.println("\nInvalid Input.Please Try Again!!\n");

            }

        }
    }
}
