package iVote;

import java.util.ArrayList;
import java.util.HashMap;

public class iVoteService 
{
	ArrayList<String> answered;
	int[] results;
	String[] choices;
	Question question;
	HashMap hm;
	
	public iVoteService(String[] choices, String q, String qType, String ans)
	{
		answered = new ArrayList<String>();
		results = new int[choices.length];
		this.choices = choices;
		hm = new HashMap();
		switch(qType.toLowerCase())
		{
		case "multiple":
			question = new MultipleChoiceQuestion(choices, ans, q);
			break;
		case "single":
			question = new SingleChoiceQuestion(choices, ans, q);
			break;
		}
		question.display();
	}
	public void takeAnswers(Student student, String ans)
	{
		if(!answered.contains(student.getID()))
		{
			answered.add(student.getID());
			hm.put(student, ans);
			int i;
			for(i = 0;i < choices.length; i++)
			{
				if(choices[i].equals(ans))
				{
					break;
				}
			}
			results[i]++;
		}
		else
		{
			hm.replace(student, ans);
		}
	}
	public void displayResults()
	{
		for(int i = 0; i < choices.length; i++)
		{
			System.out.println(choices[i] + " : " + results[i]);
		}
	}
}
