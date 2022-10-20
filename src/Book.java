public class Book{
    // Declaring the variables
    private String name;
    private String author;
    private int publishYear;

    // Creating getters for private properties
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public int getPublishYear(){
        return publishYear;
    }
    // Creating a setter for all the properties
    public void setBook(String name, String author, int publishYear){
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }
    // Creating a method for printing a full description
    public void printDescription(){
        System.out.println("The book name is: " + name + "\nThe book author is: " + author + "\nThe book was published in: " + publishYear);
    }
    // Creating a method for printing a short description
    public void printTitle(){
        System.out.print(name + " " + author + " " + publishYear);
    }
    // Creating methods for returning title and description(not really used anywhere because of printDescription/printTitle
    public String getDescription(){
        return name + "\n" + author + "\n" + publishYear;
    }
    public String getTitle(){
        return name + " " + author + " " + publishYear;
    }
} // Book class
