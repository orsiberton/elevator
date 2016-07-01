package elevator;

public class Adapter implements AdapterInterface {

	private Elevator elevator;
	private ElevatorGroup group;

	public Adapter() {
		this.group = ElevatorGroup.getGroup(1, 25);
	}

	@Override
	public void shutDown() {
		this.group.stopGroup();
		this.elevator = null;
	}

	@SuppressWarnings("static-access")
	@Override
	public void startUp() {
		this.group.startGroup();
		this.elevator = this.group.e[0];
	}

	@Override
	public void request(Integer floorID) {
		FloorInterface floorInterface = this.group.getFloorInterface(floorID);

		if (getCurrentFloor() < floorID) {
			floorInterface.requestUp(floorID);
		} else if (getCurrentFloor() > floorID) {
			floorInterface.requestDown(floorID);
		}
	}

	@Override
	public void select(Integer floorID) {
		FloorInterface floorInterface = this.group.getFloorInterface(floorID);

		if (getCurrentFloor() < floorID) {
			floorInterface.requestUp(floorID);
		} else if (getCurrentFloor() > floorID) {
			floorInterface.requestDown(floorID);
		}
	}

	@Override
	public void notifyFloor() {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer getNextFloor() {
		if (this.elevator == null) {
			return Integer.valueOf(-1);
		} else {
			return Integer.valueOf(this.elevator.getNextDestination());
		}
	}

	@Override
	public Integer getCurrentFloor() {
		if (this.elevator == null) {
			return Integer.valueOf(0);
		} else {
			return this.elevator.getFloor().getFloorID();
		}
	}

	@Override
	public State getCurrentState() {
		if (this.elevator == null) {
			return State.Desligado;
		}

		if (this.elevator.getState() == Elevator.MOVING) {
			return State.Ligado_Movimento;
		} else {
			return State.Ligado_Parado;
		}
	}

	@Override
	public Boolean hasMoreFloorToVisit() {
		if (this.elevator == null) {
			return Boolean.FALSE;
		} else {
			return -1 != this.elevator.getNextDestination();
		}
	}

}
