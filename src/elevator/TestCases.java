package elevator;

import org.junit.*;
import static org.junit.Assert.*;

// JUnit 4.3
public class TestCases{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCases.class);
	}
	
	@Test
	public void test1()
	{
		ContextElevator oTestObject = new ContextElevator();
		oTestObject.handleEvent("startupEvent");
		assertEquals(true, (oTestObject.state == State.Ligado_Parado));
		oTestObject.handleEvent("shutdownEvent");
		
	}
	
	@Test
	public void test2()
	{
		ContextElevator oTestObject = new ContextElevator();
		Integer requestedFloor2 = -638626;
		oTestObject.handleEvent("startupEvent");
		assertEquals(true, (oTestObject.state == State.Ligado_Parado));
		oTestObject.handleEvent("requestEvent", requestedFloor2);
		assertEquals(true, (oTestObject.state == State.Ligado_Movimento));
		oTestObject.handleEvent("stopElevatorAtFloorEvent");
		assertEquals(true, (oTestObject.state == State.Ligado_Parado));
		assertEquals(true, (oTestObject.hasMoreFloorToVisit.booleanValue() == true));
		oTestObject.handleEvent("attendsNextFloorEvent");
		assertEquals(true, (oTestObject.state == State.Ligado_Movimento));
		
	}
	
	@Test
	public void test3()
	{
		ContextElevator oTestObject = new ContextElevator();
		oTestObject.handleEvent("startupEvent");
		assertEquals(true, (oTestObject.state == State.Ligado_Parado));
		assertEquals(true, (oTestObject.hasMoreFloorToVisit.booleanValue() == false));
		oTestObject.handleEvent("noMoreFloorsEvent");
		assertEquals(true, (oTestObject.state == State.Ligado_Parado));
		
	}
	
	@Test
	public void test4()
	{
		ContextElevator oTestObject = new ContextElevator();
		Integer selectedFloor2 = -24566;
		oTestObject.handleEvent("startupEvent");
		assertEquals(true, (oTestObject.state == State.Ligado_Parado));
		oTestObject.handleEvent("selectEvent", selectedFloor2);
		assertEquals(true, (oTestObject.state == State.Ligado_Movimento));
		
	}
	
}