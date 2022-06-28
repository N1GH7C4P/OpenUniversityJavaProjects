/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airports;

import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 *
 * @author kimmo
 */

@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Points("01-03")
public class AirportServiceTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private AirportRepository airportRepository;
    
    @Autowired
    private AirportService airportService;
    
    public AirportServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void NewAirportSavedProperly() throws Throwable{
        this.airportRepository.deleteAll();
        String name = "Helsinki";
        String identifier = "ABC-123";
        
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/airports")
                .param("name", name)
                .param("identifier", identifier)
        );
        
        assertEquals(this.airportRepository.count(),1);
        List<Airport> airports = this.airportRepository.findAll();
        
        boolean apInDatabase = false;
        for (Airport ap : airports) {
            if(ap.getName().equals(name) && ap.getIdentifier().equals(identifier)) {
                apInDatabase = true;
            }
        }
        assertEquals("Airport not in database", apInDatabase,true);
    }
    
    @Test
    public void AirportsListedProperly() throws Throwable{
        this.airportRepository.deleteAll();
        String[] names = {"Helsinki","Hulsinki","Halsinki"};
        String[] identifiers = {"ABC-001","ABC-002","ABC-003"};
        ArrayList<Airport> airports = new ArrayList();
        
        for(int i = 0; i<3; i++) {
            Airport a = new Airport();
            a.setName(names[i]);
            a.setIdentifier(identifiers[i]);
            this.airportRepository.save(a);
            
            airports.add(a);
        }
        
        ArrayList<Airport> ap = (ArrayList<Airport>) airportService.list();
        for(int i = 0; i<3; i++) {
            airports.get(i).getName().equals(ap.get(i).getName());
            airports.get(i).getIdentifier().equals(ap.get(i).getIdentifier());
        }
    }
    
    @Test 
    public void NoDuplicateAirports() throws Throwable{
        this.airportRepository.deleteAll();
        try {
            String[] names = {"Helsinki","Helsinki"};
            String[] identifiers = {"ABC-001","ABC-002"};

            for(int i = 0; i<2; i++) {
                Airport a = new Airport();
                a.setName(names[i]);
                a.setIdentifier(identifiers[i]);
                this.airportRepository.save(a);
            }
        }
        catch(Exception e) {
            System.out.println("Duplicate values: "+e);
        }
        
        assertEquals("Duplicate names in airport database.",1,airportRepository.count());
    }
}
