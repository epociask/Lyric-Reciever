import java.util.ArrayList;
import java.io;

public class LyricGetter extends WebReader{

	private GUI ui = new GUI();
	private ArrayList<String> unSortedLyrics = new ArrayList<>();




	public LyricGetter(){


}
	


	public String geniusLyrics(String songName, String author){

		 String ref = "<div class="+"\"lyrics\"" + ">";
		 String refinedLyrics = "";



		author = author.substring(0,1).toUpperCase() + author.substring(1).toLowerCase().replace(" ", "-");
		
		String urlFormat = "https://genius.com/" + author + "-" + songName.toLowerCase().replace(" ", "-") + "-lyrics";

		String endRef = "<!--/sse-->";


	try{
		String html = get(urlFormat);

	}catch(Exception e){

		return null;
	}

		String html = get(urlFormat);

		if(html.contains(ref) && html.contains(endRef)){
		html = html.replace(html.substring(0, html.indexOf(ref)), "");
		html = html.replace(html.substring(html.lastIndexOf(endRef)), ""); 
	}

		String[] lyrics = html.split(">");



		for(int i = 0; i < lyrics.length; i++){
			unSortedLyrics.add(lyrics[i]);
		}


		for(int i = 0; i < unSortedLyrics.size(); i++){

			if(unSortedLyrics.get(i).contains("<a")){
				unSortedLyrics.remove(i);


		}else{

			refinedLyrics += unSortedLyrics.get(i);
		}

	}

	String [] newLyrics = refinedLyrics.split("<br");

	String finale = newLyrics[0].substring(newLyrics[0].indexOf("<p")+2);


	ArrayList<String> otherList = new ArrayList<>();

	otherList.add(finale);

	for(int i = 1; i < newLyrics.length; i++){

		otherList.add(newLyrics[i]);
	}

	String k = otherList.get(otherList.size()-1).replace("</p", "");
	otherList.remove(otherList.size()-1);
	otherList.add(k);



		String returnString = "";

		for(String s : otherList){
			if(s.contains("</a")){
				s = s.replace("</a", "");
			}

			if(s.contains("<i")){
				s = s.replace("<i", "");
			}

			if(s.contains("</i")){
				s = s.replace("</i", "");
			}

			if(s.contains("<p")){
				s = s.replace(s.substring(s.indexOf("</p"), s.indexOf("<p")+2), "");
			}

		

			returnString += s +"\n";
		}

		return returnString;
	}






	public static void main(String[] args){



	}
}