/**A class that contains an entry of the vote data
* @author Siang Swee Kong
* @version 1.0.0
*/
public class Entry {
	private String candidateName; //store candidate name
	private int state; //store the state number
	private int vote; //store the number of vote for the candidate in the state

	/**A default constructor that takes no argument to initialize the field of the entry
	 */	
	public Entry() 
	{  
		candidateName = " "; 
		state = 0;
		vote = 0;
	}	

	/**A constructor that takes three arguments to initialize the attributes
	* @param name A parameter used to initialize the candidateName
	* @param stateNum A parameter used to initialize the state
	* @param numVote A parameter used to initialize the vote
	*/	
	public Entry(String name, int stateNum, int numVote) 
	 {  
		candidateName = name;
		 state = stateNum;
		 vote = numVote;
	 }

	/**A method to return the value of the candidateName field
	* @return the candidate name of the vote entry
	*/	
	public String getCandidateName()
	{
		return candidateName;
	}
	
	/**A method to return the value of the state field
	* @return the state number of the vote entry
	*/	
	public int getState()
	{
		return state;
	}
	
	/**A method to return the value of the vote field
	* @return the vote number of the vote entry
	*/	
	public int getVote()
	{
		return vote;
	}
	
	/**A method that prints out the vote entry information
	* @return the description of the vote entry that shows the number of votes win by the candidate in that state 
	*/	
	public String toString() 
	   {   
			return("Candidate: " + candidateName + "\nState: " + state + "\nVote: " + vote);
	   }

	/**A method that makes a deep copy of the entry
	* @return a deep copy of the node
	*/	
	public Entry deepCopy()
	   {  Entry dCopy = new Entry(candidateName, state, vote);
	      return dCopy;
	   }

	/**A method that compares the name of the candidate
	* @param keyName Specifying the name of the target candidate desired
	* @return an integer value to indicate if the candidate name of this entry is the same as the target candidate
	*/	
	public int compareTo(String keyName) 
	   {  
		return(candidateName.compareTo(keyName));
	   }

}

