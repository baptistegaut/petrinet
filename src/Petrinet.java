public interface Petrinet {
	/**
	 * create a new place
	 * @param tokens number of tokens to begin with
	 * @throws NegativeAmountOfTokenException
	 */
	public void createPlace(int tokens) throws NegativeAmountOfTokenException;

	/**
	 * create a new transition
	 */
	public void createTransition();

	/**
	 * create a new edge
	 * @param weight the weight of the edge
	 * @param transition attach to the edge
	 * @param place attach to the edge
	 */
	public void createEdge(int weight, Transition transition, Place place);

	/**
	 * create a new zero edge
	 * @param transition attach to the edge
	 * @param place attach to the edge
	 */
	public void createZeroEdge(Transition transition, Place place);

	/**
	 * create a new empty edge
	 * @param transition
	 * @param place
	 */
	public void createEmptyingEdge(Transition transition, Place place);

	/**
	 * set tokens in a specific place
	 * @param place place we wqnt to edit
	 * @param tokens number of tokens to set
	 * @throws NegativeAmountOfTokenException
	 */
	public void setTokens(Place place, int tokens) throws NegativeAmountOfTokenException;

	/**
	 * remove a specific edge
	 * @param edge
	 */
	public void removeEdge(Edge edge);

	/**
	 * remove a specific place
	 * @param place
	 */
	public void removePlace(Place place);

	/**
	 * remove a specific transition
	 * @param transition
	 */
	public void removeTransition(Transition transition);

	/**
	 * pull a  random triggerable transition
	 * @throws NegativeAmountOfTokenException
	 */
	public void nextStep() throws NegativeAmountOfTokenException;

	/**
	 *pull a specific transition
	 * @param transition
	 * @throws NegativeAmountOfTokenException
	 */
	public void nextStep(Transition transition) throws NegativeAmountOfTokenException;

	/**
	 * print the current state
	 */
	public void printState();
	
}
