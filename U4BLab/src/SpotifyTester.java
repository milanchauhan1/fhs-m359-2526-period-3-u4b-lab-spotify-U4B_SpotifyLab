
import java.util.InputMismatchException;
import java.util.Scanner;
public class SpotifyTester {

    public static int getValidInput(Scanner scan) {
        int response = -1;
        boolean runs = false;
        while (!runs) {
            try {
                response = scan.nextInt();
                if (response >= 1 && response <= 7) {
                    runs = true;
                } else {
                    System.out.print("Invalid option. Enter a number 1-7: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Enter a number 1-7: ");
                scan.nextLine();
            }
        }
        return response;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Playlist playlist = new Playlist();
        playlist.readSongs();

        int response = -1;

        while(response != 7) {
            System.out.println("==== Spotify Menu ====" + "\n" + "1 - Sort Artists (A -> Z)" + "\n2 - Sort Artists (Z -> A)" + "\n3 - Sort By  Year (Oldest -> Newest)" + "\n4 - Sort By  Year (Newest -> Oldest)" + "\n5 - Search By Genre" + "\n6 - Display all songs" + "\n7 - Quit" + "\nEnter Choice (1-7): ");

            response = getValidInput(scan);

            if(response == 6){
                System.out.println(playlist);
            } else if (response == 7) {
                System.out.println("Thank You For Listening.");

            }
            else if(response == 5){
                scan.nextLine();
                System.out.println("Enter genre: ");
                String genre = scan.nextLine();
                playlist.sortGenre(genre);
            }
            else if(response == 1){
                playlist.sortArtistAz();
                System.out.println(playlist);
            }
            else if(response == 2){
                playlist.sortArtistZa();
                System.out.println(playlist);
            }

        }




    }
}



