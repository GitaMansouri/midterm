package classes;

    public class PremiumBehavior implements UserBehavior {
        private User owner;
        private int month;

        public PremiumBehavior(User owner, int month) {
            this.owner = owner;
            this.month = month;
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

        public User getOwner() {
            return owner;
        }

        public int getMonth() {
            return month;
        }
    }

