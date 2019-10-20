

import java.util.ArrayList;
import java.util.Random;

/**
 * @author bgautier
 *
 */
public class Simulation implements Petrinet {


	/**
	 *
	 */
	private ArrayList<Place> places;

	/**
	 *
	 */
	private ArrayList<Transition> transitions;

	/**
	 *
	 */
	private ArrayList<Edge> edges;

	public Simulation() {
		places = new ArrayList<Place>();
		transitions = new ArrayList<Transition>();
		edges = new ArrayList<Edge>();
	}

	public ArrayList<Place> getPlaces() {
		return places;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	/**
	 *
	 * 
	 * @see petri.Petrinet#createPlace()
	 */
	@Override
	public void createPlace(int tokens) throws NegativeAmountOfTokenException {
		Place p = new Place(tokens);
		places.add(p);
	}

	/**
	 *
	 * 
	 * @see petri.Petrinet#createTransition()
	 */
	@Override
	public void createTransition() {
		transitions.add(new Transition());
	}

	/**
	 *
	 * 
	 * @see petri.Petrinet#createEdge()
	 */
	@Override
	public void createEdge(int weight, Transition transition, Place place) {
		edges.add(new Edge(weight, transition, place));
	}
	
	/**
	 *
	 * 
	 * @see petri.Petrinet#createZeroEdge()
	 */
	
	@Override
	public void createZeroEdge(Transition transition, Place place) {
		edges.add(new ZeroEdge(transition, place));
	}

	/**
	 *
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

	/*
	 * (non-Javadoc)index
	 * 
	 * @see petri.Petrinet#removeEdge()
	 */
	@Override
	public void removeEdge(Edge edge) {
		edges.remove(edge);
		edge.remove();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see petri.Petrinet#removePlace()
	 */
	@Override
	public void removePlace(Place place) {
		places.remove(place);
		place.remove();
	}

	/*
	 * (non-Javindexadoc)
	 * 
	 * @see petri.Petrinet#removeTransition()
	 */
	@Override
	public void removeTransition(Transition transition) {
		transitions.remove(transition);
		transition.remove();
	}

	/*
	 * (non-Javadoc)
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

	@Override
	public void nextStep(Transition transition) throws NegativeAmountOfTokenException {
		if (transition.triggerable()) {
			transition.trigger();
		} else {
			System.out.println("Transition  not triggerable");
		}
	}


	@Override
	public void printState() {
		int i = 0;
		for (Place p : places) {
			System.out.println("Place " + i + " : " + p.getTokens());
			i++;
		}
	}


}
