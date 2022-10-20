//Project 11. Complex project
import java.io.*;
import java.util.Scanner;
public class Main{
    public static void readBooks(){
        try {
            File myFile = new File("Books.txt");
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                String readData = reader.nextLine();
                System.out.println(readData);
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    } // readBooks
    public static void addBooks(Book[] books)
    {
        String str;
        try {
            FileWriter myWriter = new FileWriter("Books.txt");
            for(int i = 0; i < books.length; i++){
                str = i + ": " + books[i].getName() + " " + books[i].getAuthor() + " " + books[i].getPublishYear();
                myWriter.write(str);
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully added the books!");
        }
        catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    } // addBooks

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Books books = new Books();
        boolean go = true;
        System.out.println("Welcome to the book database!" + "\n" + "Choose an option to proceed:");
        while (go) {
            System.out.println(
                    """
                            1 - Print book list
                            2 - Add new book
                            3 - Remove book
                            4 - Sort books by year
                            5 - Search books by author
                            6 - Search books by year
                            7 - Print detailed book list
                            8 - Read books from file
                            9 - Save books to file
                            0 - Exit the program"""
            );
            String ans = sc.nextLine();
            switch(ans){
                case "1":
                    Books.printListOfBooks();
                    break;
                case "2":
                    System.out.println("Book name:");
                    String name = sc.nextLine();
                    System.out.println("Book author:");
                    String author = sc.nextLine();
                    System.out.println("Year when published:");
                    int year = sc.nextInt();
                    sc.nextLine();
                    Book newBook = new Book();
                    newBook.setBook(name, author, year);
                    books.addBook(newBook);
                    System.out.println("Book successfully added!");
                    break;
                case "3":
                    System.out.println("Which book would you like to remove?");
                    int bookToRemove = sc.nextInt();
                    sc.nextLine();
                    books.removeBook(bookToRemove);
                    break;
                case "4":
                    books.sortBooks();
                    break;
                case "5":
                    System.out.println("Input search phrase:");
                    String searchPhrase = sc.nextLine();
                    books.searchBook(searchPhrase);
                    break;
                case "6":
                    System.out.println("What year would you like to search by?");
                    int searchYear = sc.nextInt();
                    sc.nextLine();
                    books.searchBookByYear(searchYear);
                    break;
                case "7":
                    Books.printAllBooks();
                    break;
                case "8":
                    readBooks();
                    break;
                case "9":
                    addBooks(books.getBooks());
                    break;
                case "0":
                    System.out.println("Bye then!");
                    go = false;
                    break;
                default:
                    return;

            }

        }
    } // Main
} // Main class
