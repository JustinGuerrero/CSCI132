public class Song {

    String Song;
    String Artist;

    public Song(String Songo, String Artisto) {
        this.Song = Songo;
        this.Artist = Artisto;


    }


    @Override
    public String toString(){

        String hereItIs = this.Song + "(" + this.Artist + ") , ";
        return hereItIs;
    }

}
