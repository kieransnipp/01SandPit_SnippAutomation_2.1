package myService;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class InjectMockConcept {

	@Mock //This is the Mock
	List<String> mockList; //1, This is an Object
	//We can define the behavout with the mockList Object

	 //2, Creating an object of Employee and 			
	@InjectMocks   //Injecting it to the @Mock	
	Employee mockEmployee; //2.1, This is an Object

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void EmployeMockTest() {	
		//Define the behavour
		//You can only mock behaviour you define
		when(mockList.get(0)).thenReturn("Kieran"); // xx
		when(mockList.size()).thenReturn(1);

		// Assert 
		assertEquals("Kieran", mockList.get(0));
		assertEquals(1, mockList.size());
		
		assertEquals("Kieran", mockEmployee.getEmpName().get(0)); //Getting xx
		assertEquals(1, mockEmployee.empName.size());
		
		mockList.add(1, "Tom");
		System.out.println(mockList.get(1)); //Displays 'null' as the behavior is not mocked
		
		
	}

} //End InjectMockConcept

//Outer Class
class Employee {
	List<String> empName;

	public List<String> getEmpName() {
		return empName;
	}

	public void setEmpName(List<String> empName) {
		this.empName = empName;
	}

}
