
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;



class GenericsTest<X>{
    private String gender;
    private String group;
    private String prepStattus;
    private X maths;
    private X read;
    private X write;
    
    
    public X getmaths(){
        return maths;
    }
    public X getread(){
         return read;
    }
    public X getwrite(){
        return write;
    }
    
    //making a parameterizedconstructor
    public GenericsTest(String gender, String group,String prepStattus, X maths, X read,X write){	 	  	 		      	 	   	    	  	       	 	
        this.gender=gender;
        this.group=group;
        this.prepStattus= prepStattus;
        this.maths = maths;
        this.read= read;
        this.write= write;;
        
        
    }
    public static GenericsTest<Integer> parseString(String str) throws Exception{
        String[] values = str.split(",");
        
        if(values.length != 6){
            throw new Exception("Invalid");
        }

        String gender =values[0].trim();
        String group =values[1].trim();
        String prepStattus= values[2].trim();

        Integer maths = Integer.parseInt(values[3]);
        Integer read = Integer.parseInt(values[4]);
                    Integer write = Integer.parseInt(values[5]);
        
        return new GenericsTest<Integer>(gender, group, prepStattus, 
                maths, read, write);
    }

    
    public void compare(int sub){
        int acquired;
        
        if(sub == 1){
            acquired = (Integer) maths;
        }else if(sub == 2){
            acquired = (Integer) read;
        }else{
            acquired = (Integer) write;
        }

        if(prepStattus.equals("none") ){
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


        
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter index to compare marks " + details.size() + " :: ");
        int index = Integer.parseInt(sc.nextLine() );

        GenericsTest<Integer> row = details.get(index);

        Random rd = new Random();

        row.compare(rd.nextInt(3));
    }
    
}