/* Anmol Guragain

 ##Book
    title, year of publication, author
  #PrintBook
    publisher, ISBN
  #AudioBook
    size, playback, artist
    



*/
import java.util.*;
class Book{
    private int bookid;
    private String title;
    private String author;
    private int yearOfPub;
    public Book(int bookid, String title, String author, int yearOfPub){
        this.bookid= bookid;
        this.title= title;
        this.author = author;
        this.yearOfPub= yearOfPub;
    }
    //getter
    public String getTitle(){
        return title;
    }
    //setter
    public void setTitle(String title){
        this.title=title;
    }
    public int getBookid(){
        return bookid;
    }
    public void setBookid(int bookid){	 	  	 		      	 	   	    	  	       	 	
        this.bookid=bookid;
    }
    
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public int getYearOfPub(){
        return yearOfPub;
    }
    public void setYearOfPub(){
        this.yearOfPub= yearOfPub;
    }
    @Override
    public String toString() {
        return "Book [bookid = " + bookid + " title = " + title + " author = " + author + " yearOfPub = " + yearOfPub +  "]";
    } 
}
//Inheritance usage
class PrintBook extends Book{
    private String publisher;
    private int ISBN;
    
    /*
    public PrintBook(){}
    
    public PrintBook(String publisher, int ISBN){
        this.publisher=publisher;
        this.ISBN=ISBN;
    }
    */
    
    public PrintBook(int bookid, String title, String author, int yearOfPub, String publisher , int ISBN){
        super(bookid, title, author, yearOfPub);
        this.publisher= publisher;
        this.ISBN= ISBN;
        
    }	 	  	 		      	 	   	    	  	       	 	
    public String getPublisher(){
        return publisher;
    }
    public int getISBN(){
        return ISBN;
    }
    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
    public void setISBN(int ISBN){
        this.ISBN=ISBN;
    }
    @Override
    public String toString() {
        return "Book [bookid = " + super.getBookid() + " title = " + super.getTitle() + " author = " + super.getAuthor() + " yearOfPub = " + super.getYearOfPub() + " Publisher = " + publisher + " ISBN = " + ISBN + " ]";
    } 
    
    
}
class AudioBook extends Book{
    private int size;
    private int playback;
    String artist;
    public AudioBook(int bookid, String title, String author, int yearOfPub, int size, int playback , String artist){
        super(bookid, title, author, yearOfPub);
        this.size=size;
        this.playback=playback;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size=size;
    }
    public int getPlayback(){
        return playback;
    }	 	  	 		      	 	   	    	  	       	 	
    public void setPlayBack(){
        this.playback=playback;
    }
    public String getArtist(){
        return artist;
    }
    public void setArtist(String artist){
        this.artist=artist;
    }
    @Override
    public String toString() {
        return "Book [bookid= " + super.getBookid() + " title = " + super.getTitle() + " author = " + super.getAuthor() + " yearOfPub = " + super.getYearOfPub() + " size = " + size + " playback = " + playback + "Artist = " + artist + "]"; 
    } 
}


public class Main{
    
    
    static ArrayList<PrintBook> printBooks = new ArrayList<>();
    static ArrayList<AudioBook> audioBooks = new ArrayList<>();

    public static void addAudioBook(){
        Scanner scanner=new Scanner(System.in);
        int audioBooksAdded = 0;
        int bookid, yearOfPub, size, playback;
        String title, author, artist;
        while(audioBooksAdded > 1){
    

            System.out.print("Please enter the book id: example: 01 ");
            bookid = scanner.nextInt();
        
            System.out.println("\nPlease enter the Title : ");
        
            title = scanner.nextLine();
            System.out.println("\nPlease enter the Author name: ");
            author = scanner.nextLine();
            System.out.println("\nPlease enter the yearOfPub: ");
            yearOfPub = scanner.nextInt();
            System.out.println("\nPlease enter the Size in MB: ");
            size = scanner.nextInt();
            System.out.println("\nPlease enter the Playback time: ");
            playback = scanner.nextInt();
            System.out.println("\nPlease enter the artist: ");
            artist = scanner.nextLine();
            AudioBook audioBook = new AudioBook(bookid,title, author, yearOfPub,size, playback, artist);
            audioBooks.add(audioBook);
            audioBooksAdded++;
            System.out.println("\n Audio book was added successfully");
        }
    }
    public static void addPrintBook(){
        Scanner scanner=new Scanner(System.in);
        int printBooksAdded = 0;
        int bookid, yearOfPub, ISBN;
        String title, author, publisher;
        while(printBooksAdded > 1){
    

            System.out.print("Please enter the book id: example: 01 ");
            bookid = scanner.nextInt();
        
            System.out.println("\nPlease enter the Title : ");
        
            title = scanner.nextLine();
            System.out.println("\nPlease enter the Author name: ");
            author = scanner.nextLine();
            System.out.println("\nPlease enter the yearOfPub: ");
            yearOfPub = scanner.nextInt();
            System.out.println("\nPlease enter the Publisher ");
            publisher = scanner.nextLine();
            System.out.println("\nPlease enter the ISBN ");
            ISBN = scanner.nextInt();
            
            PrintBook printBook = new PrintBook(bookid,title, author, yearOfPub,publisher , ISBN);
            printBooks.add(printBook);
            printBooksAdded++;
            System.out.println("\n Print book was added successfully");
        }
    }

    public static void printBookDetails(){
        System.out.println("print Books Detail");
    }

    public static void audioBookDetails(){
        System.out.println("Audio Books Detail");
    }
    
    
    public static void main(String args[]){
        AudioBook book1= new AudioBook(1, "Veronica" , "Paulo Coelho", 1990, 5, 3, "Arijit Singh");
        System.out.println(book1.toString());
        Scanner scanner=new Scanner(System.in);
    	 	  	 		      	 	   	    	  	       	 	
    int temp=1;
    
    while(temp != 5){
        System.out.println("Which type of Book you would like ?" +
        "\n" +
        "1. Details about PrintBook" +
        "\n" +
        "2. Details about AudioBook" +
        "\n" +
        "3. Add PrintBook" +
        "\n" +
        "4. Add AudioBook" +
        "\n" +
        "5. I want to exit" +
        "\n");
        System.out.println("your selection (1-5) ");
        temp= scanner.nextInt();
        switch (temp){
            case 1:printBookDetails();
            break;
            case 2:audioBookDetails();
            break;
            case 3:addPrintBook();
            break;
            case 4:addAudioBook();
            break;
            case 5: {
                temp =3;
                System.out.println("Thank you for using ");
                scanner.close();
                return;
            }
            default: {System.out.println("Invalid");}
        }
        
    }
    scanner.close();
}}
    















	 	  	 		      	 	   	    	  	       	 	
