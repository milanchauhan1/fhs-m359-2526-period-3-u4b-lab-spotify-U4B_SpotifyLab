import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SpotifyTester {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("==== Spotify Menu ====" + "\n" + "1 - Sort Artists (A -> Z)" + "\n2 - Sort Artists (Z -> A)" + "\n3 - Sort By  Year (Oldest -> Newest)" + "\n4 - Sort By  Year (Newest -> Oldest)" + "\n5 - Search By Genre" + "\n6 - Display all songs" + "\n7 - Quit" + "\nEnter Choice (1-7): ");



            int response = scan.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Invalid Input, please try again");
            scan.nextLine();
        }



    }
}



