/**A class that contains the vote results in each state for a candidate
* @author Siang Swee Kong
* @version 1.0.0
*/
public class Candidate {
	private String candidate; //store the name of the candidate
	private int voteState1;//store the number of votes win in state 1
	private int voteState2;//store the number of votes win in state 2
	private int voteState3;//store the number of votes win in state 3
	private int voteState4;//store the number of votes win in state 4

	/**A default constructor that takes no argument to initialize the attributes
	 */	
	public Candidate()
	{  
		candidate = "";
		voteState1 = 0;
		voteState2 = 0;
		voteState3 = 0;
		voteState4 = 0;
	}

	/**A constructor that takes one argument to initialize the attributes
	* @param name A parameter used to initialize the name of the candidate
	*/	
	public Candidate(String name)
	{  
		candidate = name;
		voteState1 = 0;
		voteState2 = 0;
		voteState3 = 0;
		voteState4 = 0;
	}

	/**A constructor that takes five arguments to initialize the attributes
	* @param name A parameter used to initialize the name of the candidate
	* @param vote1 A parameter used to initialize the vote results win by the candidate in state 1
	* @param vote2 A parameter used to initialize the vote results win by the candidate in state 2
	* @param vote3 A parameter used to initialize the vote results win by the candidate in state 3
	* @param vote4 A parameter used to initialize the vote results win by the candidate in state 4
	*/	
	public Candidate(String name,int vote1, int vote2, int vote3, int vote4)
	{  
		candidate = name;
		voteState1 = vote1;
		voteState2 = vote2;
		voteState3 = vote3;
		voteState4 = vote4;
	}

	/**A method to set the value of the field voteState1, voteState2, voteState3, voteState4
	* @param vote1 A parameter used to set the vote results win by the candidate in state 1
	* @param vote2 A parameter used to set the vote results win by the candidate in state 2
	* @param vote3 A parameter used to set the vote results win by the candidate in state 3
	* @param vote4 A parameter used to set the vote results win by the candidate in state 4
	*/	
	public void setVoteToAllState(int vote1, int vote2, int vote3, int vote4)
	{  
		voteState1 = vote1;
		voteState2 = vote2;
		voteState3 = vote3;
		voteState4 = vote4;
	}

	/**A method to set the votes of a candidate for a particular state.
	* @param stateNum Specifying the state desired
	* @param numVotes Specifying the number of votes desired 
	*/	
	public void setVoteToOneState(int stateNum, int numVotes)
	{
		if (stateNum == 1)
		{
			voteState1 = numVotes;
		}
		else if (stateNum == 2)
		{
			voteState2 = numVotes;
		}
		else if (stateNum == 3)
		{
			voteState3 = numVotes;
		}
		else if (stateNum == 4)
		{
			voteState4 = numVotes;
		}
	}

	/**A method to update the votes of a candidate for a particular state by adding the votes to the state 
	* @param stateNum Specifying the state desired
	* @param numVotes Specifying the number of votes desired to be added
	*/	
	public void updateVoteByState(int stateNum, int numVotes)
	{
		if (stateNum == 1)
		{
			voteState1 += numVotes;
		}
		else if (stateNum == 2)
		{
			voteState2 += numVotes;
		}
		else if (stateNum == 3)
		{
			voteState3 += numVotes;
		}
		else if (stateNum == 4)
		{
			voteState4 += numVotes;
		}
	}
	
	/**A method to determine if two candidates have the same name.
	* @param otherCandidate Specifying the other candidate desired to be compared
	* @return true if the name of two candidates are the same
	* @return false if the name of two candidates are different
	*/	
	public boolean isSameCandidate(Candidate otherCandidate)
	{
		if(candidate.equals(otherCandidate.getCandidate()))
		{
			return true;
		}
		else
			return false;
	}

	/**A method to return the value of the candidate field
	* @return the candidate name
	*/	
	public String getCandidate()
	{
		return candidate;
	}

	/**A method to return the value of the total vote by combining all the state votes 
	* @return the total vote win by the candidate
	*/	
	public int getTotalVote()
	{
		return voteState1 + voteState2 + voteState3 + voteState4;
	}

	/**A method that prints out the candidate vote results information
	* @return the number of votes win from each state and the total vote for the candidate
	*/	
	public String toString() 
	   {   
		return("Candidate name: " + candidate + "\nVote from state 1: " + voteState1 + "\nVote from state 2: " + voteState2 + 
				"\nVote from state 3: "+ voteState3 + "\nVote from state 4: " + voteState4 + "\nTotal vote: " + getTotalVote() + "\n" );
	   }
	

	/**A method that compares the name of the candidate with a String variable as the parameter
	* @param key Specifying the name of the candidate desired
	* @return an integer value to indicate if the candidate name is the same as the key value
	*/	
	public int compareToByName(String key)
	   {  
			return(candidate.compareTo(key));
	   }
	
	/**A method that compares two candidates object with a Candidate object as the parameter
	* @param key Specifying the name of the candidate desired
	* @return an integer value to indicate if two candidates are the same
	*/	
	public int compareToByCandidate(Candidate otherCandidate) //a method that is used to compare the key field
	   {  
			return(candidate.compareTo(otherCandidate.getCandidate()));
	   }


	/**A method that makes a deep copy of the candidate
	* @return a deep copy of the node
	*/	
	public Candidate deepCopy()
	   {  Candidate dCopy = new Candidate(candidate,voteState1,voteState2,voteState3,voteState4);
	      return dCopy;
	   }
	
}
