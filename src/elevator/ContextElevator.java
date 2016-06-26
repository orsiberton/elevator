package elevator;

import java.util.ArrayList;
import java.util.List;

public class ContextElevator implements Cloneable {
	public State state;
	public Integer currentFloor;
	public Integer nextFloor;
	public Boolean hasMoreFloorToVisit;
	public List<Integer> floors;
	
	public ContextElevator clone() {
		try {
			return (ContextElevator) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	public void handleEvent(Object... in_colObject) {
		if (in_colObject.length > 0) {
			String eventName = (String) in_colObject[0];
			
			// TODO substituir isso por métodos do adaptador quando for realizar o T3 e o T4
			if (eventName.equals("startupEvent")) {
				this.state = State.Ligado_Parado;
				this.currentFloor = 0;
				this.nextFloor = -1;
				this.hasMoreFloorToVisit = Boolean.FALSE;
				this.floors = new ArrayList<Integer>();
			} else if (eventName.equals("shutdownEvent")) {
				this.state = State.Desligado;
				this.currentFloor = 0;
				this.nextFloor = -1;
				this.hasMoreFloorToVisit = Boolean.FALSE;
			} else if (eventName.equals("requestEvent")) {
				this.state = State.Ligado_Movimento;
				this.currentFloor = 0;
				this.nextFloor = (Integer) in_colObject[1];
				this.hasMoreFloorToVisit = Boolean.TRUE;
				this.floors.add(nextFloor);
			} else if (eventName.equals("selectEvent")) {
				this.state = State.Ligado_Movimento;
				this.currentFloor = 0;
				this.nextFloor = (Integer) in_colObject[1];
				this.hasMoreFloorToVisit = Boolean.TRUE;
				this.floors.add(nextFloor);
			} else if (eventName.equals("wrongFloorEvent")) {
				this.state = State.Ligado_Movimento;
			} else if (eventName.equals("stopElevatorAtFloorEvent")) {
				this.state = State.Ligado_Parado;
				this.currentFloor = this.floors.get(0);
				this.floors.remove(0);
				this.nextFloor = this.floors.get(0);
				this.hasMoreFloorToVisit = this.floors.size() != 0;
			} else if (eventName.equals("attendsNextFloorEvent")) {
				this.state = State.Ligado_Movimento;
				this.nextFloor = this.floors.get(0);
				this.hasMoreFloorToVisit = Boolean.TRUE;
			}
		}
	}

}


