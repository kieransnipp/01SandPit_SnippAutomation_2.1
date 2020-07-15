package myService;

import static org.testng.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class myMockServiceTestClass {

	@Test
	public void testMock() {
		MyServiceProvider mockObj = Mockito.mock(MyServiceProvider.class); //Creating the mock

		Mockito.when(mockObj.add(20, 30)).thenReturn(70);  //Behaviour
		assertEquals(70, mockObj.add(20, 30)); //Asserting

	}

}
