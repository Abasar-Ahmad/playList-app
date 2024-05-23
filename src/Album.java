import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String title;
    private String artist;
    private List<Song> song;

    //Constructor
    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.song=new ArrayList<>();
    }


    // Getter ans Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    // Find Song
    boolean FindSong(String title)
    {
        for(Song sg:song){
            if (sg.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    // Add Song to Album
    String addSongToAlbum(String title,double duration)
    {

        if(FindSong(title)==false)
        {
            Song s=new Song(title,duration);
            // name of the album is song
            song.add(s);
            return "Song is added";
        }
            return "song is allready present in album";
    }

    // add song to playlist
    String addSongToPlaylistFromAlbum(String title, List<Song>playList)
    {
        if(FindSong(title)==true)
        {
           for(Song s :this.song)
           {
               if(s.getTitle().equals(title)){
                   playList.add(s);
                   return "Song added to playlist";
               }
           }
        }
        return "Song is not exist in Album";
    }

    String addSongToPlaylistFromAlbum(int trackNo, List<Song>playList)
    {
        int index=trackNo-1;
        if(index>=0 && index<this.song.size())
        {
            playList.add(this.song.get(index));
            return "trackNo Song added";
        }
        return "You have entered wrong position";
    }
}
