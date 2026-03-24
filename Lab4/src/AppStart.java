import java.util.ArrayList;
import java.util.List;

public class AppStart {
    public static void main(String[] args) {

        MediaPlayer p = new MediaPlayer();
        System.out.println(p);

        // Substitution principle with StreamPlayer
        StreamPlayer stream = new StreamPlayer();
        MediaPlayer p2 = stream;

        List<Podcast> podcasts = new ArrayList<>();
        podcasts.add(new Podcast("O Homem que Mordeu o cão"));
        podcasts.add(new Podcast("O CEO é o limite"));
        podcasts.add(new Podcast("Portugalex"));

        stream.setPodcastList(podcasts);

        System.out.println(p2.whatsPlaying());

        // Substitution principle with LiveRadioPlayer
        LiveRadioPlayer liveRadio = new LiveRadioPlayer();
        MediaPlayer p3 = liveRadio;

        List<Station> stations = new ArrayList<>();
        stations.add(new Station(88.3, "KFM"));
        stations.add(new Station(93.2, "RFM"));
        stations.add(new Station(95.7, "Antena 1"));
        stations.add(new Station(97.4, "Rádio Comercial"));
        stations.add(new Station(101.9, "Orbital"));

        liveRadio.setStationList(stations);

        p3.increaseVolume();
        p3.increaseVolume();
        p3.increaseVolume();

        System.out.println("Volume: " + p3.getVolume());
        System.out.println(p3.whatsPlaying());

        liveRadio.nextStation();
        System.out.println(p3.whatsPlaying());

        liveRadio.nextStation();
        System.out.println(p3.whatsPlaying());

        List<MediaPlayer> radios = new ArrayList<>();
        radios.add(p);
        radios.add(p2);
        radios.add(p3);

        System.out.println("---------------------");
        for(MediaPlayer m : radios){

            System.out.println(m.whatsPlaying());
        }
        System.out.println("---------------------");
    }
}