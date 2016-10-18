package iVote;
import java.util.Random;
import java.util.Scanner;

public class SimulationDriver 
{
	static iVoteService ivs;
	static Student[] students;
	static Random rand = new Random();
	static int curr;
	
	public static void main(String[] args)
	{
		String[] choices = {"A", "B", "C", "D"};
		String question = "Which one is AC?";
		String type = "multiple";
		int[] ans = {0, 2};
		students = new Student[20];
		boolean quit = false;
		Scanner sc = new Scanner(System.in);
		curr = 0;
		
		ivs = new iVoteService(choices, question, type, ans);
		while(!quit)
		{
			runSim();
			System.out.print("Quit?(y/n): ");
			switch(sc.next().toLowerCase())
			{
			case "y":
				quit= true;
				break;
			case "n":
				changeQuestion();
				break;
			default:
				System.out.println("Invalid choice, continuing...");
			}
			
		}
	}
	public static void changeQuestion()
	{
		String question;
		String type;

		if(curr == 0)
		{
			String[] choices = {"1. Right", "2. Wrong"};
			question = "Does OOP mean object oriented programming?";
			type = "single";
			int[] ans = {0};
			ivs.changeQuestions(choices, question, type, ans);
			curr = 1;
		}
		else
		{
			String[] choices = {"A", "B", "C", "D"};
			question = "Which one is AC?";
			type = "multiple";
			int[] ans = {0, 2};	
			ivs.changeQuestions(choices, question, type, ans);
			curr = 0;
		}
	}
	public static void runSim()
	{
		for(int i = 0 ; i < students.length; i++)
		{
			students[i] = new Student();
		}
		String[] c = ivs.getChoices();
		for(Student s : students)
		{
			if(ivs.getQuestion().getType() == "multiple")
				ivs.takeAnswers(s, c[rand.nextInt(c.length)] + " " + c[rand.nextInt(c.length)]);
			else
				ivs.takeAnswers(s, c[rand.nextInt(c.length)]);
		}
		ivs.displayResults();
	}
}
