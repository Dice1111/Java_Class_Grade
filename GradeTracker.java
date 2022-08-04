import apple.Student;
import apple.Module;
import java.util.*;

public class GradeTracker {
    private static ArrayList<Student> Students = new ArrayList<>();

    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);

        //obj............
        
        
        
        Students.add(new Student("MGMG","1"));
        Students.add(new Student("AUNGAUNG","2"));
        
        // Students.add(std);
        // std.setID("1");
        // Students_ID.add("2");




        while(true){
        System.out.println("1:Student Management;\n2:Module Management;\n3:Assessment Management;");
        int main_option = scan.nextInt();

        //Students..................
        if (main_option == 1){
            
            System.out.println("1:Create new students;\n2:Delete new students;\n3:Calculate GPA;");
            while(true){
                int sm_option = scan.nextInt();
                //create new students............
                if(sm_option == 1){
                    Student std = new Student();
                    //name...............
                    System.out.print("Enter student name; ");
                    String std_name =scan.next();
                    std.setName(std_name);


                    //id.....................
                    System.out.print("Enter student id; ");
                    String std_id =scan.next();
                    std.setStudentID(std_id);

                    Students.add(std);
                    System.out.println("New student is created successfully:\nName: "+Students.get(Students.indexOf(std)).getName()+"\nid: "+Students.get(Students.indexOf(std)).getStudentID());
                    System.out.println(Students);
                    // for(Student x:Students){
                    //     if(x.getName() == std_name){
                    //         int index = Students.indexOf(x);
                    //         System.out.println("New student is created successfully:\nName: "+Students.get(index).getName()+"\nid: "+Students.get(index).getStudentID());
                    //     }
                    // }

                    break;

                    
                }
                
                //delete new students..............
                else if(sm_option == 2){
                    System.out.println("Enter the student id to delete: ");
                    String del_id = scan.next();
                    for(Iterator<Student> x = Students.iterator(); x.hasNext();){
                        Student Student = x.next();
                        if(Student.getStudentID().equals(del_id)){
                            x.remove();   
                        }
                    }
                    System.out.println(Students);


                    break;
                }
                //GPA....................
                else if (sm_option == 3){
                    System.out.println("mango");
                }else{
                    System.out.println("Hello");
                }
                
            }

        }
        //Modules........................

        else if(main_option == 2){
            System.out.println("1:Add modules number of a student;\n2:Delete modules from a student;\n3:get student mark;\n4:get student grade;");
            int sm_option = scan.nextInt();
            while(true){
                //Add Module................
                if(sm_option == 1){
                    while(true){
                    System.out.print("Enter student id to add modules; ");
                    String mod_std_id=scan.next();

                    for(Iterator<Student> x = Students.iterator(); x.hasNext();){
                        Student Student = x.next();
                        if(Student.getStudentID().equals((mod_std_id))){
                            Module std_module = new Module();

                            System.out.print("add module name: ");
                            String module_name=scan.next();
                            std_module.setModuleName(module_name);

                            System.out.print("add module code: ");
                            String module_code=scan.next();
                            std_module.setModuleCode(module_code);

                            System.out.print("add module description: ");
                            String module_description=scan.next();
                            std_module.setDescription(module_description);

                            Student.setModules(std_module);
                            System.out.print(Student);
                            System.out.print(Student.getModules());
                        }
                    }
            
                    // if(Students.contains(mod_std_id)){
                    //     while(true){
                    //         System.out.print("add module name:Enter stop to stop;  ");
                    //         String module_name=scan.next();


                    //         if(module_name.equals("stop")){
                    //             break;
                    //         }

                    //         System.out.print("add module code: ");
                    //         String moduleCode_id=scan.next();
                            
                    //         // std.setModules(module_name);
                    //         // std.setModuleCodes(moduleCode_id);
                    //         // System.out.println(std.getModules());
                    //         // System.out.println(std.getModuleCodes());
                    //     }

                    // }else{
                    //     System.out.print("No student!");
                    //     }
                    
                    
                }



                }
                
                //Delete Modules....................
                
                else if(sm_option == 2){



                    
                    System.out.println("banana");
                }else if (sm_option == 3){
                    System.out.println("mango");
                }else if (sm_option == 4){
                    System.out.println("pineapple");
                }else{
                    System.out.println("Hello");
                }    
            }

        }
       
        //Assessment.....................
        if (main_option == 3){
            System.out.println("1:Add assessment numbers of a student;\n2:Remove assessment numbers of a student;");
            while(true){
                int sm_option = scan.nextInt();
                if(sm_option == 1){
                    System.out.println(Students);
                }else if(sm_option == 2){
                    System.out.println("banana");
                }else{
                    System.out.println("Hello");
                }    
            }
        }else{
            
        }

    }
}
}
