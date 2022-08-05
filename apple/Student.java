package apple;

import java.util.*;

public class Student {
    private String name;
    private String studentID;
    private ArrayList<Module> modules = new ArrayList<Module>();

    public Student() {

    }

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    // get............
    public String getName() {
        return this.name;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }
    // public ArrayList<String> getModuleCodes(){
    // return this.module_codes;
    // }

    // set..........
    public void setName(String name) {
        this.name = name;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setModules(Module modules) {
        this.modules.add(modules);
    }

    // public void setModuleCodes(String moduleCode_id){
    // this.module_codes.add(moduleCode_id);
    // }

    @Override
    public String toString() {
        return "{" +
                "name=\"" + name + "\"" + "," +
                "id=\"" + studentID + "\"" +
                "}";
    }
}
