/**
* @author Anmol Guragain
* @since 19 Jan 2022
* @qsn pattern print IN
*/
import java.util.Scanner;
import java.util.List;
public class Pattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int row;
        String indianFlag = "\uD83C\uDDEE\uD83C\uDDF3"; //indian flag emoji
        
        System.out.println("Enter the number of Rows: ");
        row = sc.nextInt(); //taking Input as rows
        
        while(row<3){   //Row should be greater than 3 was the condition
            System.out.println("You entered row less than 3, please enter a greater value: ");
            row = sc.nextInt();

        }
        int col=row+1;  //column is always 1 times greater than row


        /* This is task number 2 of given assignment */
        for (int i = 0; i < row; i++) {     //initializing for loop for each rows
            for (int j = 0; j <= col; j++) {   //nested for loop for each columns
                if(j== 0||j==1 || j==col||j==i+2 ){   //condition inside each column
                    System.out.print(indianFlag + " ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("\n");
        }

        /* This is task number 1 of given assignment */
        System.out.println("Pattern with * in same logic is printed as: \n ");
        for (int i = 0; i < row; i++) {     //initializing for loop for each rows
            for (int j = 0; j <= col; j++) {   //nested for loop for each columns
                if(j== 0||j==1 || j==col||j==i+2 ){   //condition inside each column
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("\n");
        }

    }

}