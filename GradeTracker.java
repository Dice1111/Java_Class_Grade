import apple.*;
import java.util.*;

public class GradeTracker {
    private static ArrayList<Student> Students = new ArrayList<Student>();
    private static ArrayList<String> Students_ID = new ArrayList<String>();
    private static ArrayList<ArrayList<String>> Modules = new ArrayList<ArrayList<String>>();

    

    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);

        //obj............

        // Student std = new Student();

        
        Students.add(new Student("MGMG","1"));
        Students.add(new Student("AUNGAUNG","2"));
        
        // Students.add(std);
        // std.setID("1");
        // Students_ID.add("2");




        while(true){
        System.out.println("1:Student Management;\n2:Module Management;\n3:Assessment Management;");
        int main_option = scan.nextInt();

        //Students..................
        // if (main_option == 1){
            
        //     System.out.println("1:Create new students;\n2:Delete new students;\n3:Calculate GPA;");
        //     while(true){
        //         int sm_option = scan.nextInt();
        //         //create new students............
        //         if(sm_option == 1){
        //             //name...............
        //             System.out.print("Enter student name; ");
        //             String std_name =scan.next();
        //             std.setName(std_name);
        //             Students.add(std.getName());
        //             System.out.println(std.getName());

        //             //id.....................
        //             System.out.print("Enter student id; ");
        //             String std_id =scan.next();
        //             std.setStudentID(std_id);
        //             System.out.println(std.getStudentID());
        //             Students_ID.add(std.getStudentID());

        //             System.out.println("New student is created successfully:\nName: "+Students.get(Students.indexOf(std.getName()))+"\nid: "+Students_ID.get(Students_ID.indexOf(std.getStudentID())));

        //             break;

                    
        //         }
                
        //         //delete new students..............
        //         else if(sm_option == 2){
        //             System.out.println("Enter the student to delete: ");
        //             String del_name = scan.next();
        //             int del_index =Students.indexOf(del_name);
        //             Students.remove(del_index);
        //             Students_ID.remove(del_index);

        //             System.out.println(Students);

        //             break;
                    



        //         }
        //         //GPA....................
        //         else if (sm_option == 3){
        //             System.out.println("mango");
        //         }else{
        //             System.out.println("Hello");
        //         }
                
        //     }

        // }
        //Modules........................

        // else if(main_option == 2){
        //     System.out.println("1:Add modules number of a student;\n2:Delete modules from a student;\n3:get student mark;\n4:get student grade;");
        //     int sm_option = scan.nextInt();
        //     while(true){
        //         //Add Module................
        //         if(sm_option == 1){
        //             while(true){
        //             System.out.print("Enter student id to add modules; ");
        //             String mod_std_id=scan.next();
            
        //             if(Students_ID.contains(mod_std_id)){
        //                 while(true){
        //                     System.out.print("add module name:Enter stop to stop;  ");
        //                     String module_name=scan.next();


        //                     if(module_name.equals("stop")){
        //                         break;
        //                     }

        //                     System.out.print("add module code: ");
        //                     String moduleCode_id=scan.next();
                            
        //                     std.setModules(module_name);
        //                     std.setModuleCodes(moduleCode_id);
        //                     System.out.println(std.getModules());
        //                     System.out.println(std.getModuleCodes());
        //                 }

        //             }else{
        //                 System.out.print("No student!");
        //                 }
                    
                    
        //         }



        //         }
                
        //         //Delete Modules....................
                
        //         else if(sm_option == 2){



                    
        //             System.out.println("banana");
        //         }else if (sm_option == 3){
        //             System.out.println("mango");
        //         }else if (sm_option == 4){
        //             System.out.println("pineapple");
        //         }else{
        //             System.out.println("Hello");
        //         }    
        //     }

        // }
       
        //Assessment.....................
        if (main_option == 3){
            System.out.println("1:Add assessment numbers of a student;\n2:Remove assessment numbers of a student;");
            while(true){
                int sm_option = scan.nextInt();
                if(sm_option == 1){
                    System.out.println((Students.get(1)).getName());
                }else if(sm_option == 2){
                    System.out.println("banana");
                }else{
                    System.out.println("Hello");
                }    
            }
        }else{
            System.out.println("Hello");
        }

    }
}
}
