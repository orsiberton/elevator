package elevator;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Request Up from floor i: A group should be first created and started, 
		  in this example the system is created with 3 elevators and 5 floors: */
		ElevatorGroup group = ElevatorGroup.getGroup(2,4);
		group.startGroup();
		
		//then, get a FloorInterface for the floor from which to send up request
		FloorInterface f = group.getFloorInterface(3);
		
		//next, make the request:
		f.requestUp(3);
					
		/*Request Down from floor i: The only difference with request up is the call on the interface:*/
		f.requestDown(1);
		
		/*Note that if a wrong floor ID is passed to the getFloorInterface method a nullPointerException 
		  will be thrown. Also note that floor ID = floor number – 1; for example, first floor has floor ID = 0.*/
		
		
		/*Request Stop at floor j from elevator k
          A group should be first created and started, in this example the system is created
          with 2 elevators and 4 floors:*/
		ElevatorGroup group1 = ElevatorGroup.getGroup(2,4);
		group1.startGroup();

		//then, get an ElevatorInterface for the elevator from which to send a stop request
		ElevatorInterface e = group1.getElevatorInterface(1);
	     
		//next, make the request:
		e.requestStop(2);

		/*Note that if a wrong elevator ID is passed to the getElevatorInterface method a nullPointerException
		  will be thrown. Also note that elevator ID = elevator number – 1; for example, first elevator has elevator ID = 0.*/
	}

}
