
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;



class GenericClass<X>{
    private String gender;
    private String group;
    private String prepStattus;
    private T maths;
    private T read;
    private T write;
    
    
    public T getmaths(){
        return maths;
    }
    public T getread(){
         return read;
    }
    public T getwrite(){
        return write;
    }
    
    //making a parameterizedconstructor
    public GenericClass(String gender, String group,String prepStattus, T maths, T read,T write){	 	  	 		      	 	   	    	  	       	 	
        this.gender=gender;
        this.group=group;
        this.prepStattus= prepStattus;
        this.maths = maths;
        this.read= read;
        this.write= write;;
        
        
    }
    public static GenericClass<Integer> parseString(String str) throws Exception{
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
        
        return new GenericClass<Integer>(gender, group, prepStattus, 
                maths, read, write);
    }

    
    public void compare(int sub){
        int gotMarks;
        
        if(sub == 1){
            gotMarks = (Integer) maths;
        }else if(sub == 2){
            gotMarks = (Integer) read;
        }else{
            gotMarks = (Integer) write;
        }

        if(prepStattus.equals("none") ){
            if(gotMarks > 70){
                System.out.println("Marks is good");
            }else{
                System.out.println("Needs to study harder");
            }
        }else{
            if(gotMarks > 80){
                System.out.println("Marks is good");
            }else{
                System.out.println("Needs to study harder");
            }

        }
    }   
}

public class Try{

    

    public static void main(String[] args) {
        List<GenericClass<Integer>> detailedMarks = null;
        try(
            BufferedReader br=new BufferedReader(
            new InputStreamReader(
            new 
            URL("https://raw.githubusercontent.com/anthoniraj/datasets/main/StudentsPerformance.csv").
                openStream() ) );
        ){
            String s;
            detailedMarks = new ArrayList<>();
            GenericClass<Integer> tempVariable;
            
            while((s= br.readLine())!= null){	
                try{ 	  	 		      	 	   	    	  	       	 	
                    tempVariable = GenericClass.parseString(s);
                    detailedMarks.add(tempVariable);
                }catch(Exception e){
                    System.out.println(e.getMessage() );
                }
            }
            
        }
        catch(Exception e){
            System.out.println("Couldn'tread from the file"+ e.getMessage());
        }


        
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter index to compare marks " + detailedMarks.size() + " :: ");
        int index = Integer.parseInt(sc.nextLine() );

        GenericClass<Integer> row = detailedMarks.get(index);

        Random rd = new Random();

        row.compare(rd.nextInt(3));
    }
    
}