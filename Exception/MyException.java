import java.util.ArrayList;
import java.util.Arrays;

//We create a System for Patanjali Stores to check if Goods is added to ArrayList already or not

// create a checked exception class
class CustomException extends Exception {
  public CustomException(String message) {
    // call the constructor of Exception class
    super(message);
  }
}

public class MyException{

  ArrayList<String> goods = new ArrayList<>(Arrays.asList("Sugar", "Honey", "Mustard Oil"));

  // check the exception condition
  public void checkGoods(String good) throws CustomException {

    // throw exception if goods already present in ArrayList
    if(goods.contains(good)) {
      throw new CustomException(good + " already added in the Basket, add something new");
    }
    else {
      // insert goods to ArrayList
      goods.add(good);
      System.out.println(good + " is added to the Basket i,e ArrayList");
    }
  }

  public static void main(String[] args) {

    // create object of MyException Class
    MyException obj = new MyException();

    // Let's try to add a goods that is already present in ArrayList and next element that is not present in ArrayList.
    try {
      obj.checkGoods("Patanjali Biscuit");
      obj.checkGoods("Sugar");
    }

    catch(CustomException e) {
      System.out.println("[" + e + "] Exception Occured");
    }
  }
}