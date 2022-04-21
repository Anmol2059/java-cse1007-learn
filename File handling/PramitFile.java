import java.io.*; 
import java.util.ArrayList; 
import java.util.Scanner; 
import java.lang.*; 
 
public class PramitFile { 
    public static void main(String[] args) { 
        String input= "Pramit"; 
        try{ 
File obj=new File("D:\\VIT\\semester 4\\Java cse 1007\\File handling\\testout.txt"); 
 
            String bowler,wickets,econ,balls_per_wicket; 
            Scanner sc=new Scanner(obj); 
            while (sc.hasNextLine()){ 
 
                    String[] array = sc.nextLine().split(","); 
                    System.out.println(array.length); 
                    for(int i=0;i<array.length;i++) 
                    { 
                        array[i] = array[i].trim(); 
                        System.out.println(array[i]); 
 
                        if(array[0].equals(input)){ 
                            System.out.println("Running..."); 
                            bowler=array[0]; 
                            wickets=array[1]; 
                            econ = array[2]; 
                            balls_per_wicket=array[3]; 
                            System.out.println("Bowler "+bowler); 
                            System.out.println("Wickets "+wickets); 
                            System.out.println("Econ "+econ); 
                            System.out.println("balls per wicket "+balls_per_wicket);
                            Integer economy = Integer.parseInt(econ);
                            Integer wickets_file = Integer.parseInt(wickets);
                            int average = economy/wickets_file;
                            
                            break; 
                        } 
                        else{ 
                            continue; 
                        } 
 
                        System.out.println("Avg of" + (String) array[0] + " is" + average  );
                } 
            } 
 
        } 
        catch (Exception e) 
        { 
            System.out.println(e.getMessage()); 
        } 
    } 
}