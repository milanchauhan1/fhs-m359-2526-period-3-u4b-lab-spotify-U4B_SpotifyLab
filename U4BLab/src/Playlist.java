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
        result += String.format("%-25s %-20s %-25s %-4s %-10s\n", "Title", "Artist", "Album", "Year", "Genre");
        result += "----------------------------------------------------------------------------------\n";
        for (int i = 0; i < songs.size(); i++) {
            result = result + songs.get(i).toString() + "\n";
        }

        return result;
    }



    public void readSongs() {
        try {

            Scanner scan = new Scanner(new File("fhs-m359-2526-period-3-u4b-lab-spotify-U4B_SpotifyLab/U4BLab/spotify_unique_years_artists.txt"));

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] diffParts = line.split(",");

                String title = diffParts[0];
                String artist = diffParts[1];
                String album = diffParts[2];
                int duration = Integer.parseInt(diffParts[3]);
                int year = Integer.parseInt(diffParts[4]);
                String genre = diffParts[5];

                Song s = new Song(title, artist, album, duration, year, genre);
                songs.add(s);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    public void sortGenre(String genre){
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).getGenre().toLowerCase().equals(genre.toLowerCase())){
                System.out.println(songs.get(i).toString());
            }

        }
    }
    public void sortArtistAz(){
        for(int i = 0; i < songs.size() - 1; i++){
            for(int j = i + 1; j < songs.size(); j++ ){
                if(songs.get(i).getArtist().compareTo(songs.get(j).getArtist()) > 0){
                    Song temp = songs.get(i);
                    songs.set(i,songs.get(j));
                    songs.set(j, temp);


                }
            }
        }
    }
    public void sortArtistZa(){
        for(int i = 0; i < songs.size() - 1; i++){
            for(int j = i + 1; j < songs.size(); j++ ){
                if(songs.get(i).getArtist().compareTo(songs.get(j).getArtist()) < 0){
                    Song temp = songs.get(i);
                    songs.set(i,songs.get(j));
                    songs.set(j, temp);


                }
            }
        }
    }
}

