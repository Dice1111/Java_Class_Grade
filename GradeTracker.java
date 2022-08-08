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
                    gpa = ("\nStudent Name: "+x.getName()+"\nStudent ID  : "+x.getStudentID()+"\nStudent GPA : "+x.getGPA()+"\n");
                    break;
                }else if (Students.indexOf(x) == Students.size() - 1) {
                    
                    System.out.println("Student not found!");
                }    
        }
        return gpa;
    }

    //mark...............
    public static String get_overAllMark(String id,String moduleCode){
        String overallmark = "";
        for(Student x :Students){
                if(x.getStudentID().equals(id)){
                    if(x.getModules().isEmpty()){
                        System.out.println("Module is Empty.");
                        break;
                    }
                    for(Module y : x.getModules()){
                        if(y.getModuleCode().equals(moduleCode)){
                            overallmark = ("\nStudent Name: "+x.getName()+"\nStudent ID  : "+x.getStudentID()+"\nStudent Overall Mark : "+y.getOverallMarks()+"\n");
                            markTable(x);
                            break;

                        }else if (x.getModules().indexOf(y) == x.getModules().size() - 1) {
                            System.out.println("Module not found!");
                        }
                    }
                    break;
                }else if (Students.indexOf(x) == Students.size() - 1) {
                    System.out.println("Student not found!");
                }  
            } 
            return overallmark;    
        }
 
    //grade..............
    public static String get_overAllGrade(String id,String moduleCode){
        String overallmark = "";
        for(Student x :Students){
                    if(x.getStudentID().equals(id)){
                        if(x.getModules().isEmpty()){
                            System.out.println("Module is Empty.");
                            break;
                        }
                        for(Module y : x.getModules()){
                            if(y.getModuleCode().equals(moduleCode)){
                                overallmark = ("\nStudent Name: "+x.getName()+"\nStudent ID  : "+x.getStudentID()+"\nStudent Overall Mark : "+y.getOverallGrade()+"\n");
                                markTable(x);
                                break;
                            }else if (x.getModules().indexOf(y) == x.getModules().size() - 1) {
                                System.out.println("Module not found!");
                            }
                        }
                        break;
                    }else if (Students.indexOf(x) == Students.size() - 1) {
                        System.out.println("Student not found!");
                    }  
                } 
            return overallmark;    
    }
    
    //alphabet...........
    public static boolean isAlpha(String s) {
        // return s != null && s.chars().allMatch(Character::isLetter) ;
        boolean check = false;
        for(int i =0;i<s.length();i++){
            if(s!=null && (Character.isWhitespace(s.charAt(i)) || Character.isLetter(s.charAt(i)))){
                check = true;
            }
        }
        return check;
    }
    //alphabetAndDigit...........
    public static boolean isAlphaDigit(String s) {
        // return s != null && s.chars().allMatch(Character::isLetter) ;
        boolean check = false;
        for(int i =0;i<s.length();i++){
            if(s!=null && (Character.isWhitespace(s.charAt(i)) || Character.isLetterOrDigit(s.charAt(i)))){
                check = true;
            }
        }
        return check;
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
                System.out.println("\nDelete successful.");
                studentTable();
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
                System.out.println("\nModule deleted successfully.");
                moduleTable(module);
                // System.out.print(module.getModules());
                break;

            } else if (module.getModules().indexOf(single_module) == module.getModules().size() - 1) {
                System.out.println("Module not found!");
            }

        }
    }

    //studentTable.............
    public static void studentTable(){
        String leftAlignFormat = "| %-15s | %-15s |%n";
        System.out.println("\nAll Students");
        System.out.format("+-----------------+-----------------+%n");
        System.out.format("| Student Name    | ID              |%n");
        System.out.format("+-----------------+-----------------+%n");
        for (Student x:Students) {
            System.out.format(leftAlignFormat, x.getName(),x.getStudentID());
        }
        System.out.format("+-----------------+-----------------+%n\n");

    }

    //studentGPATable.............
    public static void GPA_Table(){
        String leftAlignFormat = "| %-15s | %-15s | %-15.1f |%n";
        System.out.println("\nAll Students GPA");
        System.out.format("+-----------------+-----------------+-----------------+%n");
        System.out.format("| Student Name    | Student ID      | GPA             |%n");
        System.out.format("+-----------------+-----------------+-----------------+%n");
        for (Student x:Students) {
            System.out.format(leftAlignFormat, x.getName(),x.getStudentID(),x.getGPA());
        }
        System.out.format("+-----------------+-----------------+-----------------+%n\n");

    }

    //moduleTable..............
    public static void moduleTable(Student student){
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15d |%n";
        System.out.println("\n"+student.getName()+"("+student.getStudentID()+")"+"'s Modules");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| Module Name     | Module Code     | Description     | Credit Unit     |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");
        for (Module x:student.getModules()) {
            System.out.format(leftAlignFormat,x.getModuleName(),x.getModuleCode(),x.getDescription(),x.getCreditUnits());
        }
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n\n");

    }

    //markTable..............
    public static void markTable(Student student){
        String leftAlignFormat = "| %-15s | %-15s | %-15.1f | %-15s |%n";
        System.out.println("\n"+student.getName()+"("+student.getStudentID()+")"+"'s Modules");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| Module Name     | Module Code     | Overall Mark    | Grade           |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");
        for (Module x:student.getModules()) {
            System.out.format(leftAlignFormat,x.getModuleName(),x.getModuleCode(),x.getOverallMarks(),x.getOverallGrade());
        }
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n\n");

    }
        
    //markTable..............
    public static void asmTable(Student student,Module module){
        String leftAlignFormat = "| %-15s | %-15s | %-15.1f | %-15.1f | %-15.1f |%n";
        System.out.println("\n"+student.getName()+"("+student.getStudentID()+")"+"=> "+module.getModuleName());
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| Assesment Name  | Description     | Mark            | Total Mark      | Weightage Mark  |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        for (Assessment x:module.getAssessments()) {
            System.out.format(leftAlignFormat,x.getName(),x.getDescription(),x.getMarks(),x.getTotalMarks(),x.getWeightageMarks());
        }
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+%n\n");

    }   

    //main...............
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        // obj............

        Students.add(new Student("JOHNNY", "1"));
        Students.add(new Student("DAVID", "2"));

        while (true) {
            try{
            System.out.println("\nMAIN MENU");
            System.out.print("1:Student Management\n2:Module Management\n3:Assessment Management\n4:End Program\n\nEnter Option: ");
            int main_option = scan.nextInt();
            scan.nextLine();
            
            
            // Students..................
            if (main_option == 1) {
                while (true) {
                    try{
                        System.out.println("\nSTUDENT MANAGEMENT");
                        System.out.print("1:Create new student\n2:Delete student\n3:Calculate GPA\n0:Go back to Main Menu\n\nEnter Option: ");
                        int sm_option = scan.nextInt();
                        scan.nextLine();

                    // create new students............
                    if (sm_option == 1) {
                        System.out.println("\nCreating student profile... ");
                        Student std = new Student();
                
                
                        studentTable();
                        
                        
                        // name...............
                        while(true){
                            
                            try{
                                System.out.print("Enter student name: ");
                                String std_name = scan.nextLine();
                                std_name = std_name.toUpperCase().trim();
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
                                System.out.print("Enter student id  : ");
                                String std_id = scan.next();
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
                        System.out.println("\nNew student is created successfully.\nName: "
                                + Students.get(Students.indexOf(std)).getName() + "\nid  : "
                                + Students.get(Students.indexOf(std)).getStudentID());
                        // System.out.println(Students);

                        studentTable();
                    }

                    // delete students..............
                    else if (sm_option == 2) {
                        System.out.println("\nCollecting data to delete...");
                        studentTable();
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
                            System.out.print("\nDo u want sill want to delete(y/n): ");
                            del_std = scan.next();
                        }
                    }
                    
                    // GPA..............................
                    else if (sm_option == 3) {
                        System.out.println("\nCalculating GPA...");
                        String x = "y";
                        while(x.equals("y")){
                            System.out.print("Enter student id: ");
                            String id = scan.next();
                            if(Students.isEmpty()){
                                System.out.println("There is no student.");
                                break;
                            }
                            System.out.println(get_GPA(id));
                            GPA_Table();
                            System.out.println("Do you want to find another student's GPA?(y/n): ");
                            x = scan.next();
                        }
                        
                    } 
                    
                    //End.................................
                    else if (sm_option == 0) {
                        break;
                    } 
                    
                    else {
                        System.out.println("\nPlease enter the available options.");
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
                    System.out.println("\nMODULE MANAGEMENT");
                    System.out.print("1:Add modules to a student\n2:Delete modules from a student\n3:Get the overall mark from a student\n4:Get grade from a student\n0:Go back to Main Menu\n\nEnter Option: ");
                    int sm_option = scan.nextInt();
                    scan.nextLine();
                    
                    // Add Module................
                    if (sm_option == 1) {
                        System.out.println("\nAdding module...");
                        studentTable();
                        String module_loop = "y";
                        while (module_loop.equals("y")) {
                            System.out.print("Enter student id to add modules: ");
                            String mod_std_id = scan.next();
                            scan.nextLine();

                            if(Students.isEmpty()){
                                System.out.println("There is no student to add module.Please add students first!");
                                break;
                            }

                            for (Student x: Students) {
                                if (x.getStudentID().equals((mod_std_id))) {
                                    Module std_module = new Module();
                                    //Name....................
                                    while(true){
                                        try{
                                            System.out.print("add module name: ");
                                            String module_name = scan.nextLine();
                                            module_name = module_name.toUpperCase().trim();
                                            if(!isAlphaDigit(module_name)){
                                                throw new InputMismatchException();
                                            }
                                            else if(check_mod_name(module_name,x)){
                                                throw new IllegalArgumentException();
                                            }
                                            std_module.setModuleName(module_name);
                                            break;
                                        }
                                        catch (IllegalArgumentException e ){
                                            System.out.println("\nModule name is already exist!\n");
                                        
                                        }catch (InputMismatchException e){
                                            System.out.println("Enter Alphabets and Number Only!");
                                        }

                                    }

                                    //Code....................
                                    while(true){
                                        try{
                                            System.out.print("add module code: ");
                                            String module_code = scan.next();
                                            scan.nextLine();
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
                                    String module_description = scan.nextLine();
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

                                    System.out.println("\nA New Module name \""+x.getModules().get(x.getModules().indexOf(std_module)).getModuleName()+"\" is added into \""+x.getName()+"("+x.getStudentID()+")"+"\".");
                                    // System.out.println(x);
                                    // System.out.println(x.getModules());

                                    moduleTable(x);

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

                        System.out.println("\nDeleting module...");
                        String del_module_loop = "y";
                        studentTable();
                        while (del_module_loop.equals("y") ){
                                System.out.print("Enter student id to remove modules: ");
                                String mod_std_id = scan.next();

                                if(Students.isEmpty()){
                                    System.out.println("There is no student to delete module.Please add students first!");
                                    break;
                                }
                                for (Iterator<Student> x = Students.iterator(); x.hasNext();) {
                                    Student student = x.next();

                                    if (student.getStudentID().equals((mod_std_id))) {

                                        if(student.getModules().isEmpty()){
                                            System.out.println("Module is empty!");
                                            del_module_loop = "n";
                                            break;
                                        }

                                        // System.out.print(student.getModules());
                                        moduleTable(student);


                                        System.out.print("Enter module code to remove: ");
                                        String del_module_code = scan.next();
                                        delete_module(del_module_code, student);

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
                        System.out.println("\nCalculating overall mark...");
                        String x = "y";
                        while(x.equals("y")){
                        System.out.print("Enter student id : ");
                        String id = scan.next();
                        System.out.print("Enter module code: ");
                        String module_code = scan.next();
                        System.out.println(get_overAllMark(id,module_code));
                        System.out.print("Do you want to find another student's overall mark?(y/n): ");
                        x = scan.next();
                        }

                    } 
                    
                    //OverallGrade.....................
                    else if (sm_option == 4) {
                        System.out.println("\nCalculating overall grade...");
                        String x = "y";
                        while(x.equals("y")){
                        System.out.print("Enter student id: ");
                        String id = scan.next();
                        System.out.print("Enter module code: ");
                        String module_code = scan.next();
                        System.out.println(get_overAllGrade(id,module_code));
                        System.out.print("Do you want to find another student's overall grade?(y/n): ");
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
                    System.out.println("\nMANAGE ASSESSMENT");   
                    System.out.print(
                            "1:Add assessment numbers of a student\n2:Remove assessment numbers of a student\n0:Go Main Menu\nEnter Option: ");
                    int sm_option = scan.nextInt();

                    //Add Assessment.................
                    if (sm_option == 1) {
                        System.out.println("\nAdding assessment...");

                        studentTable();

                        String assess_loop = "y";
                        while (assess_loop.equals("y")) {
        
                                System.out.print("Enter Student id to add assessment: ");
                                String assess_std_id = scan.next();
                                assess_std_id = assess_std_id.toUpperCase().trim();

                                if(Students.isEmpty()){
                                    System.out.println("There is no student to delete!\n");
                                    break;
                                }

                                for (Iterator<Student> z = Students.iterator(); z.hasNext();) {
                                    Student student = z.next();

                                    
                                    
                                    if (student.getStudentID().equals(assess_std_id)) {
                                            
                                        // prompt data first to choose easily
                                        // System.out.println(student);
                                        // System.out.println(student.getModules());

                                        if(student.getModules().isEmpty()){
                                            System.out.println("Module is empty!");
                                            assess_loop = "n";
                                            break;
                                        }
                                        moduleTable(student);

                                        System.out.print("Enter Module id to add assessment: ");
                                        String assess_module_id = scan.next();

                                        

                                        for (Iterator<Module> v = student.getModules().iterator(); v.hasNext();) {
                                            Module module = v.next();
                                            
                                            if (module.getModuleCode().equals(assess_module_id)) {
                                                Assessment std_assess = new Assessment();

                                                //name..............................
                                                while(true){

                                                    try{
                                                        System.out.print("add Assessment name: ");
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

                                                    System.out.println("Assessment created successfully!");
                                                    asmTable(student, module);
                                                    
                                                    // Module.getGradePoints(module.getOverallGrade());

                                                    System.out.println(module);
                                                    System.out.println(module.getAssessments());
                                                    System.out.println(std_assess.getWeightageMarks());
                                                    System.out.println(module.getOverallMarks());
                                                    System.out.println(module.getOverallTotalMarks());
                                                    System.out.println(module.getOverallGrade());


                                                    //System.out.println(Module.getGradePoints(module.getOverallGrade()));
                                                    System.out.println(module.getWeightedGradePoints());
                                                    System.out.println(student.getTotalCreditUnits());
                                                    System.out.println(student.getGPA());

                                                    System.out.print("Do you want to add more Assessment(y/n): ");
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
                                        System.out.println("Student not found!");
                                    }

                                    

                                }


                        }

                    } 
                  
                    //Delete Assessment..............
                    else if (sm_option == 2) {
                        System.out.println("\nDeleting assessment...");
                        String del_assess_loop = "y";

                        studentTable();
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

                                        moduleTable(student);

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

                                                asmTable(student, module);

                                                System.out.print("\nEnter Assessment name to remove: ");
                                                String del_assess_name = scan.next();
                                                        

                                                for (Iterator<Assessment> w = module.getAssessments().iterator(); w.hasNext();) {
                                                    Assessment Assessment = w.next();
                                                    if (Assessment.getName().equals(del_assess_name)) {
                                                        w.remove();
                                                        System.out.println("Assessment deleted successfully.");
                                                        asmTable(student, module);
                                                        // System.out.print(module.getAssessments());

                                                        System.out.println("\nDo you want to delete more assessment for this student(y/n): ");
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
                System.out.println("\nPlease enter the available options.");

            }
        }
        
        catch (java.util.InputMismatchException e){
            System.out.println("\nPlease enter the available numbers.");
            scan.nextLine();
        }
        }

       
    }
    
}
