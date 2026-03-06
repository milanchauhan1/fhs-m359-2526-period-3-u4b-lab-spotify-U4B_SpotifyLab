import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Playlist {
    private ArrayList<Song> songs;
    //initializing arraylist without paramaeter
    public Playlist() {
        songs = new ArrayList<Song>();
    }
    //with parameter constructor
    public Playlist(ArrayList<Song> songs) {
        this.songs = songs;
    }
    //returns formatted concatenated string
    public String toString() {
        String result = "";
        result += String.format("%-25s %-20s %-25s %-4s %-10s\n", "Title", "Artist", "Album", "Year", "Genre");
        result += "----------------------------------------------------------------------------------\n";
        //add all songs to result iterating through songs
        for (int i = 0; i < songs.size(); i++) {
            result = result + songs.get(i).toString() + "\n";
        }

        return result;
    }


    //read in file and use try and catch block in case file is incorrect
    //adds them to the arraylist uses scanner and split to get each part
    public void readSongs() {
        try {

            Scanner scan = new Scanner(new File("U4BLab/spotify_unique_years_artists.txt"));
            //iterate through all content of file
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] diffParts = line.split(",");

                String title = diffParts[0];
                String artist = diffParts[1];
                String album = diffParts[2];
                int duration = Integer.parseInt(diffParts[3]);
                int year = Integer.parseInt(diffParts[4]);
                String genre = diffParts[5];

                Song sObj = new Song(title, artist, album, duration, year, genre);
                songs.add(sObj);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    //no parameters, returns nothing, prints, genre sort, finds if genre of song object is equal to song searched, prints all that match ignoring case
    public void sortGenre(String genre){
        boolean found = false;
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).getGenre().toLowerCase().equals(genre.toLowerCase())){
                System.out.println(songs.get(i).toString());
                found = true;
            }

        }
        if(found == false){
            System.out.println("No songs are in the " + genre + " genre.");
        }
    }
    //selection sort implementation, non adaptive so always looks through all values even when sorted, nested for loop, compareTo
    public void sortArtistAz(){
        for(int i = 0; i < songs.size() - 1; i++){
            //nested for loop to search through next values
            for(int j = i + 1; j < songs.size(); j++ ){
                if(songs.get(i).getArtist().compareTo(songs.get(j).getArtist()) > 0){
                    Song temp = songs.get(i);
                    songs.set(i,songs.get(j));
                    songs.set(j, temp);


                }
            }
        }
    }
    //same selection sort implementation flips sign so it goes reverse, same nested for loop no need for back to front iteration
    public void sortArtistZa(){
        for(int i = 0; i < songs.size() - 1; i++){
            //nested for loop to search through values in front of i in array
            for(int j = i + 1; j < songs.size(); j++ ){
                if(songs.get(i).getArtist().compareTo(songs.get(j).getArtist()) < 0){
                    //stores temp so nothing is overwritten
                    Song temp = songs.get(i);
                    songs.set(i,songs.get(j));
                    songs.set(j, temp);


                }
            }
        }
    }
    //insertion sort with while loop in for loop, is adapative and will stop early if sorted, checks value of currentsong and compares with songs from list
    public void sortByReleaseYearOld() {
        for (int i = 1; i < songs.size(); i++) {
            //insertion sort from class w nested while loop
            Song currentSong = songs.get(i);
            int j = i - 1;

            while (j >= 0 && songs.get(j).getReleaseYear() > currentSong.getReleaseYear()) {
                songs.set(j + 1, songs.get(j));
                j--;
            }

            songs.set(j + 1, currentSong);
        }
    }
    //same insertion sort for loop outside while loop in, flips sign to go opposite order of ascending and descending
    public void sortByReleaseYearNew() {
        //insertion sort from class
        for (int i = 1; i < songs.size(); i++) {
            Song currentSong = songs.get(i);
            int j = i - 1;

            while (j >= 0 && songs.get(j).getReleaseYear() < currentSong.getReleaseYear()) {
                songs.set(j + 1, songs.get(j));
                j--;
            }

            songs.set(j + 1, currentSong);
        }
    }

}

