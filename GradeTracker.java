import apple.Student;
import apple.Assessment;
import apple.Module;
import java.util.*;


public class GradeTracker {
    private static ArrayList<Student> Students = new ArrayList<>();


//METHOD............................................

    //GPA................
    public static String get_GPA(String id){
        String gpa = "";
        for(Student x :Students){
                if(x.getStudentID().equals(id)){
                    gpa = ("\n"+x.getName()+" has a GPA of "+x.getGPA()+"."+"\n");
                    break;
                }else if (Students.indexOf(x) == Students.size() - 1) {
                    System.out.println("Student not found!");
                }    
        }
        return gpa;
    }

    //mark...............
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
 
    //grade..............
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
    
    //alphabet...........
    public static boolean isAlpha(String s) {
        return s != null && s.chars().allMatch(Character::isLetter);
    }

    //number.............
    public static boolean isDigit(String s) {
        return s != null && s.chars().allMatch(Character::isDigit);
    }

    //stdidcheck............
    public static boolean check_id(String id){
        boolean check = false;
        for(Student x :Students){
                if(x.getStudentID().equals(id)){
                    check = true;
                }     
        }
        return check;
    }

    //modulenamecheck............
    public static boolean check_mod_name(String name,Student student){
        boolean check = false;
        for(Module y: student.getModules()){
            if(y.getModuleName().equals(name)){
                check = true;
            }  
        }  
    
        return check;
    } 

    //modulecodecheck............
    public static boolean check_mod_code(String code,Student student){
        boolean check = false;

        for(Module x: student.getModules()){
            if(x.getModuleCode().equals(code)){
                check = true;
                } 
        }
         
        return check;
    }      

    //assessementNameCheck.......
    public static boolean check_asm_name(String name,Module module){
        boolean check = false;

        for(Assessment x: module.getAssessments()){
            if(x.getName().equals(name)){
                check = true;
                } 
  
        }
         
        return check;
    }

