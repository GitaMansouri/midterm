package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist extends User {
    private ArrayList<Music> playlist = new ArrayList<>();
    ;
    private User owner;
    private String title;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void editTitle(String newTitle) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password. Only the owner can remove music.");
        }
        this.title = newTitle;
    }

    public void addMusic(Music music) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password. Only the owner can remove music.");
        }
        if (playlist.contains(music)) {
            throw new InvalidOperationException("This music already exists in the playlist.");
        }
        playlist.add(music);
    }

    public void removeMusic(Music music) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password. Only the owner can remove music.");
        }
        if (!playlist.contains(music)) {
            throw new InvalidOperationException("This music does not exist in the playlist.");
        }
        playlist.remove(music);
    }

    public ArrayList<Music> searchInPlaylist(String title) {
        ArrayList<Music> foundMusics = new ArrayList<>();
        for (Music music : playlist) {
            if (music.getTitle().equalsIgnoreCase(title)) {
                foundMusics.add(music);
            }
        }
        if (foundMusics.isEmpty()) {
            return null;
        } else {
            return foundMusics;
        }
    }

    Scanner scn = new Scanner(System.in);

    public void playPlaylist() throws InvalidOperationException {
        if (playlist.isEmpty()) {
            throw new InvalidOperationException("Playlist is empty.");
        }
        else {
            System.out.println("Playing playlist: " + title);

            for (Music music : playlist) {
                music.play();
                System.out.println("Now playing: " + music.getTitle());
                System.out.println("Enter 'next' to stop.");
                String input = scn.nextLine();
                if (input.equalsIgnoreCase("next")) {
                    break;
                }
            }
        }
    }
}
