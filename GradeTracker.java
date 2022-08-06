import apple.Student;
import apple.Assessment;
import apple.Module;
import java.util.*;

public class GradeTracker {
    private static ArrayList<Student> Students = new ArrayList<>();


    //method.......
    public static double get_GPA(String id){
        double gpa = 0;
        for(Student x :Students){
                if(x.getStudentID().equals(id)){
                    gpa = x.getGPA();
                }     
        }
        return gpa;
    }

    public static double get_overAllMark(String id,String moduleCode){
        double overallmark = 0;
        for(Student x :Students){
                if(x.getStudentID().equals(id)){
                    for(Module y : x.getModules()){
                        if(y.getModuleCode().equals(moduleCode)){
                            overallmark = y.getOverallMarks();
                        }
                    }
                }
            } 
            return overallmark;    
        }
 
    public static String get_overAllGrade(String id,String moduleCode){
        String overallmark = "";
        for(Student x :Students){
                    if(x.getStudentID().equals(id)){
                        for(Module y : x.getModules()){
                            if(y.getModuleCode().equals(moduleCode)){
                                overallmark = y.getOverallGrade();
                            }
                        }
                    }
                } 
            return overallmark;    
    }
    

    //main..............
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        // obj............

        Students.add(new Student("MGMG", "1"));
        Students.add(new Student("AUNGAUNG", "2"));

        while (true) {
            System.out.print(
                    "\n1:Student Management\n2:Module Management\n3:Assessment Management\n4:End Program\nEnter Option: ");
            int main_option = scan.nextInt();

            // Students..................
            if (main_option == 1) {

                while (true) {
                    System.out.print(
                            "\n1:Create new students\n2:Delete new students\n3:Calculate GPA\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();
                    // create new students............

                    if (sm_option == 1) {
                        Student std = new Student();
                        // name...............
                        System.out.print("\nEnter student name; ");
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
                        String del_std = "y";
                        while (del_std.equals("y")) {
                            System.out.print("\nEnter the student id to delete: ");
                            String del_id = scan.next();
                            for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
                                Student Student = x.next();
                                if (Student.getStudentID().equals(del_id)) {
                                    x.remove();
                                    System.out.println(Students);
                                    System.out.print("Do u want to continue to delete(y/n): ");
                                    del_std = scan.next();
                                    break;
                                } else if (Students.indexOf(Student) == Students.size() - 1) {
                                    System.out.println("Student not found!");
                                }
                            }
                        }
                    }
                    // GPA....................
                    else if (sm_option == 3) {
                        String x = "y";
                        while(x.equals("y")){
                            System.out.println("Enter student id: ");
                            String id = scan.next();
                            System.out.println( get_GPA(id));
                            System.out.println("Do you want to find another student's GPA?(y/n): ");
                            x = scan.next();
                        }
                        
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
                            "\n1:Add modules number of a student\n2:Delete modules from a student\n3:Get student mark\n4:Get student grade\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();
                    // Add Module................
                    if (sm_option == 1) {
                        String module_loop = "y";
                        while (true) {
                            if (module_loop.equals("y")) {
                                System.out.print("\nEnter student id to add modules; ");
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

                                            System.out.print("add creditUnits: ");
                                            int creditUnits = scan.nextInt();
                                            std_module.setCreditUnits(creditUnits);

                                            Student.setModules(std_module);
                                            System.out.print(Student);
                                            System.out.print(Student.getModules());
                                            

                                            System.out.print("\nDo you want to add more module(y/n): ");
                                            module_loop = scan.next();

                                        } while (module_loop.equals("y"));
                                        break;
                                    } else if (Students.indexOf(Student) == Students.size() - 1) {
                                        System.out.println("Student not found!");
                                    }

                                }
                            } else {
                                break;
                            }
                        }

                    }

                    // Delete Modules....................

                    else if (sm_option == 2) {
                        String del_module_loop = "y";

                        while (true) {
                            if (del_module_loop.equals("y")) {
                                System.out.print("\nEnter student id to remove modules; ");
                                String mod_std_id = scan.next();

                                for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
                                    Student Student = x.next();
                                    if (Student.getStudentID().equals((mod_std_id))) {

                                        System.out.print(Student.getModules());

                                        System.out.print("\nEnter module code to remove: ");
                                        String del_module_code = scan.next();

                                        for (Iterator<Module> y = Student.getModules().iterator(); y.hasNext();) {
                                            Module Module = y.next();
                                            if (del_module_code.equals(Module.getModuleCode())) {
                                                y.remove();
                                                System.out.print(Student.getModules());
                                                System.out.print("\nDo you want to delete more module(y/n): ");
                                                del_module_loop = scan.next();
                                                break;

                                            } else if (Student.getModules()
                                                    .indexOf(Module) == Student.getModules().size() - 1) {
                                                System.out.println("Module not found!");
                                            }

                                        }
                                        break;
                                    } else if (Students.indexOf(Student) == Students.size() - 1) {
                                        System.out.println("Student not found!");
                                    }

                                }
                            } else {
                                break;
                            }
                        }

                    } 
                    
