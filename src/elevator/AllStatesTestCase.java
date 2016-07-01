package elevator;

import org.junit.*;
import static org.junit.Assert.*;

// JUnit 4.3
public class AllStatesTestCase{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(AllStatesTestCase.class);
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
		Integer requestedFloor2 = 4;
		oTestObject.handleEvent("startupEvent");
		assertEquals(true, (oTestObject.state == State.Ligado_Parado));
		oTestObject.handleEvent("requestEvent", requestedFloor2);
		assertEquals(true, (oTestObject.state == State.Ligado_Movimento));
		//assertEquals(true, (oTestObject.currentFloor.intValue() > oTestObject.nextFloor.intValue()));
		oTestObject.handleEvent("wrongFloorEvent");
		assertEquals(true, (oTestObject.state == State.Ligado_Movimento));
		
	}
	
}