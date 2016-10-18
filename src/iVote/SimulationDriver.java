package iVote;
import java.util.Random;

public class SimulationDriver 
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		String[] choices = {"A", "B", "C", "D"};
		String question = "Which one is A?";
		String type = "single";
		String ans = "A";
		Student[] students = new Student[20];
		
		iVoteService ivs = new iVoteService(choices, question, type, ans);
		
		for(int i = 0 ; i < students.length; i++)
		{
			students[i] = new Student();
		}
		for(Student s : students)
		{
			ivs.takeAnswers(s, choices[rand.nextInt(4)]);
		}
		ivs.displayResults();
	}
}
