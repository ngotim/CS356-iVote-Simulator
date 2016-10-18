package iVote;

public class Question 
{
	private String[] choices = new String[0];
	private String answer = "";
	private String question = "";
	
	public Question(String[] c, String ans, String quest)
	{
		choices = c;
		answer = ans;
		question = quest;
	}
	
	public String getAnswer()
	{
		return answer;
	}
	public void setAnswer(String ans)
	{
		answer = ans;
	}
	public String[] getChoices()
	{
		return choices;
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
