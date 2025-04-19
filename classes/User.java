package classes;
import java.util.*;

public class User {

protected static String username;
protected static String password;
private ArrayList<User> followerList;
private ArrayList<User> followingList;
public UserBehavior behavior;
private ArrayList<Playlist> playlists;
public static ArrayList<User> allUsers = new ArrayList<>();

public User(String username, String password) throws InvalidOperationException{
    if (!isValidUsername(username)) {
        throw new InvalidOperationException("Username already exists.");
    }
    if (!isValidPassword(password)) {
        throw new InvalidOperationException("Password must be at least 8 characters long.");
    }

    this.username = username;
    this.password = password;
    this.followerList = new ArrayList<>();
    this.followingList = new ArrayList<>();
    this.behavior = new RegularBehavior();
    this.playlists = new ArrayList<>();

    allUsers.add(this);
}

    public User() {
    }

    public String getUsername() {
        return username;
    }
    public static String getPassword() {
        return password;
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
    private boolean isValidUsername(String username) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public void follow(User user) throws InvalidOperationException {
        if (this.followingList.contains(user)) {
            throw new InvalidOperationException("This user have been already followed");
        }
        else{
            this.followingList.add(user);
            user.followerList.add(this);
        }
    }
    public void createPlaylist(String title, User owner){
    this.behavior.createPlaylist(title,this);
    }
    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }
    public void buyPremium(User owner, int month) {
        this.behavior.buyPremium(owner, month);
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public ArrayList<User> getFollowerList() {
        return followerList;
    }

    public ArrayList<User> getFollowingList() {
        return followingList;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }

}
