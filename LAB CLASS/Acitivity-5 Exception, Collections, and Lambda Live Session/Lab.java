import java.util.*;
    
    //creating the exception as per the requirement
    class MarksException extends Exception{
        private String errormsg;
        
        public String getErrormsg(){
            return errormsg;
        }
        public void setErrormsg(String errormsg){
            this.errormsg = errormsg;
        }
        public MarksException(String errormsg){
            super(errormsg);
            this.errormsg=errormsg;
        }
    }
    


class MarksStudent{
    private int regno;
    //private static int marks=6;
    
    private ArrayList<Double> marks;
    
    public void setRegno(int regno){
        this.regno=regno;
    }
    
    //function to get the marks
    public ArrayList<Double> getMarks(){
        return marks;
        
        
        
        
    }	 	  	 		      	 	   	    	  	       	 	
    
    public MarksStudent(){
        regno=0;
        marks= new ArrayList<>(6);
    }
    public MarksStudent(int regno, ArrayList<Double> marks){
        this.regno= regno;
        this.marks=marks;
        
    }
    public static MarksStudent addStudent(String st)throws MarksException{
        String[] vals= st.split(":");
        
        int regno =Integer.parseInt(vals[0]);
        ArrayList<Double> marks =new ArrayList<>();
        
        for(int i=0; i<vals.length;i++){
            Double tmp=Double.parseDouble(vals[i+1].trim());
            
            //checking the condition to throw exception
            if(tmp >20 || tmp<20){
                throw new MarksException("Marks isnt in range");
            }else{
                marks.add(tmp);
            }
        }
        return new MarksStudent(regno , marks);
        
    }
}

public class Lab{
    
    public static void main(String[] args){
        //this value is later parsed and stored in the corresponding array 
        String[] read ={	 	  	 		      	 	   	    	  	       	 	
            "10001:16:18:18:17:16:16",
            "10002:20:20:19:19:19:17",
            "10004:13:19:11:13:16:19"
            
        };
        ArrayList<MarksStudent> labstud= new ArrayList<>();
        
        try{
            for(int i=0;i<read.length;i++){
                labstud.add(MarksStudent.addStudent(read[i]));
                
                
            }
            
        }catch(MarksException e){
            System.out.println(e.getErrormsg());
        }
        //for list of students who got less than 15
        System.out.println("They scored less than 15: \n");
        System.out.println(labstud.stream()
                                .filter(x ->(x.getMarks().stream()
                                .filter(e -> e>15)
                                .toList().size()==6)
                                ).toList()
                                );
                                
        int count=2;
        //Calculating average marksof student in 2nd index
        System.out.println("\n \n Their average: ");
        
        System.out.println(
            labstud.stream()
            .mapToDouble(e ->
                e.getMarks().get(2)
                ).average().getAsDouble()
                
            
            
            );
        
        //convert marks to 100 which was /20
        System.out.println(
                labstud.stream()
            .map(e -> (e.getMarks().stream()
                .map(x -> ((x *100)/20))
                .toList()
                )).toList()
            
            );
    }	 	  	 		      	 	   	    	  	       	 	
}