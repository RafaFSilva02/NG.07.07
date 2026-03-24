public class MediaPlayer {
    int volume;
    boolean muted;


    public MediaPlayer() {
        this.volume = 5;
        this.muted = false;
    }

    public boolean isMuted() {
        return muted;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    protected void increaseVolume(){
        this.volume++;
    }

    protected void decreaseVolume(){
        this.volume--;
    }

    protected String whatsPlaying(){
        return "Nothing to Play";
    }

    @Override
    public String toString() {
        return "MediaPlayer{" +
                "volume= " + volume +
                "\n" +
                whatsPlaying() +
                '}';
    }


}
