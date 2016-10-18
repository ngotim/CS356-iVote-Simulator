package iVote;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;


public class Student 
{
	private static AtomicLong idCounter = new AtomicLong();
	private String studentID;
	public Student()
	{
		generateID();
	}
	
	public String getID()
	{
		return studentID;
	}
	public void setID(String ID)
	{
		studentID = ID;
	}
	public void generateID()
	{
		studentID = String.format("%05d", idCounter.getAndIncrement());
	}

}
