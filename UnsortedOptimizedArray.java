/**Class demonstrating the four basic operation methods (insert, fetch, delete, and update) on an unsorted-optimized array data structure.
 * This class is used to store all the vote entries and count the vote
* @author Siang Swee Kong
* @version 1.0.0
*/
public class UnsortedOptimizedArray {
		private int next; //store the index of the next inserted node 
	    private int arraySize; //store the size of the array
	    private Entry[] data; //create an array that contains instances of Entry object
	    
	    /**A constructor that takes one argument to create an array with the given size that contains Entry objects
		* @param numNodes A parameter used to initialize the arraySize field
		*/	
	    public UnsortedOptimizedArray(int numNodes) 
	    {  next = 0;
	       arraySize = numNodes;
	       data = new Entry[numNodes];
	     } 
	    
	    /**A method that is used to insert a new Entry object into the unsorted-optimized array and tell the user if the insertion was successful
		* @param newEntry Specifying the new entry desired to be inserted into the data structure
		* @return false if the insertion was not successful
		* @return true if the insertion was successful
		*/	
	     public boolean insert(Entry newEntry) 
	     {  if(next == arraySize)  //if the array is full
	            return false;
	     	else      //array is not full
	         {
	     		data[next]= newEntry.deepCopy( );  // store a deep copy of the node inserted, newEntry 
	     		next = next + 1; // prepare for the next insert
	     		return true; //indicates the entry was inserted 
	         }
	     }

	    /**A method that is used to retrieve information of the vote entry
	 	* @param key Specifying the entry with given key to be retrieved from the data structure
	 	* @return null if the key is not in the data structure
	 	* @return the description of the vote entry that shows the number of votes win by the candidate in that state 
	 	*/	
	     public Entry fetch(String key) {  
	    	 Entry targetEntry;
	    	 Entry temp;
	    	 //searching through the node using a sequential search
	         int index = 0;
	         while ( index < next && !(data[index].compareTo(key) == 0))
	         {  
	        	 index++;
	         }
	       
	         if(index == next) { //if the entry is not found
	           return null;
	         }
	         //otherwise, deep copy the entry information and return the entry
	         	else if(index == 0) {   //if the target student is the first element in the array, there is no swapping
	         		targetEntry = data[index].deepCopy( );
	         	}
	         		else
	         		{    // move the node up one position in the array                               
	         			targetEntry = data[index].deepCopy( );
	             		temp = data[index-1];
	             		data[index-1] = data[index];
	             		data[index] = temp;
	         		}
	         
	         return targetEntry;
	     } 

	     /**A method that is used to delete a vote entry
		 * @param key Specifying the entry with given key to be deleted from the data structure
		 * @return false if the key is not in the data structure
		 * @return true if the key is successfully deleted from the data structure
		 */	
	     public boolean delete(String key) 
	     {	 //searching through the entry using a sequential search
	         int index = 0;
	         while (index < next && !(data[index].compareTo(key) == 0))
	         {   
	        	 index++;
	         }
	        
	         if(index == next) { //if the entry is not found
	             return false;
	         }
	       
	         	else { //entry was found and delete the node 
			         data[index] = data[next -1]; //move the last entry into the deleted entry's position
			         data[next-1] = null; 
			         next = next - 1; //move up the next position by one
			         return true; 
	         	} 
	         
	     }

	     /**A method that is used to update a vote entry
		 * @param key Specifying the entry with desired key to be updated from the data structure
		 * @param newEntry Specifying the new Entry to replace the desired entry
		 * @return false if the entry with target key is not in the data structure
		 * @return true if entry with the target key is successfully updated from the data structure
		 */	
	      public boolean update(String key, Entry newEntry)
	      {  
	    	  if(delete(key) == false)  // if the entry cannot be found 
	    		  return false;
	    	  else if( insert(newEntry) == false)  //insufficient memory
	    		  return false;
	    	  else
	    	  {
	    		  return true;  // entry found and updated
	    	  }
	      }
	      
	      /**A method that is used to count and set the votes win by the candidate for each state
		  * @param targetCandidate Specifying the target candidate desired
		  */	
	      public void countAndSetVote(Candidate targetCandidate)
	  	  {
	    	//initialize the votes for each state to 0 before counting
	    	   int vote1 = 0; 	//store number of votes in state 1
	           int vote2 = 0;	//store number of votes in state 2
	           int vote3 = 0;	//store number of votes in state 3
	           int vote4 = 0;	//store number of votes in state 4
	           int size = data.length;
	           for(int index = 0; index < size; index++)
	           { //calculate total votes win in each state by the candidate
	        	   if(data[index].getCandidateName().compareTo(targetCandidate.getCandidate()) == 0)
	        	   {
	        		   if (data[index].getState() == 1)
	        		   {
	        			  vote1 += data[index].getVote();
	        		   }
	        		   else if (data[index].getState() == 2)
	        		   {
	        			   vote2 += data[index].getVote();
	        		   }
	        		   else if (data[index].getState() == 3)
	        		   {
	        			   vote3 += data[index].getVote();
	        		   }
	        		   else if (data[index].getState() == 4)
	        		   {
	        			   vote4 += data[index].getVote();
	        		   }
	        	   }
	           }
	           targetCandidate.setVoteToAllState(vote1, vote2, vote3, vote4); //set the values of the attributes for the candidate with calculated total votes win in each state by the candidate
	  	}   
	    
	      
	    
	    /**A method that is used to display all the entry information in the unsorted-optimized array data structure
	  	* @return the description of the vote entry that shows the number of votes win for the candidate in that state for all the entries existed in the data structure
	  	*/	
	    public void displayAll()
	    {
	    	for(int index = 0; index < arraySize; index++)
	    	{
	    		System.out.println(data[index].toString());
	    	}
	    }
	     
}
