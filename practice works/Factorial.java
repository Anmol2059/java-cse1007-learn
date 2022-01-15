/**
* @author Anmol Guragain
* @since 15 Jan 2022
* @qsn program to find factorial of a number
*/
class Factorial{  
    public static void main(String args[]){  
     int i,fact=1;  
     int number=7;//It is the number to calculate factorial    
     for(i=1;i<=number;i++){    
         fact=fact*i;    
     }    
     System.out.println("Factorial of "+number+" is: "+fact);    
    }  
   } 