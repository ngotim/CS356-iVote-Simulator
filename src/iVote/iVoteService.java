package iVote;

import java.util.ArrayList;
import java.util.HashMap;

public class iVoteService 
{
	private ArrayList<String> answered;
	private int[] results;
	private String[] choices;
	private Question question;
	private HashMap<String, String> hm;
	
	public iVoteService(String[] choices, String q, String qType, int[] ans)
	{
		answered = new ArrayList<String>();
		this.choices = choices;
		results = new int[choices.length];
		hm = new HashMap();
		
		question = new Question(choices, ans, q, qType);
		question.display();
	}
	//Puts in a new question for the service based on the arguements passed in.
	public void changeQuestions(String[] choices, String q, String qType, int[] ans)
	{
		answered = new ArrayList<String>();
		this.choices = choices;
		results = new int[this.choices.length];
		hm.clear();
		
		question = new Question(choices, ans, q, qType);
		question.display();
	}
	//Takes answers from students and puts them in a hashmap to keep track of who answered what.
	public void takeAnswers(Student student, String ans)
	{
		if(!hm.containsKey(student.getID()))
		{
			hm.put(student.getID(), ans);
			int i;
			if(question.getType().equals("multiple"))
			{
				String[] split = ans.split("\\s+");
				for(i = 0;i < split.length; i++)
				{
					results[getChoiceIndex(split[i])]++;
				}
			}
			else
			{
				for(i = 0;i < choices.length; i++)
				{
					if(choices[i].equals(ans))
					{
						break;
					}
				}
				results[i]++;
			}
		}
		else
		{
			hm.replace(student.getID(), ans);
		}
	}
	public String[] getChoices()
	{
		return choices;
	}
	public int getChoiceIndex(String s)
	{
		for(int i = 0; i < choices.length; i++)
		{
			if(choices[i].compareTo(s) == 0)
				return i;
		}
		return -1;
	}
	public void displayStudentResults()
	{
		for(String s : hm.keySet())
		{
			System.out.println(s + " - " + hm.get(s));
		}
	}
	public Question getQuestion()
	{
		return question;
	}
	public void displayResults()
	{
		for(int i = 0; i < choices.length; i++)
		{
			System.out.println(choices[i] + " : " + results[i]);
		}
		System.out.println("Answer : " + question.getAnswer());
		displayStudentResults();
	}
}
