/**
 * 
 */

import java.util.ArrayList;

/**
 * @author bgautier
 *This is the Place class
 */
public class Place {

	/**
	 * tokens represent the number of tokens in the place
	 */
	private int tokens;

	/**
	 * edges represents the edges attach to the place
	 */
	private ArrayList<Edge> edges;

	public Place(int tokens) throws NegativeAmountOfTokenException {
		if (tokens < 0) {
			throw new NegativeAmountOfTokenException();
		}
		this.tokens = tokens;
		edges = new ArrayList<Edge>();
	}

	/**
	 * Set the number of tokens in the place
	 * @param tokens the number of tokens in the place
	 * @throws NegativeAmountOfTokenException if tokens < 0
	 */
	public void setTokens(int tokens) throws NegativeAmountOfTokenException {
		if (tokens < 0) {
			throw new NegativeAmountOfTokenException();
		}
		this.tokens = tokens;
	}

	/**
	 *
	 * @return the number of tokens in the place
	 */
	public int getTokens() {
		return this.tokens;
	}

	/**
	 * add to a number of tokens to the previous
	 */
	public void update(int tokens) throws NegativeAmountOfTokenException{
		int newAmount = this.tokens + tokens;
		if (newAmount < 0) {
			throw new NegativeAmountOfTokenException();
		}
		this.tokens = newAmount;
	}

	/**
	 * add an edge to edges
	 * @param edge
	 */
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	/**
	 * remove an edge from the edges
	 * @param edge
	 */
	public void removeEdge(Edge edge) {
		this.edges.remove(edge);
	}

	/**
	 * remove all the edges attach to the Place
	 */
	public void remove() {
		for (Edge e : edges) {
			e.remove();
		}
	}

	
}