    //deleteStudent......
    public static void delete_student(String id){
        for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
            Student Student = x.next();
            if (Student.getStudentID().equals(id)) {
                x.remove();
                System.out.println(Students);
                break;
            } else if (Students.indexOf(Student) == Students.size() - 1) {
                System.out.println("Student not found!");
            }  
        } 
    }

    //deleteModule.............
    public static void delete_module(String del_module_code,Student module){
        for (Iterator<Module> y = module.getModules().iterator(); y.hasNext();) {
            Module single_module = y.next();
            if (del_module_code.equals(single_module.getModuleCode())) {
                y.remove();
                System.out.print(module.getModules());
                break;

            } else if (module.getModules().indexOf(single_module) == module.getModules().size() - 1) {
                System.out.println("Module not found!");
            }

        }
    }

    //main...............
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        // obj............

        Students.add(new Student("Johnny", "1"));
        Students.add(new Student("David", "2"));

        while (true) {
            try{
            System.out.print("\n1:Student Management\n2:Module Management\n3:Assessment Management\n4:End Program\nEnter Option: ");
            int main_option = scan.nextInt();
            scan.nextLine();
            
            // Students..................
            if (main_option == 1) {

                while (true) {
                    try{
                    System.out.print("\n1:Create new students\n2:Delete new students\n3:Calculate GPA\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();

                    // create new students............
                    if (sm_option == 1) {
                        Student std = new Student();

                        // name...............
                        while(true){
                            try{
                                System.out.print("\nEnter student name; ");
                                String std_name = scan.next();
                                scan.nextLine();
                                if(!(isAlpha(std_name))){
                                    throw new InputMismatchException();
                                }
                                std.setName(std_name);
                                break;

                            }catch(InputMismatchException e){
                                System.out.println("Only allow Alphabets!");
                            }
                    }

                        // id.....................
                        while(true){
                            try{
                                System.out.print("Enter student id; ");
                                String std_id = scan.next();
                                scan.nextLine();
                                if(!(isDigit(std_id))){
                                    throw new InputMismatchException();
                                }else if(check_id(std_id)){
                                    throw new IllegalArgumentException();
                                }
                                std.setStudentID(std_id);
                                break;

                            }catch(InputMismatchException e){
                                System.out.println("Only allow Numbers!");
                            }catch(IllegalArgumentException e){
                                System.out.println("Student ID is already exist!");
                            }
                        }



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

                            if(Students.isEmpty()){
                                System.out.println("\nThere is no student to delete!\n");
                                break;
                            }
                            delete_student(del_id);
                            //End_loop............................
                            System.out.print("Do u want to continue to delete(y/n): ");
                            del_std = scan.next();
                        }
                    }
                    
                    // GPA..............................
                    else if (sm_option == 3) {
                        String x = "y";
                        while(x.equals("y")){
                            System.out.println("Enter student id: ");
                            String id = scan.next();
                            System.out.println(get_GPA(id));
                            System.out.println("Do you want to find another student's GPA?(y/n): ");
                            x = scan.next();
                        }
                        
                    } 
                    
                    //End.................................
                    else if (sm_option == 0) {
                        break;
                    } 
                    
                    else {
                        System.out.println("\nInvalid Input.Please Try Again!!");
                    }
                    }catch(java.util.InputMismatchException e ){
                        System.out.println("\nPlease enter the available numbers.");
                        scan.nextLine();
                    }
                }

            }
            
            // Modules........................
            else if (main_option == 2) {

                while (true) {
                    try{
                    System.out.print("\n1:Add modules number of a student\n2:Delete modules from a student\n3:Get student mark\n4:Get student grade\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();
                    
                    // Add Module................
                    if (sm_option == 1) {
                        String module_loop = "y";
                        while (module_loop.equals("y")) {
                            System.out.print("\nEnter student id to add modules; ");
                            String mod_std_id = scan.next();

                            if(Students.isEmpty()){
                                System.out.println("\nThere is no student to add module.Please add students first!");
                                break;
                            }

                            for (Student x: Students) {
                                if (x.getStudentID().equals((mod_std_id))) {
                                    Module std_module = new Module();
                                    

                                    //Name....................
                                    while(true){
                                        try{
                                            System.out.print("add module name: ");
                                            String module_name = scan.next();
                                            if(check_mod_name(module_name,x)){
                                                throw new IllegalArgumentException();
                                            }
                                            std_module.setModuleName(module_name);
                                            break;
                                        }
                                        catch (IllegalArgumentException e ){
                                            System.out.println("\nModule name is already exist!\n");
                                        
                                        }

                                    }

                                    //Code....................
                                    while(true){
                                        try{
                                            System.out.print("add module code: ");
                                            String module_code = scan.next();
                                            if(check_mod_code(module_code,x)){
                                                throw new IllegalArgumentException();
                                            }
                                            std_module.setModuleCode(module_code);
                                            break;
                                        }catch(IllegalArgumentException e){
                                            System.out.println("\nModule id is already exist!\n");
                                            
                                        }
                                    }


                                    //Desc....................
                                    System.out.print("add module description: ");
                                    String module_description = scan.next();
                                    std_module.setDescription(module_description);                           



                                    //creditUnit..................
                                    while(true){
                                        try{
                                        System.out.print("add creditUnits: ");
                                        int creditUnits = scan.nextInt();
                                        std_module.setCreditUnits(creditUnits);
                                        break;
                                        }catch(InputMismatchException e){
                                            System.out.println("\nPlease enter a number.\n");
                                            scan.nextLine();
                                        }
                                    }

                                    
                                    x.setModules(std_module);
                                    System.out.print(x);
                                    System.out.print(x.getModules());



                                    System.out.print("\nDo you want to add more module(y/n): ");
                                    module_loop = scan.next();
                                    break;
                                } else if (Students.indexOf(x) == Students.size() - 1) {
                                    System.out.println("Student not found!");
                                }

                            }
                        }
                    }

                    // Delete Modules....................
                    else if (sm_option == 2) {
                        String del_module_loop = "y";

                        while (del_module_loop.equals("y") ){
                                System.out.print("\nEnter student id to remove modules; ");
                                String mod_std_id = scan.next();

                                if(Students.isEmpty()){
                                    System.out.println("\nThere is no student to delete module.Please add students first!");
                                    break;
                                }
                                for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
                                    Student student = x.next();

                                    if (student.getStudentID().equals((mod_std_id))) {

                                        if(student.getModules().isEmpty()){
                                            System.out.println("\nModule is empty!");
                                            del_module_loop = "n";
                                            break;
                                        }

                                        System.out.print(student.getModules());
                                        
                                        System.out.print("\nEnter module code to remove: ");
                                        String del_module_code = scan.next();

                                        delete_module(del_module_code, student);
                                        System.out.println("\nModule deleted successfully.");

                                        System.out.print("Do u want to continue to delete(y/n): ");
                                        del_module_loop = scan.next();
                                        break;
                                    } else if (Students.indexOf(student) == Students.size() - 1) {
                                        System.out.println("Student not found!");
                                    }

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
                    } 
                    
                    //End.............................
                    else if (sm_option == 0) {
                        break;
                    } 
                    
                    else {
                        System.out.println("\nPlease enter the available numbers.");
                    }
                }catch(java.util.InputMismatchException e){
                    System.out.println("\nPlease enter the available numbers.");
                    scan.nextLine();
                }
            }

            }

            // Assessment.....................        
            else if (main_option == 3) {

                while (true) {
                    try {
                        
                    System.out.print(
                            "\n1:Add assessment numbers of a student\n2:Remove assessment numbers of a student\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();

                    //Add Assessment.................
                    if (sm_option == 1) {

                        String assess_loop = "y";
                        while (assess_loop.equals("y")) {
        
                                System.out.print("\nEnter Student id to add assessment: ");
                                String assess_std_id = scan.next();

                                if(Students.isEmpty()){
                                    System.out.println("\nThere is no student to delete!\n");
                                    break;
                                }

                                for (Iterator<Student> z = Students.iterator(); z.hasNext();) {
                                    Student student = z.next();

                                    
                                    
                                    if (student.getStudentID().equals(assess_std_id)) {
                                            
                                        // prompt data first to choose easily
                                        System.out.println(student);
                                        System.out.println(student.getModules());

                                        if(student.getModules().isEmpty()){
                                            System.out.println("\nModule is empty!");
                                            assess_loop = "n";
                                            break;
                                        }

                                        System.out.print("\nEnter Module id to add assessment: ");
                                        String assess_module_id = scan.next();

                                        

                                        for (Iterator<Module> v = student.getModules().iterator(); v.hasNext();) {
                                            Module module = v.next();
                                            
                                            if (module.getModuleCode().equals(assess_module_id)) {
                                                Assessment std_assess = new Assessment();

                                                //name..............................
                                                while(true){

                                                    try{
                                                        System.out.print("\nadd Assessment name: ");
                                                        String assess_name = scan.next();
                                                        if(check_asm_name(assess_name,module)){
                                                            throw new InputMismatchException();
                                                        }
                                                        std_assess.setName(assess_name);
                                                        break;
                                                    }catch(InputMismatchException e){
                                                        System.out.println("Assessement already exist.");
                                                    }
                                                }

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
                                                    System.out.println(student.getTotalCreditUnits());
                                                    System.out.println(student.getGPA());

                                                    System.out.print("\nDo you want to add more Assessment(y/n): ");
                                                    assess_loop = scan.next();

                                                    break;
                                                } 
  
                                            else if (student.getModules().indexOf(module) == student.getModules().size() - 1) {
                                                System.out.println("Module not found!");
                                            }
                                        }
                                        break;
                                    }
                                
                                    
                                    else if (Students.indexOf(student) == Students.size() - 1) {
                                        System.out.println("Module not found!");
                                    }

                                    

                                }


                        }

                    } 
                  
                    //Delete Assessment..............
                    else if (sm_option == 2) {

                        String del_assess_loop = "y";
                        while (del_assess_loop.equals("y")) {
                                System.out.print("\nEnter student id to remove Assessment; ");
                                String mod_std_id = scan.next();

                                if(Students.isEmpty()){
                                    System.out.println("\nThere is no student to delete!\n");
                                    break;
                                }

                                for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
                                    Student student = x.next();
                                    

                                    if (student.getStudentID().equals((mod_std_id))) {

                                                // prompt data first to choose easily
                                        System.out.println(student.getModules());

                                        if(student.getModules().isEmpty()){
                                            System.out.println("\nModule is empty!");
                                            del_assess_loop = "n";
                                            break;
                                        }

                                        System.out.print("\nEnter module code to remove Assessment: ");
                                        String del_module_code = scan.next();

                                        for (Iterator<Module> y = student.getModules().iterator(); y.hasNext();){
                                            Module module = y.next();
                                            
                                            
                                            if (del_module_code.equals(module.getModuleCode())) {

                                                        // prompt data first to choose easily
                                                System.out.println(module.getAssessments());

                                                if(module.getAssessments().isEmpty()){
                                                    System.out.println("\nAssessment is empty!");
                                                    del_assess_loop = "n";
                                                    break;
                                                }

                                                System.out.print("\nEnter Assessment name to remove: ");
                                                String del_assess_name = scan.next();
                                                        

                                                for (Iterator<Assessment> w = module.getAssessments().iterator(); w.hasNext();) {
                                                    Assessment Assessment = w.next();
                                                    if (Assessment.getName().equals(del_assess_name)) {
                                                        w.remove();
                                                        System.out.print(module.getAssessments());

                                                        System.out.println("\nDo you want to delete more assessment for this Student(y/n): ");
                                                        del_assess_loop = scan.next();
                                                        break;

                                                    } 
                                                    
                                                    else if (module.getAssessments().indexOf(Assessment) == module.getAssessments().size()- 1) {
                                                                System.out.println("Assessment not found!");
                                                            }
                                                        }

                                            } 
                                            
                                            else if (student.getModules().indexOf(module) == student.getModules().size() - 1) {
                                                System.out.println("Module not found!");
                                            }
                                        }
                                        break;      
                                       
                                    } 
                                    
                                    else if (Students.indexOf(student) == Students.size() - 1) {
                                        System.out.println("Student not found!");
                                    }
                                }
                        }

                    } 
                    
                    //End...........................
                    else if (sm_option == 0) {
                        break;
                    }
                    
                    else {
                        System.out.println("\nPlease enter the available numbers.");
                    }
                }catch(java.util.InputMismatchException e){
                    System.out.println("\nPlease enter the available numbers.");
                    scan.nextLine();
                }
            }

            } 
            
            //End............................
            else if (main_option == 4) {
                System.out.println("\nProgram ended successfully!");
                scan.close();
                System.exit(0);
            }

            else {
                System.out.println("\nPlease enter the available numbers.");

            }
        }
        
        catch (java.util.InputMismatchException e){
            System.out.println("\nPlease enter the available numbers.");
            scan.nextLine();
        }
        }

       
    }
    
}
