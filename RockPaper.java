
package com.rockpaper;

import java.util.Random;
import java.util.Scanner;

public class RockPaper {

	public static void main(String[] args) {
		
		//Get user input
		//get random number
		//Win condition Decide Whose win
		//play again?
		//goodByeee
		
		System.out.println("Welcome to Rock Paper Scissor Game Play with COMPUTER"
				+"\nRules of  this Game:- "+
				"\n"+
				"\nPress 1 for Rock"+
				"\nPress 2 for Paper"+
				"\nPress 3 for Scissor");
		rock();
	}
			
		//Win Condition checking
		public static void rock() {
			Scanner sc=new Scanner(System.in);
		int playerPoints=0;
		int computerPoints=0;
		
		boolean status=true;
		int i=1;
		
		while(status && i<=3){
			System.out.println();
			System.out.println("---------Match "+i+"-------");
			//User input
			
			System.out.println("Your play");
			int userNumber=sc.nextInt();
			
			//Computer input
			
			Random random=new Random();
			int computer=random.nextInt(1,4);
			System.out.println("Computer play");
									
			if(userNumber==1 && computer==1 || userNumber==2 && computer==2 || userNumber==3 &&  computer==3 ) 
			{
				System.out.println("Draw");
				
			}else if(userNumber==1 && computer==2) {
				
				System.out.println("You choose: Rock");
				System.out.println("Computer choose: Paper");
				System.out.println("You Lose :((");
				computerPoints++;
				
			}else if(userNumber==2 && computer==3) {
				
				System.out.println("You choose: Paper");
				System.out.println("Computer choose: Scissor");
				System.out.println("You Lose :((");
				computerPoints++;
				
			}else if(userNumber==3 && computer==1) {
				
				System.out.println("You choose: Scissor");
				System.out.println("Computer choose: Rock");
				System.out.println("You Lose :((");
				computerPoints++;
				
			}else if(computer==1 && userNumber==2) {
				
				System.out.println("computer choose: Rock");
				System.out.println("You choose: Paper"); 
				System.out.println("You Win :))");
				playerPoints++;
				
			}else if(computer==2 && userNumber==3) {
				
				
				System.out.println("computer choose: paper");
				System.out.println("You choose: Scissor");
				System.out.println("You Win :))");
				playerPoints++;
				
			}else if(computer==3 && userNumber==1) {
				
				System.out.println("computer choose: Scissor");
				System.out.println("You choose: Rock");
				System.out.println("You Win :))");
				playerPoints++;
				
			}else if(userNumber>3) {
				
				System.out.println("Invaild Choice Please Choose above Options\n"
						+ "Try Again");
				status=false;
			}
			
			i++;
			
		}
		
		System.out.println();
		System.out.println("Player Points : "+playerPoints);
		System.out.println("Computer Points : "+computerPoints);
		System.out.println();
		if(playerPoints>computerPoints) 
		{
			System.out.println("Congrats Buddy You WIN :)");
		}else if(computerPoints>playerPoints) 
		{
			System.out.println("Unfortunately You Lose Try Again :(");
		}else {
			System.out.println("Match has Draw Play Again ");
		}
		
		System.out.println();
		System.out.println("Do You want play Again y/n?");
		char ch=sc.next().charAt(0);
		if(ch=='y' || ch=='Y') 
		{
			status=true;
			i=1;
			rock();
		}else {
			status=false;
			System.out.println("Thanks for playing Visit Again :-)");
		}
		
		}		
	}


