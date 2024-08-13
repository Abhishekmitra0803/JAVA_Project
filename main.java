package abhi.com;

import java.util.*;
public class main {

private static ArrayList<album> albums =new ArrayList<> ();

	public static void main(String[] args) {
		
		String artist;
		String name;
		album album=new album(name="Album1",artist="Darshan Raval");
		
		double duration;
		String title;
		album.addsong(title="sab tum ho ",duration=4.3);
		album.addsong(title="kash aisa hota ",duration=4.7);
		album.addsong(title="asal me ",duration=4.9);
		album.addsong(title="bhula dia ",duration=5.0);
		albums.add(album);
		
		album=new album(name="Album2",artist="Mitraz");
		
		album.addsong(title="akhiyaan ",duration=4.2);
		album.addsong(title="junoon ",duration=4.4);
		album.addsong(title="kabhi na kabhi ",duration=4.6);
		album.addsong(title="taara tuteya ",duration=4.0);
		albums.add(album);
		
		LinkedList<song> playList_1=new LinkedList<>();
		
		albums.get(0).addtoplaylist(title="sab tum ho ",playList_1);
		albums.get(0).addtoplaylist(title="kash aisa hota ",playList_1);
		albums.get(1).addtoplaylist(title="junoon ",playList_1);
		albums.get(1).addtoplaylist(title="kabhi na kabhi ",playList_1);
		
		play(playList_1);
			
	}
	private static void play(LinkedList<song> playlist) {
	Scanner sc=new Scanner (System.in)	;
	boolean quit =false;
	boolean forward=true;
	ListIterator<song> listiterator = playlist.listIterator();
	
	if(playlist.size()==0) {
		System.out.println("this playlist have no songs");
		
	}
	else {
		System.out.println("now playing"+listiterator.next().toString());
		printmenu();
	}
	while(!quit) {
		int action =sc.nextInt();
		sc.nextInt();
		 
		switch (action) {
		
		case 0:
			System.out.println("playlist complete");
			quit=true;
			break;
			
		case 1:
			if(!forward) {
				if(listiterator.hasNext()) {
					listiterator.next();
				}
				forward = true;
		  }
			if (listiterator.hasNext()) {
				System.out.println("now playing" +listiterator.next().toString());
			}
			else {
				System.out.println("no song available,reached to the end of the list");
				forward=false;
			}
			break;
		case 2:
			if(forward) {
				if (listiterator.hasPrevious()) {
					listiterator.previous();
				}
				forward =false;
			}
			if(listiterator.hasPrevious()) {
				System.out.println("now playing"+listiterator.previous().toString());
				
			}
			else {
				System.out.println("we are the first song");
				forward=false;
			}
			break;
			
		case 3:
			if(forward) {
				if(listiterator.hasPrevious()) {
					System.out.println("now playing"+listiterator.previous().toString());
					forward=false;
				}else {
					System.out.println("we are at the start of the list");
					
				}
			}else {
				if(listiterator.hasNext()){
					System.out.println("now playing"+listiterator.previous().toString());
					forward=true;
				}else {
					System.out.println("we have reached tothe end of the list");
				}
			}
			break;
			
			case 4:
				printList(playlist);
				break;
				
			case 5:
				printmenu();
				break;
			case 6:
				if (playlist.size()>0) {
					listiterator.remove();
					if(listiterator.hasNext()) {
					System.out.println("now playing"+listiterator.previous().toString());	
					
					}
					else {
						if(listiterator.hasPrevious())
						System.out.println("now playing"+listiterator.previous().toString());
					}
				}
			
	    }
	  }
	}
	private static void printmenu() {
		System.out.println("Available options\n press");
		System.out.println("0 - to quit\n"+
		"1 - to play next song\n"+
				"2 - to play previous song\n"+
		"3 - to replay the current song\n"+
				"4 - list of all songs\n"+
		"5 - print all available options\n"+
				"6 - delete current song");
	}
	
	private static void printList(LinkedList<song>playlist) {
		Iterator<song> iterator = playlist.iterator();
		System.out.println("-----------------------");
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
		System.out.println("----------------------");
	}
}

