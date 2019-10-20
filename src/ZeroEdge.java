/**
 * 
 */

/**
 * @author bgautier
 *
 */
public class ZeroEdge extends Edge {

	
	private final static int WEIGHT = 0;	//The weight of a zero edge actually doesn't matter as coded here but it is natural to set it at 0
	
	/**
	 * Constructor
	 * @param weight irrelevant as the weight of a zero edge is 0
	 * @param transition
	 * @param place
	 */
	public ZeroEdge(int weight, Transition transition, Place place) {
		super(WEIGHT, transition, place);
	}
	
	public ZeroEdge(Transition transition, Place place) {
		super(WEIGHT, transition, place);
	}

	/**
	 * Redefines the parent method
	 * Returns true if the place is empty
	 */
	public boolean triggerable() {
		return (this.place.getTokens() == 0);
	}
	
	/**
	 * Redefines the parent method
	 * Skips useless computation as a zero edge does not take tokens
	 */
	public void trigger() {
		return;
	}
	
	
	
		

}
