import java.util.ArrayList;
import java.util.List;

public class LiveRadioPlayer extends MediaPlayer {
    private List<Station> stationList;
    private Station currentStation;

    public LiveRadioPlayer() {
        super();
        this.stationList = new ArrayList<>();
    }

    @Override
    protected String whatsPlaying() {
        if (currentStation != null) {
            return "Live Radio Player: " + currentStation.frequency + " - " + currentStation.name;
        }
        return "Live Radio Player: No station selected";
    }

    protected void nextStation() {
        if (stationList.isEmpty()) return;

        int currentIndex = stationList.indexOf(currentStation);
        if (currentIndex < stationList.size() - 1) {
            currentStation = stationList.get(currentIndex + 1);
        } else {
            currentStation = stationList.get(0);
        }
    }

    protected void prevStation() {
        if (stationList.isEmpty()) return;

        int currentIndex = stationList.indexOf(currentStation);
        if (currentIndex > 0) {
            currentStation = stationList.get(currentIndex - 1);
        } else {
            currentStation = stationList.get(stationList.size() - 1);
        }
    }

    protected void setStationList(List<Station> stationList) {
        this.stationList = stationList;
        if (!stationList.isEmpty()) {
            this.currentStation = stationList.get(0);
        }
    }
}