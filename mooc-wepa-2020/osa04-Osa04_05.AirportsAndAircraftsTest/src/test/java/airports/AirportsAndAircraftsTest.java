package airports;

import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.Test;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Points("04-05")
public class AirportsAndAircraftsTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private AirportRepository airportRepository;
    
    @Autowired
    private AircraftRepository aircraftRepository;
    
    @Autowired
    private AirportService airportService;

    @Test
    public void GetReturnsOkWithAirportsAndAircrafts() throws Exception {
        this.aircraftRepository.deleteAll();
        mockMvc.perform(get("/aircrafts"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("aircrafts"))
                .andExpect(model().attributeExists("airports"));
    }
    
    @Test
    public void PostReturnsRedirectAndAircraftGetsInserted() throws Exception {
        this.aircraftRepository.deleteAll();
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/aircrafts")
                .param("name", "HA-LOL"))
                .andExpect(status().is3xxRedirection());
        assert(aircraftRepository.findAll().toString().contains("HA-LOL"));
    }
    
    @Test
    public void GetReturnsCorrectAircraft() throws Exception {
        this.aircraftRepository.deleteAll();
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/aircrafts")
                .param("name", "XP-55"))
                .andExpect(status().is3xxRedirection());
        
       MvcResult result = this.mockMvc.perform(get("/aircrafts"))
               .andExpect(status().isOk())
               .andReturn();
       String content = result.getResponse().getContentAsString();
  
       
       assert(content.contains("XP-55"));
    }
}
