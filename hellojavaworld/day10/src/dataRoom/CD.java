package dataRoom;

import java.util.Objects;

public class CD extends Item {

    private String artist;
    private int numofTracks;


    public CD(String title, String artist,
              int numofTracks, int playingTime,
              boolean gotIt,String comment) {
        super(title,playingTime,false,comment);
        this.numofTracks = numofTracks;
        this.artist = artist;

    }

    @Override
    public String toString() {
        System.out.println( "CD{" +
                "artist='" + artist + '\'' +
                '}');
        return "CD{" +
                "artist='" + artist + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CD)) return false;
        CD cd = (CD) o;
        return artist.equals(cd.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist);
    }

    public void print() {
        System.out.println("CD:");
        super.print();
        System.out.println(artist);
    }
    //CD和DVD会Item得到继承
    public static void main(String[] args){
        CD cd = new CD("xx","yy",2,1,true,"good");
        CD cd1 = new CD("12","yyy",8,1,true,"not good");
        //cd.print();
        cd.toString();
        System.out.println(cd.equals(cd1));
    }
}
