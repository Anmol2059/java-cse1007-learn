import java.util.Scanner;

public class Calculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, f, d, e;

        System.out.print("Enter two numbers(separated by space): ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = a + b;
        f = a - b;
        d = a * b;
        e = a / b;

        sc.nextLine(); // as nextInt does not read \n

        while (true) {

            System.out.print(
                    "Choose the operation you want to perform from following : \n A = Add \n S= Subtract" +
                    "\n M= Multiply \n D= Divide\n N = change inputs\n E = exit\n Enter choice :: ");

            String x = sc.nextLine();

            if (x.equals("A") ) {
                System.out.println("Addition of two number gives " + c);
            } else if (x.equals("S") ) {
                System.out.println("Subtraction of two number gives " + f);
            } else if (x.equals("M") ) {
                System.out.println("Multiplication of two number gives " + d);
            } else if (x.equals("D") ) {
                System.out.println("division of two number gives " + e);
            } else if (x.equals("E") ){
                break;
            } else if (x.equals("N") ){
                System.out.print("\n----\nEnter two numbers(separated by space): ");

                a = sc.nextInt();
                b = sc.nextInt();
                c = a + b;
                f = a - b;
                d = a * b;
                e = a / b;
        
                sc.nextLine();
            } else {
                System.out.println("Invalid choice.");
            }
            
            System.out.println("\n");
        }

        sc.close();

    }

}