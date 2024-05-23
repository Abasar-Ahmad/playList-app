import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Album album1=new Album("udd gye" ,"king khan");
        album1.addSongToAlbum("song1" ,4.4);
        album1.addSongToAlbum("song2" ,2);
        album1.addSongToAlbum("song3" ,5);
        album1.addSongToAlbum("song4" ,9);


        Album album2=new Album("MuseWala" ,"Muse");
        album2.addSongToAlbum("s1" ,1);
        album2.addSongToAlbum("s2" ,3);
        album2.addSongToAlbum("s3" ,4);
        album2.addSongToAlbum("s4" ,6);

        List<Song> myPlayList=new LinkedList<>();
        System.out.println(album2.addSongToPlaylistFromAlbum("s3",myPlayList));
        System.out.println(album2.addSongToPlaylistFromAlbum("s2",myPlayList));
        System.out.println(album1.addSongToPlaylistFromAlbum(2,myPlayList));

        play(myPlayList);
    }
    public static void play(List<Song> playList)
    {
        // ListIterator is inbuild types of who manage next and previos
        ListIterator<Song> itr=playList.listIterator();
        if(playList.size()==0)
        {
            System.out.println("PlayList is empty");
            return;
        }
        boolean isNext; // ye check karne ke liye hai ki abhi  next dabaya tha ya previous
        System.out.println("currently playing");
        System.out.println(itr.next());
        isNext=true;
        Scanner sc=new Scanner(System.in);
        printMenu();
        while(true)
        {
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    // case1 is play next song
                    // previous ke baad next karna hota hai tab do baar next karna padega
                    if(!isNext){
                       itr.next();
                       isNext=true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now playing");
                        System.out.println(itr.next());
                        isNext=true;
                    }
                    else{
                        System.out.println("you have reached the end of list");
                    }
                    break;
                case 2:// play previous song
                    // next ke baad previous karna hota hai tab do baar next karna padega

                    if(isNext){
                        itr.previous();
                        isNext=false;
                    }
                    if (itr.hasPrevious())
                    {
                        System.out.println("Now playing");
                        System.out.println(itr.previous());
                        isNext=false;
                    }
                    else System.out.println("you are already in first song");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:printAllSongs(playList );
                    break;
                case 6: printMenu();
                    break;
                case 7: // exist
                    return;
            }
        }
    }
// for case 5 , show all songs
    static void printAllSongs(List<Song>playList)
    {
        for (Song sg:playList)
        {
            System.out.println(sg);
        }
    }


    // for case 6
    static void printMenu()
    {
        System.out.println("1. play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Play current song again");
        System.out.println("4. Delete current song");
        System.out.println("5. 'Show all songs");
        System.out.println("6. Show menu again");
        System.out.println("7. Exit");
    }
}