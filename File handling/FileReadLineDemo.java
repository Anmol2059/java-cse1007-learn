import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Java File IO - Read File Content using Byte Stream
 * @author Anthoniraj Amalanathan
 * @since 03-Mar-2022
 */


public class FileReadLineDemo {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\VIT\\semester 4\\Java cse 1007\\File handling\\demofile.txt"))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
