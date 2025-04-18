package classes;

import java.util.*;

public class Music {
    private String title;
    private User singer;
    public int numberOfStream = 0;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer){
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public void play(){
        System.out.println("Muisc '" + title + "' by " + singer.getUsername() + "is playing");
    }

    public ArrayList<Music> search(String title) {
        ArrayList<Music> foundMusics = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.title.equalsIgnoreCase(title)) {
                foundMusics.add(music);
            }
        }
        if (foundMusics.isEmpty()){
            return null;
        }
        else {
            return foundMusics;
        }
    }

    public Music search(String title, String singerName) {
        for (Music music : allMusics) {
            if (music.title.equalsIgnoreCase(title) && music.singer.getUsername().equalsIgnoreCase(singerName)) {
                return music;
            }
        }
        return null;
    }
}
