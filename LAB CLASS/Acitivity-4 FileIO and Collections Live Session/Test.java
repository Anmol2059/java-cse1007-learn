
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;


//creating custom generics as per requirements
class GenericsTest<X>{
    private String gender;
    private String group;
    private String preparation;
    private X math_score;
    private X reading_score;
    private X writing_score;
    
    /*public GenericsTest(X math_score){
        this.math_score = math_score;
    }
    public GenericsTest(X reading_score){
        this.reading_score= reading_score;
    }
    public GenericsTest(X writing_score){
        this.writing_score= writing_score;
    }*/
    public X getMath_score(){
        return math_score;
    }
    public X getReading_score(){
         return reading_score;
    }
    public X getWriting_score(){
        return writing_score;
    }
    
    //making a parameterizedconstructor
    public GenericsTest(String gender, String group,String preparation, X math_score, X reading_score,X writing_score){	 	  	 		      	 	   	    	  	       	 	
        this.gender=gender;
        this.group=group;
        this.preparation= preparation;
        this.math_score = math_score;
        this.reading_score= reading_score;
        this.writing_score= writing_score;;
        
        
    }
    public static GenericsTest<Integer> parseString(String str) throws Exception{
        String[] values = str.split(",");
        
        if(values.length != 6){
            throw new Exception("Invalid");
        }

        String gender =values[0].trim();
        String group =values[1].trim();
        String preparation= values[2].trim();

        Integer math_score = Integer.parseInt(values[3]);
        Integer reading_score = Integer.parseInt(values[4]);
                    Integer writing_score = Integer.parseInt(values[5]);
        
        return new GenericsTest<Integer>(gender, group, preparation, 
                math_score, reading_score, writing_score);
    }

    
    public void compare(int sub){
        int acquired;
        
        if(sub == 1){
            acquired = (Integer) math_score;
        }else if(sub == 2){
            acquired = (Integer) reading_score;
        }else{
            acquired = (Integer) writing_score;
        }

        if(preparation.equals("none") ){
            if(acquired > 70){
                System.out.println("Marks is good");
            }else{
                System.out.println("Needs to study harder");
            }
        }else{
            if(acquired > 80){
                System.out.println("Marks is good");
            }else{
                System.out.println("Needs to study harder");
            }

        }
    }   
}

public class Test{

    public static void calculateAverage(List<GenericsTest<Integer>> details){
        double[] average = new double[3];

        for(int i = 0; i < average.length; i++){
            average[i] = 0;
        }

        details.forEach((row) -> {
            average[0] += row.getMath_score();
            average[1] += row.getReading_score();
            average[2] += row.getWriting_score();
        });

        for (int i = 0; i < average.length; i++) {
            average[i] = average[i] / (double) details.size();
        }

        System.out.println("\nAverage for math = " + average[0]);
        System.out.println("\nAverage for reading = " + average[1]);
        System.out.println("\nAverage for writing = " + average[2]);
    }

    public static void main(String[] args) {
        List<GenericsTest<Integer>> details = null;
        try(
            BufferedReader br=new BufferedReader(
            new InputStreamReader(
            new 
            URL("https://raw.githubusercontent.com/anthoniraj/datasets/main/StudentsPerformance.csv").
                openStream() ) );
        ){
            String s;
            details = new ArrayList<>();
            GenericsTest<Integer> temporary;
            
            while((s= br.readLine())!= null){	
                try{ 	  	 		      	 	   	    	  	       	 	
                    temporary = GenericsTest.parseString(s);
                    details.add(temporary);
                }catch(Exception e){
                    System.out.println(e.getMessage() );
                }
            }//whileloop
            
        }//try ends here
        catch(Exception e){
            System.out.println("Couldn'tread from the file"+ e.getMessage());
        }

        calculateAverage(details);
        
        Scanner sc = new Scanner(System.in);

        // compare marks
        System.out.print("Enter index between 0 to " + details.size() + " :: ");
        int index = Integer.parseInt(sc.nextLine() );

        GenericsTest<Integer> row = details.get(index);

        Random rd = new Random();

        row.compare(rd.nextInt(3));
    }
    
}