package apple;

import java.util.*;

public class Student {
    private String name;
    private String studentID;
    private double WGP;
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

    //function.....................

    public int getTotalCreditUnits(){
        Iterator<Module> a = modules.iterator();
        int totalCreditUnit = 0;
        while ( a.hasNext()) {
            Module module_creditUnit = a.next();
            totalCreditUnit += module_creditUnit.getCreditUnits();
            // System.out.println(totalCreditUnit);
        }
        return  totalCreditUnit;
    }

    public double getGPA(){
        Iterator<Module> a = modules.iterator();
        double WGP = 0;
        while ( a.hasNext()) {
            Module module_GPA = a.next();
            WGP += module_GPA.getWeightedGradePoints();
            // System.out.println(WGP);
            // System.out.println(this.getTotalCreditUnits());
        }
        return  WGP/this.getTotalCreditUnits();
    }
    



    @Override
    public String toString() {
        return "{" +
                "name=\"" + name + "\"" + "," +
                "id=\"" + studentID + "\"" +
                "}";
    }
}
