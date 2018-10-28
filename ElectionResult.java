/**A class that contains several methods to process the vote data for presidential election.
* @author Siang Swee Kong
* @version 1.0.0
*/
public class ElectionResult {
	/**A method to sort a list of candidates in ascending order by comparing the name
	* @param list Specifying the list of Candidate object desired
	* @param leftIndex Specifying the lowest index desired
	* @param rightIndex Specifying the highest index desired
	*/	
	public static void quickSort(Candidate[] list,int leftIndex, int rightIndex)
	  { int i, j,partitionSize;
	  	partitionSize = rightIndex - leftIndex +1;
	    if(partitionSize <= 1) // base case, one item to be sorted
	      return;

	    Candidate pivotValue,temp;
	    pivotValue = list[(leftIndex + rightIndex) / 2];
	    i = leftIndex; // initialize the two partition indices
	    j = rightIndex;

	    do
	    {  while (list[i].compareToByCandidate(pivotValue) < 0) // left partition item is in the correct partition
	          i++;
	       while (list[j].compareToByCandidate(pivotValue) > 0) // right partition item is in the correct partition
	          j--;
	       if (i<=j) // pointers have not crossed, switch items in wrong partition
	       {  temp = list[i];    list[i] = list[j];    list[j]=temp;
	          i++; j--;
	       }
	    }  while (i <= j); // the pointers have not crossed

	    quickSort(list, leftIndex, j); //reduced problems: sort left partition,
	    quickSort(list, i, rightIndex); // sort right partition
	  }// end of quickSort
	
	/**A method to find the candidate desired and returns the location of the candidate if it is found, otherwise return -1
	* @param list Specifying the list of Candidate object desired
	* @param length Specifying the size of the array
	* @param searchItem Specifying the Candidate object that is looking for
	* @return the location of the candidate in the array if it is found
	* @return -1 if the candidate is not found
	*/	
	public static int searchCandidate(Candidate[] list, int length, Candidate searchItem)
	{
		 int index = 0; //used as a subscript to search the array
         int position = -1; //to record the position of the search item 
         boolean found = true; //flag to indicate if the item was found
         while(index < length && found)
         {
        	 //compare the item name of the object in the array with the search item
             if(list[index].compareToByCandidate(searchItem) == 0) //if the item is found
             {
                found = false;     //set the flag 
                position = index;  //record the value's subscript
             }   
             else 
             {
                index++;   //otherwise, go to the next element
             }
         }
         
         return position;
	}

	/**A method to print the vote results for all the candidates
	* @param list Specifying the list of Candidate object desired
	*/	
	public static void showAll(Candidate[] list)
	{
		for(int index = 0; index < list.length; index++)
		{
			System.out.println(list[index].toString());
		}
	}
	
	/**A method to compare the total votes received by each candidate and announce the winner who has the most vote
	* @param list Specifying the list of Candidate object desired
	*/	
	public static void announceWinner(Candidate[] list)
	{
		int highestVote = 0; //initial condition before finding the highest vote
		for(int index = 0; index < list.length; index++)
		{
			if(list[index].getTotalVote() > highestVote )  //if the vote win by the candidate is higher than the current highest vote
			{
				highestVote = list[index].getTotalVote();  //store the new highest vote
			}
		}
		
		int index = 0;
		while (list[index].getTotalVote() != highestVote && index < list.length) //find the candidate that win the highest vote
		{
			index++;
		}
		
		//Print the winner of the election with the vote results
		System.out.println("The winner in this presidential election for the country of Richland College is: "+ list[index].getCandidate());
		System.out.println("Win the most vote: " + highestVote);
		System.out.println("Congratulation to " + list[index].getCandidate() + " in winning this election!");
	}
}