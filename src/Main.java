public class Main {

	public Main() {
	}

	public static void main(String[] args) throws NegativeAmountOfTokenException {
		
		/**
		Edge Test
		try {
			Place p = new Place(1);
			System.out.println(p.getTokens());
			Transition t = new Transition();
			Edge e1 = new Edge(2, t, p);
			Edge e2 = new Edge(-1, t, p);
			System.out.println(t.triggerable());
			t.trigger();
			System.out.println(p.getTokens());
		}
		catch(Exception e) {
			System.out.println("Unexpected error");
		}
		
		try {
			Place p = new Place(1);
			Transition t2 = new Transition();
			Edge e3 = new Edge(-3, t2, p);
			System.out.println(t2.triggerable());
			e3.trigger();
			System.out.println(p.getTokens());
		}
		catch(Exception e) {
			System.out.println("Can't trigger an edge if it leaves a negative number of token in the place");
		}
		*/
		
		/** Test Zero Edge
		 try {
			Place p = new Place(1);
			Transition t = new Transition();
			ZeroEdge zero = new ZeroEdge(t, p);
			System.out.println(zero.triggerable());
			p.setTokens(0);
			System.out.println(zero.triggerable());
			zero.trigger();
			System.out.println(p.getTokens());
		}
		catch(Exception e) {
			System.out.println("Unexpected error");
		}
		 */
		
		/** Place test
		
		//Test of normal behavior
		
		Place p = new Place(1);
		System.out.println(p.getTokens());
		p.setTokens(0);
		System.out.println(p.getTokens());
		p.update(5);
		System.out.println(p.getTokens());
		
	
		//Test of exceptions involving a negative number of token
		
		try {
			Place q = new Place(-1);
		}
		catch(Exception e) {
			System.out.println("Can't create a place with a negative amount of token");
		}
		
		try {
			p.setTokens(-3);
		}
		catch(Exception e) {
			System.out.println("Can't set a negative amount of token");
		}
		
		try {
			p.update(-10);
		}
		catch(Exception e) {
			System.out.println("Can't have a negative amount of token after update");
		}
		*/
		
		
		/** Emptying edge test
		 try {
			Place p = new Place(0);
			Transition t = new Transition();
			EmptyingEdge empty = new EmptyingEdge(t, p);
			System.out.println(empty.triggerable());
			p.setTokens(5);
			System.out.println(empty.triggerable());
			empty.trigger();
			System.out.println(p.getTokens());
		}
		catch(Exception e) {
			System.out.println("Unexpected error");
		}
		 */
		 
		
		Simulation sim = new Simulation();
		System.out.println("*Test of printState(): expected result is 3 0");
		sim.createPlace(3);
		sim.createPlace(0);
		sim.createTransition();
		sim.createTransition();
		sim.createEdge(-2, sim.getTransitions().get(0), sim.getPlaces().get(0));
		sim.createEdge(1, sim.getTransitions().get(0), sim.getPlaces().get(1));
		sim.createEmptyingEdge(sim.getTransitions().get(1), sim.getPlaces().get(1));
		sim.createEdge(1, sim.getTransitions().get(1), sim.getPlaces().get(0));
		sim.printState();
		System.out.println("*Test of nextStep(Transition): expected result is \"Transition not triggerable\" then 1 1");
		sim.setTokens(sim.getPlaces().get(0), 3);
		sim.setTokens(sim.getPlaces().get(1), 0);
		sim.nextStep(sim.getTransitions().get(1));
		sim.nextStep(sim.getTransitions().get(0));
		sim.printState();
		System.out.println("*Test of nextStep(): 3 iterations the results must change or be \"No transition triggerable\"");
		sim.nextStep();
		sim.printState();
		sim.nextStep();
		sim.printState();
		sim.nextStep();
		sim.printState();
		System.out.println("*Test of removeEdge(): expected result is 1 then 0 0");
		int nEdges = sim.getEdges().size();
		sim.removeEdge(sim.getEdges().get(3));
		nEdges -= sim.getEdges().size();
		System.out.println(nEdges);
		sim.setTokens(sim.getPlaces().get(0), 0);
		sim.setTokens(sim.getPlaces().get(1), 10);
		sim.nextStep(sim.getTransitions().get(1));
		sim.printState();
		System.out.println("*Test of removeTransition(): expected result is 1 then \"No transition triggerable\"");
		int nTransitions = sim.getTransitions().size();
		sim.removeTransition(sim.getTransitions().get(1));
		nTransitions -= sim.getTransitions().size();
		System.out.println(nTransitions);
		sim.setTokens(sim.getPlaces().get(0), 0);
		sim.setTokens(sim.getPlaces().get(1), 10);
		sim.nextStep();
		sim.nextStep();
	}

}
