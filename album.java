package abhi.com;
import java .util.*;
public class album {
private String name;
private String artist;
private ArrayList<song> songs;

public album(String name,String artist) {
	this.name=name;
	this.artist=artist;
	this.songs=new ArrayList<song>();
}
public album() {
	
	
}
public song findsong(String title) {
	for(song checkedsong:songs) {
		if(checkedsong.getTitle().equals(title))return checkedsong;
	}
	return null;
}
public boolean addsong(String title,double duration) {
	if(findsong(title)==null) {
		songs.add (new song(title,duration));
		System.out.println(title +"successfully added to the list");
		return true;
	}
	else {
		System.out.println("song with name"+title+"already exist in the list");
		return false;
	}
}

public boolean addtoplaylist(int tracknumber,LinkedList<song>playlist) {
	int index=tracknumber-1;
	if(index > 0 && index<=this.songs.size()) {
		playlist.add(this.songs.get(index));
		return true;
	}
	System.out.println("thisalbum does not ahve song with tracknumber"+tracknumber);
	return false;
}
public boolean addtoplaylist(String title,LinkedList<song>playlist) {
	for(song checkedSong:this.songs) {
		if(checkedSong.getTitle().equals(title)){
		playlist.add(checkedSong);
		return true;
		}
	}
	System.out.println(title+ "there is no such song in album");
	return false;
}
}
