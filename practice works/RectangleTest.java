/**
* @author Anmol Guragain
* @since 24 Jan 2022
*/
import java.util.Scanner;
import java.util.List;

/**
 * Rectangle
 */
class Rectangle{  //properties/variable
    double length;
    double width;

    double findArea(){ //method/behaviour
        return this.length * this.width ;
    }
    
}

public class RectangleTest {
    public static void main(String args[]) {
        Rectangle rect1 = new Rectangle();
        rect1.length = 10.5;
        rect1.width =20.4;
        System.out.println(rect1.findArea());
    }

}