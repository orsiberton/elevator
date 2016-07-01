package elevator;

public interface AdapterInterface {
	public void shutDown();

	public void startUp();

	public void request(Integer floorID);

	public void select(Integer floorID);

	public void notifyFloor();
	
	public Integer getNextFloor();

	public Integer getCurrentFloor();

	public State getCurrentState();
	
	public Boolean hasMoreFloorToVisit();
}
