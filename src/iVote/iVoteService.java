package iVote;

import java.util.ArrayList;

public class iVoteService 
{
	ArrayList<String> answered;
	int[] results;
	Question question;
	
	public iVoteService(String[] choices, String q, String qType, String ans)
	{
		answered = new ArrayList<String>();
		results = new int[choices.length];
		
		switch(qType.toLowerCase())
		{
		case "multiple":
			question = new MultipleChoiceQuestion(choices, ans, q);
			break;
		case "single":
			question = new SingleChoiceQuestion(choices, ans, q);
			break;
		}
	}
	public void takeAnswers(Student student)
	{
		if(!answered.contains(student.getID()))
		{
			
		}
		else
		{
			System.out.println("Student already answered!");
		}
	}
}
