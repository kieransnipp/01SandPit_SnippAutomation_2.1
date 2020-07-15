package myService;

import org.junit.Test;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertTrue;

public class MockList {
	
	@Test
	public void myMockListTest() {
		List <String> mockList = mock(List.class);
		when(mockList.size()).thenReturn(5);
		assertTrue(mockList.size() == 5);
		
	}

}
