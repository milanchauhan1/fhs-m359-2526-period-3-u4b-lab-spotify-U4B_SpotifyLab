import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Playlist {
    private ArrayList<Song> songs;

    public Playlist() {
        songs = new ArrayList<Song>();
    }

    public Playlist(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public String toString() {
        String result = "";
        result += String.format("%-25s %-20s %-25s %-4d %-10s\n", "Title", "Artist", "Album", "Year", "Genre");
        result += "----------------------------------------------------------------------------------\n";
        for (int i = 0; i < songs.size(); i++) {
            result = result + songs.get(i).toString() + "\n";
        }

        return result;
    }

    public void readSongs() {
        try {
            File file = new File("spotify_unique_years_artists.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");

                String title = parts[0];
                String artist = parts[1];
                String album = parts[2];
                int duration = Integer.parseInt(parts[3]);
                int year = Integer.parseInt(parts[4]);
                String genre = parts[5];

                Song s = new Song(title, artist, album, duration, year, genre);
                songs.add(s);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

