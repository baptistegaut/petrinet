/**
 * 
 */

/**
 * @author bgautier
 *
 */
public class EmptyingEdge extends Edge {

	private final static int WEIGHT = -1;
	
	/**
	 * @param weight irrelevant as the weight of a emptying edge is always -1
	 * @param transition
	 * @param place
	 */
	public EmptyingEdge(int weight, Transition transition, Place place) {
		super(WEIGHT, transition, place);
	}
	
	public EmptyingEdge(Transition transition, Place place) {
		super(WEIGHT, transition, place);
	}

	/**
	 * Redefines the parent method
	 * Sets the number of tokens in the place to 0
	 * @throws NegativeAmountOfTokenException 
	 */
	public void trigger() throws NegativeAmountOfTokenException{
		this.place.setTokens(0) ;
	}
	
	/**
	 * Redefines the parent method to make sure the weight remains -1 even if a user tries to set it to another value.
	 */
	public void setWeight(int weight) {
		return;
	}
	
}
