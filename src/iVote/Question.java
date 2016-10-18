package iVote;

public class Question 
{
	private String[] choices = new String[0];
	private int[] answer = null;
	private String question = "";
	private String type;
	
	public Question(String[] c, int[] ans, String quest, String type)
	{
		choices = c;
		answer = ans;
		question = quest;
		this.type = type;
	}
	public String getAnswer()
	{
		String s = "";
		if(type.compareTo("multiple") == 0)
		{
			for(int i : answer)
			{
				s += choices[i];
			}
		}
		else
		{
			s = choices[0];
		}
		return s;
	}
	public void setAnswer(int[] ans)
	{
		answer = ans;
	}
	public String getType()
	{
		return type;
	}
	public String[] getChoices()
	{
		return choices;
	}
	public String getQuestion()
	{
		return question;
	}
	public void display()
	{
		System.out.println(question);
		for(String s : choices)
		{
			System.out.println(s);
		}
		
		
	}
}
