package classes;

public class PremiumBehavior implements UserBehavior {
    private int month;
    private User owner;

    public PremiumBehavior(User owner, int month) {
        this.month = month;
        this.owner = owner;
    }

    @Override
    public void createPlaylist(String title, User owner) {
        Playlist newPlaylist = new Playlist(title, owner);
        owner.getPlaylists().add(newPlaylist);
    }

    @Override
    public void playMusic(Music music) {
    music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month;
    }

}
