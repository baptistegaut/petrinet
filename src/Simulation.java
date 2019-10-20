

import java.util.ArrayList;
import java.util.Random;

/**
 * The simulation class implement the interface petrinet
 * @author bgautier
 *
 */
public class Simulation implements Petrinet {


	/**
	 * List of places
	 */
	private ArrayList<Place> places;

	/**
	 * List of transitions
	 */
	private ArrayList<Transition> transitions;

	/**
	 * List of edges
	 */
	private ArrayList<Edge> edges;

	public Simulation() {
		places = new ArrayList<Place>();
		transitions = new ArrayList<Transition>();
		edges = new ArrayList<Edge>();
	}

	/**
	 * 
	 * @return list of places
	 */
	public ArrayList<Place> getPlaces() {
		return places;
	}

	/**
	 * @return list of transitions
	 */
	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	/**
	 * @return list of edges
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}

	/**
	 * Create a new place
	 *@param tokens 
	 * 
	 * @see petri.Petrinet#createPlace()
	 */
	 @Override
	public void createPlace(int tokens) throws NegativeAmountOfTokenException {
		Place p = new Place(tokens);
		places.add(p);
	}

	/**
	 * Create a new transition
	 * 
	 * @see petri.Petrinet#createTransition()
	 */
	@Override
	public void createTransition() {
		transitions.add(new Transition());
	}

	/**
	 * Create a new Edge and adds it to the edges list
	 * 
	 * @param weight
	 * @param transition
	 * @param place
	 * 
	 * 
	 * @see petri.Petrinet#createEdge()
	 */
	@Override
	public void createEdge(int weight, Transition transition, Place place) {
		edges.add(new Edge(weight, transition, place));
	}
	
	/**
	 * Create a new zeroEdge and adds it to the edges list
	 * 
	 * @param transition
	 * @param place
	 * 
	 * @see petri.Petrinet#createZeroEdge()
	 */
	
	@Override
	public void createZeroEdge(Transition transition, Place place) {
		edges.add(new ZeroEdge(transition, place));
	}

	/**
	 *Create a new EmptyEdge and adds it to the edges list
	 * 
	 * @param transition
	 * @param place
	 * 
	 * @see petri.Petrinet#createEmptyingEdge()
	 */

	@Override
	public void createEmptyingEdge(Transition transition, Place place) {
		edges.add(new EmptyingEdge(transition, place));
	}
	
	/**
	 *
	 * 
	 * @see petri.Petrinet#setTokens()
	 */
	@Override
	public void setTokens(Place place, int tokens) throws NegativeAmountOfTokenException {
		place.setTokens(tokens);
	}

	/** 
	 * 
	 * 
	 * @see petri.Petrinet#removeEdge()
	 */
	@Override
	public void removeEdge(Edge edge) {
		edges.remove(edge);
		edge.remove();
	}

	/**
	 *
	 * 
	 * @see petri.Petrinet#removePlace()
	 */
	@Override
	public void removePlace(Place place) {
		places.remove(place);
		place.remove();
	}

	/** 
	 * 
	 * 
	 * @see petri.Petrinet#removeTransition()
	 */
	@Override
	public void removeTransition(Transition transition) {
		transitions.remove(transition);
		transition.remove();
	}

	/** 
	 * 
	 * 
	 * @see petri.Petrinet#nextStep()
	 */
	@Override
	public void nextStep() throws NegativeAmountOfTokenException {
		ArrayList<Transition> triggerableTransitions = new ArrayList<Transition>();
		for (Transition t : transitions) {
			if (t.triggerable()) {
				triggerableTransitions.add(t);
			}
		}
		if (triggerableTransitions.isEmpty()) {
			System.out.println("No transition triggerable");
			return;
		} else {
			int i = new Random().nextInt(triggerableTransitions.size());
			triggerableTransitions.get(i).trigger();
		}
	}


	/** 
	 * 
	 * 
	 * @see petri.Petrinet#nextStep(Transition transition)
	 */
	@Override
	public void nextStep(Transition transition) throws NegativeAmountOfTokenException {
		if (transition.triggerable()) {
			transition.trigger();
		} else {
			System.out.println("Transition  not triggerable");
		}
	}

	/** 
	 * 
	 * 
	 * @see petri.Petrinet#printState()
	 */
	@Override
	public void printState() {
		int i = 0;
		for (Place p : places) {
			System.out.println("Place " + i + " : " + p.getTokens());
			i++;
		}
	}


}
