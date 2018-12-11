public class LyricRecieverMain{

	private static GUI ui = new GUI();
	private static LyricGetter reciever = new LyricGetter();



	public static void main(String[] args){

		boolean x = true;


		ui.displayMenu();

		while(x){


		ui.display("Artist's name: ");

		String artist = ui.getStringInput();

		ui.display("Song: ");
		String song = ui.getStringInput();

		if(reciever.geniusLyrics(song, artist) != null){
		ui.display(reciever.geniusLyrics(song, artist));

	}else{

		ui.display("COULD NOT BE FOUND");
	}



	}

}
	

}