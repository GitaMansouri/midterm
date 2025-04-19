package classes;

public class RegularBehavior implements UserBehavior {
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String title, User owner) {
        throw new UnsupportedOperationException("Regular users cannot create playlists.");
    }
    @Override
    public void playMusic(Music music) {
        if (playingLimit > 0) {
            music.play();
            playingLimit--;
            System.out.println("Remaining plays: " + playingLimit);
        } else {
            throw new IllegalStateException("Playing limit reached. Upgrade to premium to play more music.");
        }
    }
    @Override
    public void buyPremium(User owner, int month) {
            owner.behavior = new PremiumBehavior(owner, month);
    }

    public int getPlayingLimit() {
        return playingLimit;
    }
}
