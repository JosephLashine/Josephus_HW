
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Scanner;
	import java.io.BufferedReader;
public class josephusTester {
	
	/**
	* @Author Joseph Lashine, Austin Chiu, and Ryan Steup
	* Josephus Game Version 1.0
	*/
	

		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			  int players;
			  int passes;
			  int startNum;
		        Josephus Players = new Josephus();  // make list
	              Scanner console = new Scanner(System.in);	       
	              System.out.println("Enter the number of players: ");
		        players = console.nextInt();

		        for(int j=players; j>0; j--)          
		           Players.add(j);

		        System.out.println("The players left in the game: ");
		        Players.display();

		        System.out.println("Enter the number of passes of the potato: ");
		        passes = console.nextInt();

		        System.out.println("Enter the starting player's number: ");
		        startNum =console.nextInt();


		       
		        int m = 1;
		        int n;
		        while(m != startNum) // while m does not equal the starting players number
		        {
		          Players.step(); // Move to current link of Josephus
		          m++; // implement by one to see whole list ofm  Josephus
		        }
		        System.out.println("Players: ");
		        Players.display(); //Displays the current players 
		        while(Players.getSize() > 1){ // while the size of the Josephus is greater than one
		            n = 0;
		            while(n != passes){ //While n does not equal the number of passes
		                Players.step();// 
		                n++;
		            }
		          Players.remove().display(); // Removes the josephus that was eliminated and displays the result.  
		            System.out.println("The numbers still in the game is");
		            
		           Players.display(); //Display the Josephus every round
		        }

		}
	}


