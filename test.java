
public class test {
    public static int iStatic = 10; 
    public void nonStatic() {
         System.out.println("can access static variable inside non-static method : " + iStatic); main(new String[2]); 
        } 
    public static void main(String[] args) { 
        System.out.println("Inside main method"); 
    } }
