import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


class GenericsTest{
    String name;
    int math;
    int science;
    int social;
    public GenericsTest(String name, int math, int science, int social) {
        this.name = name;
        this.math = math;
        this.science = science;
        this.social = social;
    }
    public static GenericsTest parseString(String str) throws Exception{
        String[] values = str.split(",");
        
        String name =values[0].trim();
        Integer math = Integer.parseInt(values[1]);
        Integer science = Integer.parseInt(values[2]);
        Integer social = Integer.parseInt(values[3]);

        return new GenericsTest(name,math,science, social);
    }
        

}


public class ExampleFile{
    public static void main(String[] args) {
        ArrayList <GenericsTest> details = null;
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\VIT\\semester 4\\Java cse 1007\\File handling\\marks.txt"))){
            
            String s;
            GenericsTest temporary;
            details = new ArrayList<>();
            while((s = br.readLine()) != null){
                
                temporary = GenericsTest.parseString(s);
                details.add(temporary);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < details.size(); i++) {
            System.out.println(details.get(i));
            
        }
    }
    
}
