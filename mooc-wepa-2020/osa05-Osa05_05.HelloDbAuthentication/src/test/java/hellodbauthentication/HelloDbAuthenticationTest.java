package hellodbauthentication;

import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@Points("05-05")
public class HelloDbAuthenticationTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private AccountRepository ar;
    
    @Test
    public void noTests() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
            .post("/accounts")
            .param("username", "kimmo")
            .param("password","1234")
        );
        mockMvc.perform(MockMvcRequestBuilders
            .post("/accounts")
            .param("username", "matti")
            .param("password","1234")
        );
    }
}
