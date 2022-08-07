
import java.util.*;
    


public class test {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("Insert amount:");
            try
            {
                double amount = scan.nextDouble();
                System.out.println(amount);
                break;
            } 
            catch (java.util.InputMismatchException e)
            {
                System.out.println("Must be a double.");
                scan.nextLine();
            }
            

        }


    }

    // public static boolean isAlpha(String s) {
    //     return s != null && s.chars().allMatch(Character::isLetter);
    // }
 
    // public static void main(String[] args)
    // {
    //     String s = "ABCD";
    //     System.out.println("IsAlpha: " + isAlpha(s));
    // }


}
