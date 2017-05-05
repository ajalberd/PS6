package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Date;
import base.PersonDAL;
import domain.PersonDomainModel;

public class PersonDALTest {
	private static PersonDomainModel sampleperson = new PersonDomainModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sampleperson.setBirthday(new Date(0));
		sampleperson.setFirstName("James");
		sampleperson.setLastName("BonD");
		sampleperson.setPostalCode(00700);
		sampleperson.setStreet("123 Spy Ave");
		sampleperson.setCity("London");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDAL.deletePerson(sampleperson.getPersonID());
		PersonDomainModel per3 = PersonDAL.getPerson(sampleperson.getPersonID());
		assertNull(per3);
	}

	@Test
	public void Add() {
		
		PersonDAL.addPerson(sampleperson);
		PersonDomainModel per2 = PersonDAL.getPerson(sampleperson.getPersonID());
		
		assertNotNull(per2);
		
	}
	
	@Test
	public void TestPeople(){
		PersonDomainModel per1 = PersonDAL.getPerson(sampleperson.getPersonID());
		assertEquals(sampleperson.getPersonID(), per1.getPersonID());
		per1.setLastName("Connery");
		assertNotEquals(sampleperson.getLastName(), per1.getLastName());
		PersonDAL.updatePerson(per1);
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per1.getLastName(), per2.getLastName());
		assertNotEquals(sampleperson.getLastName(), per2.getLastName());
		
	}

}