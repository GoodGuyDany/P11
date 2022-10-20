public class Books{
    // Creating an array for collection
    private static Book[] books;
    // Declaring variables
    private int count;
    private int length = 0;
    public Book[] getBooks(){
        return books;
    }
    // Creating a method for adding books
    public void addBook(Book b){
        count++;
        Book[] arr = new Book[length + 1];
        for (int i = 0; i < arr.length - 1; i++){
            arr[i] = books[i];
        }
        arr[length] = b;
        length++;
        books = arr;
    }
    // Creating a method for removing books
    public void removeBook(int index){
        // Checking if the index is correct
        if (books == null || index < 0 || index >= books.length){
            System.out.println("There is no book under this number.");
            return;
        }
        // Creating a different array
        Book[] anotherBooks = new Book[books.length - 1];
        // Copying the elements without the index to new array
        for (int i = 0, j = 0; i < books.length; i++){
            // Checking if i == index, if so, do nothing(don't copy to new array)
            if (i == index){
                continue;
            }
            // If i !== index, copy to new array
            anotherBooks[j] = books[i];
            j++;
        }
        books = anotherBooks;
        count--;
    }
    // Creating a method for printing one book
    public static void printOneBook(int index){
        books[index].printDescription();
    }
    // Creating a method for printing all the books
    public static void printAllBooks(){
        for (Book book : books) {
            book.printDescription();
            System.out.println();
        }
    }
    // Creating a method for printing books as a list
    public static void printListOfBooks(){
        int i = 1;
        for (Book book : books) {
            System.out.print("Book " + i + ": ");
            book.printTitle();
            System.out.println();
            i++;
        }
    }
    // Creating a method for sorting by year
    public void sortBooks(){
        boolean isSorted;
        int loopCount = count - 1;
        do{
            isSorted = true;
            for (int i = 0; i < loopCount; i++){
                if (books[i].getPublishYear() > books[i + 1].getPublishYear()){
                    Book temp;
                    temp = books[i];
                    books[i] = books[i + 1];
                    books[i + 1] = temp;
                    isSorted = false;
                }
            }
            loopCount--;
        }while(!isSorted);
    }
    // Creating a method for searching via string
    public void searchBook(String searchPhrase){
        System.out.println("Books that contain " + "'" + searchPhrase + "'");
        for (int i = 0; i < books.length; i++){
            if (books[i].getName().contains(searchPhrase) || books[i].getAuthor().contains(searchPhrase)){
                System.out.println("Index " + i + ": " + books[i].getName() + " " + books[i].getAuthor() + " " + books[i].getPublishYear());
            }
        }
    }
    // Creating a method for searching via year
    public void searchBookByYear(int searchYear){
        System.out.println("Books that were released in " + searchYear + ":");
        for (int i = 0; i < books.length; i++){
            if (books[i].getPublishYear() == searchYear){
                System.out.println("Index " + i + ": " + books[i].getName() + " " + books[i].getAuthor() + " " + books[i].getPublishYear());
            }
        }
    }

}
