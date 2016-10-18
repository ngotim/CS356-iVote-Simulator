package iVote;

public class Question 
{
	String[] choices = new String[0];
	String answer = "";
	String question = "";
	
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
	public void display()
	{
		System.out.println(question);
		for(String s : choices)
		{
			System.out.println(s);
		}
		
	}
}
