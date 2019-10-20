/**
 * This is the Edge class
 */
public class Edge {
	/**
	 * the weight of the edge, positive if direction is from transition to place
	 */
	protected int weight; //

	/**
	 * the transition attach to the edge
	 */
	protected Transition transition;

	/**
	 * the place attach to the edge
	 */
	protected Place place;
	
	public Edge(int weight, Transition transition, Place place) {
		this.weight = weight; 
		this.place = place;
		this.transition = transition;
		this.place.addEdge(this);
		if (weight > 0) {	//from transition to place
			this.transition.addEdgeOut(this);
		}
		else {
			this.transition.addEdgeIn(this);
		}
	}

	/**
	 *
	 * @return the transition attach to the edge
	 */
	public Transition getTransition() {
		return transition;
	}

	/**
	 *
	 * @return the place attach to the edge
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 *
	 * @return the weight of the edge
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * set the weight of the edge
	 * @param weight the new weight of the edge
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Verify if the place is triggerable
	 * @return true if the place is triggerable
	 */
	public boolean triggerable() {
		return -(this.weight) <= this.place.getTokens();
	}

	/**
	 * Trigger the transition
	 * @throws NegativeAmountOfTokenException if weight is < 0
	 */
	public void trigger() throws NegativeAmountOfTokenException {
		this.place.update(this.weight);
	}

	/**
	 * Remove the edge from the place and the transition
	 */
	public void remove() {
		this.place.removeEdge(this);
		this.transition.removeEdge(this);
	}

}
