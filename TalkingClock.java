import java.util.Scanner;

/*
 * [2017-06-27] Challenge #321 [Easy] Talking Clock
 * Description

No more hiding from your alarm clock! You've decided you want your computer to keep you updated on the time so you're never late again. A talking clock takes a 24-hour time and translates it into words.

Input Description

An hour (0-23) followed by a colon followed by the minute (0-59).

Output Description

The time in words, using 12-hour format followed by am or pm.

Sample Input data

00:00
01:30
12:05
14:01
20:29
21:00

Sample Output data

It's twelve am 
It's one thirty am 
It's twelve oh five pm 
It's two oh one pm 
It's eight twenty nine pm 
It's nine pm  

 */


public class TalkingClock 
{
	
	Scanner input = new Scanner(System.in);
	
	public static String userInput = null;


	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Current Time in (21:00) format");
		userInput = input.nextLine();
		System.out.println(splitter(userInput));
	}
	

	public static String splitter(String time)
	{
		//Varibles
		boolean pm = false;
		
		String t = time;
		String[] arr = t.split(":");
		String tensMinute=null;
		String[] onesMinute= {null,"one","two","three","four","five","six","seven","eight","nine"};
		String odds=null;
		String[] shour = {"twelve","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve"};
		String sminutes = null;
			
		int minutes = 0;
		int hour = 0;
		
		// Assign hour string to the int value
		hour = Integer.parseInt(arr[0]);
		
		// Convert time from 24 hours to 12 hours
		if(hour>=12)
		{
			pm=true;
			if(hour>12)	hour-=12; // Convert to normal
		}
		
		
		// Grabs minutes from String
		minutes = Integer.parseInt(arr[1]);
		
		// If minutes are more then two digits
		if (minutes>20)
		{
			
			
			int temp = minutes/10;
			if(temp==2) tensMinute = "Twenty";
			else if(temp==3) tensMinute = "Thirty";
			else if(temp==4) tensMinute = "Fourty";
			else if(temp==5) tensMinute = "Fifty";
			else tensMinute = "";
			
		}
		// Odd number like ten, eleven, twelve - teens
		if(minutes>=10&&minutes<20)
		{
			if(minutes==10) odds = "ten";
			if(minutes==11) odds = "eleven";
			if(minutes==12) odds = "twelve";
			if(minutes==13) odds = "thirteen";
			if(minutes==14) odds = "fourteen";
			if(minutes==15) odds = "fifhteen";
			if(minutes==16) odds = "sixteen";
			if(minutes==17) odds = "seventeen";
			if(minutes==18) odds = "eighteen";
			if(minutes==19) odds = "nineteen";
		}
		
		// Read the ones digit place
		if(minutes%10==0) onesMinute = null;
			
		// Format time
		String display = "";
		
		// Case 1: Minutes are between 10-19
		if(odds!=null)
		{
			display ="It's " + shour[hour] +" " + odds;
		}
		
		// Case 2: No minutes 5PM, 6PM, 7AM, ect.
		else if(tensMinute==null&&onesMinute==null)
		{
			display ="It's " + shour[hour];
		}
		
		// Case 3: Mintues are less then 10. 
		else if (tensMinute==null)
		{
			tensMinute = "Oh";
			display = shour[hour] + " " + tensMinute + "-" + onesMinute[minutes%10];
		}
		
		// Case 4: 2:30, 3:30, ect.
		else if(onesMinute==null)
		{
			display = shour[hour] + " " + tensMinute;
		}
		else
		{
			display = shour[hour] + " " + tensMinute + "-" + onesMinute[minutes%10];
		}
		
		// Add on AM or PM
		if(pm==false)
		{
			display +=" AM";
		}
			else display +=" PM";
		
		// Return Final formatted time
		return display;
	}	
}

