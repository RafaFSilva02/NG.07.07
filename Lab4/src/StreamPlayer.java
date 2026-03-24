import java.util.ArrayList;
import java.util.List;

public class StreamPlayer extends MediaPlayer {
    private List<Podcast> podcastList;
    private Podcast currentPodcast;

    public StreamPlayer() {
        super();
        this.podcastList = new ArrayList<>();
    }

    public void setPodcastList(List<Podcast> podcastList) {
        this.podcastList = podcastList;
        if (!podcastList.isEmpty()) {
            this.currentPodcast = podcastList.get(0);
        }
    }

    @Override
    protected String whatsPlaying() {
        if (currentPodcast != null) {
            return "Stream Playing: " + currentPodcast.title;
        }
        return "Stream Playing: Nothing";
    }
}