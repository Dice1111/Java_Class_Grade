package apple;

import java.util.*;

public class Assessment {
    private String name;
    private String description;
    private Module module;
    private double marks;
    private double totalMarks;
    private double weightage;

    //constructor

    
    public Assessment(){

    }

    public Assessment(String name,String description,double marks,double totalMarks,double weightage){
        this.name = name;
        this.description = description;
        this.marks = marks;
        this.totalMarks = totalMarks;
        this.weightage = weightage;
    }
    //get...................
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getMarks() {
        return this.marks;
    }
    public double getTotalMarks() {
        return this.totalMarks;
    }
    public double getWeightage() {
        return this.weightage;
    }

    //set......................
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }


    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public void setWeightage(double weightage) {
        this.weightage = weightage;
    }

    public double getWeightedMarks(){
        return this.marks*this.weightage/this.totalMarks;
    }


    @Override
    public String toString() {
        return "{" +
                "name=\"" + name + "\"" + "," +
                "description=\"" + description + "\"" +"," +
                "marks=\"" + marks + "\"" +"," +
                "totalMarks=\"" + totalMarks + "\"" +"," +
                "weightage=\"" + weightage + "\""+
                "}";
    }

}
