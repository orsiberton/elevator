package elevator;

import java.util.ArrayList;
import java.util.List;

public class ContextElevator implements Cloneable {

	private AdapterInterface adapterInterface = new Adapter();

	public State state;
	public Integer currentFloor;
	public Integer nextFloor;
	public Boolean hasMoreFloorToVisit;

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

			if (eventName.equals("startupEvent")) {

				this.adapterInterface.startUp();
				this.currentFloor = this.adapterInterface.getCurrentFloor();
				this.nextFloor = this.adapterInterface.getNextFloor();
				this.hasMoreFloorToVisit = this.adapterInterface.hasMoreFloorToVisit();
				this.state = this.adapterInterface.getCurrentState();

			} else if (eventName.equals("shutdownEvent")) {

				this.adapterInterface.shutDown();
				this.currentFloor = this.adapterInterface.getCurrentFloor();
				this.nextFloor = this.adapterInterface.getNextFloor();
				this.hasMoreFloorToVisit = this.adapterInterface.hasMoreFloorToVisit();
				this.state = this.adapterInterface.getCurrentState();

			} else if (eventName.equals("requestEvent")) {

				this.adapterInterface.request((Integer) in_colObject[1]);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.currentFloor = this.adapterInterface.getCurrentFloor();
				this.nextFloor = this.adapterInterface.getNextFloor();
				this.hasMoreFloorToVisit = this.adapterInterface.hasMoreFloorToVisit();
				this.state = this.adapterInterface.getCurrentState();

			} else if (eventName.equals("selectEvent")) {

				this.adapterInterface.select((Integer) in_colObject[1]);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.currentFloor = this.adapterInterface.getCurrentFloor();
				this.nextFloor = this.adapterInterface.getNextFloor();
				this.hasMoreFloorToVisit = this.adapterInterface.hasMoreFloorToVisit();
				this.state = this.adapterInterface.getCurrentState();

			} else if (eventName.equals("wrongFloorEvent")) {
				// DO NOTHING
			} else if (eventName.equals("stopElevatorAtFloorEvent")) {

				while (this.adapterInterface.getCurrentState() != State.Ligado_Parado) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				this.currentFloor = this.adapterInterface.getCurrentFloor();
				this.nextFloor = this.adapterInterface.getNextFloor();
				this.hasMoreFloorToVisit = this.adapterInterface.hasMoreFloorToVisit();
				this.state = this.adapterInterface.getCurrentState();

			} else if (eventName.equals("attendsNextFloorEvent")) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
