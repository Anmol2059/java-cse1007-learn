import java.util.Scanner;
//Interface Definition (2 Marks)
interface CalculatorFunctions {
  
  abstract int addition(int x, int y); 
  abstract int subtraction(int x , int y);
  abstract int multiplication(int x , int y);
  abstract double division(int x , int y);
  abstract double power(int x , int y);
}

//Abstract Parent Class (2 Mark)
abstract class BasicCalculator implements CalculatorFunctions {
  
  public BasicCalculator() { //default constructor
  }


  @Override
  public int addition(int x, int y){
    
    int ans = x+y;
    return ans;
  }
    
     
  
  @Override
  public int subtraction(int x, int y) {
    int ans= x - y;
    return ans;
  }
  @Override
  public int multiplication(int x, int y) {
    int ans= x * y;
    return ans;
  }
  @Override
  public double division(int x, int y) {
    double ans= x / y;
    return ans;
  }
}

//Implementing Sub Class (2 Marks)
class ScientificCalculator extends BasicCalculator{

  @Override
  public double power(int x, int y) {
    double ans= Math.pow(x, y);
    return ans;
  }
}


class CalculatorValue {
	private int firstNumber;
	private int secondNumber;
  
	
	public int getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}
	public int getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}
	

}

class CalculatorTest {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
		System.out.println("Enter first number");
		int firstNumber = scan.nextInt();

		System.out.println("Enter second number");
		int secondNumber = scan.nextInt();
		
    
		CalculatorValue values = new CalculatorValue();
		values.setFirstNumber(firstNumber); 
		values.setSecondNumber(secondNumber);
		
		ScientificCalculator cal = new ScientificCalculator();
		
		
		
		int addResult = cal.addition(values.getFirstNumber(), values.getSecondNumber());
		System.out.println("The Addition Result is ="+addResult);
		
		
		int subResult = cal.subtraction(values.getFirstNumber(), values.getSecondNumber());
		System.out.println("The Subtraction Result is ="+subResult);
		
		int mulResult = cal.multiplication(values.getFirstNumber(), values.getSecondNumber());
		System.out.println("The Multiplication Result is ="+mulResult);
		
		//Custom Exception Creation and Validation (2 Marks)
		try{
		double divResult = cal.division(values.getFirstNumber(), values.getSecondNumber());
		System.out.println("The Division Result is ="+divResult);
		}
		catch(Exception f)  
        {  
            // displaying the custom message  
            System.out.println("We cannot divided the number  by zero");  
        } 
        double powerResult = cal.power(values.getFirstNumber(), values.getSecondNumber());
        System.out.println("The Power Result is ="+powerResult);
  }
}
	 	  	 		      	 	   	    	  	       	 	
