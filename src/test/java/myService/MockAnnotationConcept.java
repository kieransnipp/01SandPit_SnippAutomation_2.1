package myService;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class MockAnnotationConcept {

	@Mock
	List<String> mockList;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void mockListTest() {

		when(mockList.get(0)).thenReturn("Kieran Automation");
		assertEquals("Kieran Automation", mockList.get(0));
	}

}