                    //OverallMarks.....................
                    else if (sm_option == 3) {
                        String x = "y";
                        while(x.equals("y")){
                        System.out.println("Enter student id");
                        String id = scan.next();
                        System.out.println("Enter module code");
                        String module_code = scan.next();
                        System.out.println(get_overAllMark(id,module_code));
                        System.out.println("Do you want to find another student's GPA?(y/n): ");
                        x = scan.next();
                        }

                    } 
                    //OverallGrade.....................
                    
                    else if (sm_option == 4) {
                        String x = "y";
                        while(x.equals("y")){
                        System.out.println("Enter student id");
                        String id = scan.next();
                        System.out.println("Enter module code");
                        String module_code = scan.next();
                        System.out.println(get_overAllGrade(id,module_code));
                        System.out.println("Do you want to find another student's GPA?(y/n): ");
                        x = scan.next();
                        }
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
                            "\n1:Add assessment numbers of a student\n2:Remove assessment numbers of a student\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();
                    if (sm_option == 1) {

                        String assess_loop = "y";

                        while (true) {
                            if (assess_loop.equals("y")) {
                                System.out.print("\nEnter Student id to add assessment: ");
                                String assess_std_id = scan.next();

                                for (Iterator<Student> z = Students.iterator(); z.hasNext();) {
                                    Student Student = z.next();

                                    if (Student.getStudentID().equals(assess_std_id)) {
                                        do {
                                            // prompt data first to choose easily
                                            System.out.print(Student);
                                            System.out.print(Student.getModules());

                                            System.out.print("\nEnter Module id to add assessment: ");
                                            String assess_module_id = scan.next();
                                            for (Iterator<Module> v = Student.getModules().iterator(); v.hasNext();) {
                                                Module module = v.next();
                                                if (module.getModuleCode().equals(assess_module_id)) {

                                                    Assessment std_assess = new Assessment();
                                                    System.out.print("\nadd Assessment name: ");
                                                    String assess_name = scan.next();
                                                    std_assess.setName(assess_name);

                                                    System.out.print("add Assessment Description: ");
                                                    String assess_descript = scan.next();
                                                    std_assess.setDescription(assess_descript);

                                                    System.out.print("add Assessment marks: ");
                                                    double assess_marks = scan.nextDouble();
                                                    std_assess.setMarks(assess_marks);
                                                    module.setAssessments(std_assess);
                                                    
                                                    System.out.print("add Assessment total possible mark: ");
                                                    double assessess_totalMark = scan.nextDouble();
                                                    std_assess.setTotalMarks(assessess_totalMark);

                                                    System.out.print("add Assessment weightage: ");
                                                    double assess_weightage = scan.nextDouble();
                                                    std_assess.setWeightage(assess_weightage);

                                                    System.out.println(module);
                                                    System.out.println(module.getAssessments());
                                                    System.out.println(std_assess.getWeightageMarks());
                                                    System.out.println(module.getOverallMarks());
                                                    System.out.println(module.getOverallTotalMarks());
                                                    System.out.println(module.getOverallGrade());
                                                    Module.getGradePoints(module.getOverallGrade());
                                                    System.out.println(module.getWeightedGradePoints());
                                                    System.out.println(Student.getTotalCreditUnits());
                                                    System.out.println(Student.getGPA());

                                                    System.out.print("\nDo you want to add more Assessment(y/n): ");
                                                    assess_loop = scan.next();

                                                    break;
                                                } else if (Student.getModules()
                                                        .indexOf(module) == Student.getModules().size() - 1) {
                                                    System.out.println("Module not found!");
                                                }
                                            }
                                        } while (assess_loop.equals("y"));
                                        break;
                                    } else if (Students.indexOf(Student) == Students.size() - 1) {
                                        System.out.println("Student not found!");
                                    }

                                }
                            } else {
                                break;
                            }

                        }

                    } else if (sm_option == 2) {

                        String del_assess_loop = "y";
                        String main_del_assess_loop = "y";
                        while (main_del_assess_loop.equals("y")) {
                            if (del_assess_loop.equals("y")) {

                                System.out.print("\nEnter student id to remove Assessment; ");
                                String mod_std_id = scan.next();

                                for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
                                    Student Student = x.next();
                                    if (Student.getStudentID().equals((mod_std_id))) {

                                        while (true) {
                                            if (del_assess_loop.equals("y")) {

                                                // prompt data first to choose easily
                                                System.out.print(Student.getModules());

                                                System.out.print("\nEnter module code to remove Assessment: ");
                                                String del_module_code = scan.next();

                                                for (Iterator<Module> y = Student.getModules().iterator(); y
                                                        .hasNext();) {
                                                    Module Module = y.next();
                                                    if (del_module_code.equals(Module.getModuleCode())) {

                                                        // prompt data first to choose easily
                                                        System.out.print(Module.getAssessments());

                                                        System.out.print("\nEnter Assessment name to remove: ");
                                                        String del_assess_name = scan.next();
                                                        

                                                        for (Iterator<Assessment> w = Module.getAssessments()
                                                                .iterator(); w
                                                                        .hasNext();) {
                                                            Assessment Assessment = w.next();
                                                            if (Assessment.getName().equals(del_assess_name)) {

                                                                w.remove();
                                                                System.out.print(Module.getAssessments());

                                                                System.out.print(
                                                                        "\nDo you want to delete more assessment for this Student(y/n): ");
                                                                del_assess_loop = scan.next();
                                                                break;

                                                            } else if (Module.getAssessments()
                                                                    .indexOf(
                                                                            Assessment) == Module.getAssessments()
                                                                                    .size()
                                                                                    - 1) {
                                                                System.out.println("Assessment not found!");
                                                            }
                                                        }
                                                        break;

                                                    } else if (Student.getModules()
                                                            .indexOf(Module) == Student.getModules().size() - 1) {
                                                        System.out.println("Module not found!");
                                                    }
                                                }
                                            } else {

                                                break;
                                            }
                                        }
                                        break;
                                    } else if (Students.indexOf(Student) == Students.size() - 1) {
                                        System.out.println("Student not found!");
                                    }
                                }
                            } else {
                                break;
                            }
                        }

                    } else if (sm_option == 0) {
                        break;
                    } else {
                        System.out.println("\nInvalid Input.Please Try Again!!\n");
                    }
                }

            } 
            
            else if (main_option == 4) {
                System.out.println("\nProgram is terminated");
                System.exit(0);
            }

            else {
                System.out.println("\nInvalid Input.Please Try Again!!\n");

            }
            
        }

       
    }
    
}
