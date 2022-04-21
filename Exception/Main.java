import java.util.ArrayList;
public class Main{
    public static void main(String args[]){
        ArrayList<String> list=new ArrayList<String>();
        list.add("Jeegyasha");
        list.add("Tara");
        list.add("Niraula");
        System.out.println(list);
        list.remove(2);
        System.out.println("after removing:");
        System.out.println(list);
        
    }
    
}