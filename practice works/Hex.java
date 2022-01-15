/**
* @author Anmol Guragain
* @since 13 Jan 2022
* @qsn  convert a decimal number to octal number. 
*/
import java.util.Scanner;
import java.util.List;
public class Hex {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int dec_number,rem ;
        String hex_num ="";
        String oct_num= "";
        System.out.println("Enter the decimal number : ");
        dec_number = sc.nextInt();
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char oct[]={'0','1','2','3','4','5','6','7'};
        /*while(dec_number > 0){
            rem = dec_number % 16;
            hex_num = hex[rem] + hex_num ;
            dec_number = dec_number/16;
        }
        
        System.out.println("The hexadecimal value is : " + hex_num);
        */
        while(dec_number > 0){
            rem = dec_number % 8;
            oct_num = oct[rem] + oct_num ;
            dec_number = dec_number/8;
        }
        System.out.println("The octal value is : " + oct_num);
    }

}