package apple;

import java.util.*;

public class Module {
    private String name;
    private String moduleCode;
    private String description;
    private int creditUnits =0;
    // private static double gradePoint;
    private String overallGrade = "Failure";
    private ArrayList<Assessment> assessments = new ArrayList<Assessment>();

    public Module() {

    }

    public Module(String name, String moduleCode, String description, int creditUnits) {
        this.name = name;
        this.moduleCode = moduleCode;
        this.description = description;
        this.creditUnits = creditUnits;

    }

    // GET
    public String getModuleName() {
        return this.name;
    }

    public String getModuleCode() {
        return this.moduleCode;
    }

    public String getDescription() {
        return this.description;
    }

    public int getCreditUnits() {
        return this.creditUnits;
    }

    public ArrayList<Assessment> getAssessments() {
        return this.assessments;
    }

    // SET
    public void setModuleName(String name) {
        this.name = name;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreditUnits(int creditUnits) {
        this.creditUnits = creditUnits;
    }

    public void setAssessments(Assessment assessments) {
        this.assessments.add(assessments);
    }

    //function..........
    public double getOverallMarks(){
        Iterator<Assessment> a = assessments.iterator();
        double overallMarks = 0;
        while ( a.hasNext()) {
            Assessment assessment = a.next();
            overallMarks += assessment.getWeightageMarks();
        }

        return overallMarks;
        
            
    }

    public double getOverallTotalMarks(){
        Iterator<Assessment> a = assessments.iterator();
        double overallTotalMarks = 0;
        while ( a.hasNext()) {
            Assessment assessment = a.next();
            overallTotalMarks += assessment.getTotalMarks();
        }

        return overallTotalMarks;       
    }

    public String getOverallGrade(){
        Iterator<Assessment> a = assessments.iterator();
        double grade_mark = 0;
        
        while ( a.hasNext()) {
            Assessment assessment = a.next();
            grade_mark += assessment.getWeightageMarks();
        }
        switch((int)grade_mark/10){
            case 10:
            this.overallGrade = "A+";
            break;
            case 9:
            this.overallGrade = "A";
            break;
            case 8:
            this.overallGrade = "B+";
            break;
            case 7:
            this.overallGrade = "B";
            break;
            case 6:
            this.overallGrade = "C+";
            break;
            case 5:
            this.overallGrade = "C";
            break;
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
            this.overallGrade = "Failure";
            break;
            default:
            this.overallGrade = "Failure";
            break;
        }
        getGradePoints(this.overallGrade); 
        return overallGrade;
    }

    

    
    public static double getGradePoints(String grade){
        double gradePoint = 0;
        switch(grade){
        case "A+":
        gradePoint = 4;
        break;
        case "A":
        gradePoint = 3.5;
        break;
        case "B+":
        gradePoint = 3;
        break;
        case "B":
        gradePoint = 2.5;
        break;
        case "C+":
        gradePoint = 2;
        break;
        case "C":
        gradePoint = 1.5;
        break;
        case "Failure":
        gradePoint = 0;
        break;
        default:
        gradePoint = 0;
        break;
        }
        return gradePoint;

    }


    public double getWeightedGradePoints(){

        return this.creditUnits*getGradePoints(this.overallGrade);
    }
    

    @Override
    public String toString() {
        return "{" +
                "name=\"" + name + "\"" + "," +
                "id=\"" + moduleCode + '\"' +","+
                "description=\"" + description + '\"' +","+
                "creditUnits=\"" + creditUnits + '\"' +
                
                '}';
    }
}
