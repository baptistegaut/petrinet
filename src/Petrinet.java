public interface Petrinet {
	public void createPlace(int tokens) throws NegativeAmountOfTokenException;
	public void createTransition();
	public void createEdge(int weight, Transition transition, Place place);
	public void createZeroEdge(Transition transition, Place place);
	public void createEmptyingEdge(Transition transition, Place place);
	public void setTokens(Place place, int tokens) throws NegativeAmountOfTokenException;
	public void removeEdge(Edge edge);
	public void removePlace(Place place);
	public void removeTransition(Transition transition);
	public void nextStep() throws NegativeAmountOfTokenException;
	public void nextStep(Transition transition) throws NegativeAmountOfTokenException;
	public void printState();
	
}
