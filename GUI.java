import java.util.Scanner;

public class GUI{

	Scanner inDevice;
	

	public GUI(){

		inDevice = new Scanner(System.in);

	}


	public void display(String text){
		System.out.println(text);
	}

	public String getStringInput(){

		String x = inDevice.nextLine();

		return x;
	}

	public void displayMenu(){

		display("Welcome to the lyric reciever!");
	
	}
}