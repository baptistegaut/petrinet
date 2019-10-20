/**
 * 
 */

import java.util.ArrayList;

/**
 * @author bgautier
 *This is the transition class
 */
public class Transition {

	/**
	 * edgesIn are the list of edges going from Place to Transition
	 */
	private ArrayList<Edge> edgesIn;

	/**
	 * edgesOut are the list of edges going from Transition to place
	 */
	private ArrayList<Edge> edgesOut;

	public Transition() {
		edgesIn = new ArrayList<Edge>();
		edgesOut = new ArrayList<Edge>();
	}

	/**
	 * add an edge in edgesIn
	 * @param edge the edge to add
	 */
	public void addEdgeIn(Edge edge) {
		this.edgesIn.add(edge);
	}

	/**
	 * add an edge in edgesOut
	 * @param edge the edge to add
	 */
	public void addEdgeOut(Edge edge) {
		this.edgesOut.add(edge);
	}

	/**
	 * remove an edge from edgesIn or edgesOut
	 * @param edge the edge to remove
	 */
	public void removeEdge(Edge edge) {
		this.edgesIn.remove(edge);
		this.edgesOut.remove(edge);
	}

	/**
	 * remove the transition from all its edges
	 */
	public void remove() {
		for (Edge e: edgesIn) {
			e.remove();
		}
		for (Edge e: edgesOut) {
			e.remove();
		}
	}

	/**
	 * verify if the transition is triggerable
	 * @return true if the transition is triggerable
	 */
	public boolean triggerable() {
		for (Edge edgeIn: edgesIn) {
			if (!edgeIn.triggerable()) {
				return false;
			}
		} 
		return true;
	}

	/**
	 * trigger the transition
	 * @throws NegativeAmountOfTokenException
	 */
	public void trigger() throws NegativeAmountOfTokenException {
		for (Edge edgeIn: edgesIn) {
			edgeIn.trigger();
		} 
		for (Edge edgeOut: edgesOut) {
			edgeOut.trigger();
		}
	}
	
}
