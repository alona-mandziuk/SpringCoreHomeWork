package controllersTest;

import com.data.config.AppConfig;
import com.data.controllers.PeopleController;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration

public class PeopleControllerTest {
    @Autowired
    private PeopleController peopleController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(peopleController).build();
    }

    @Test
    @SneakyThrows
    public void indexTest() {
        mockMvc.perform(MockMvcRequestBuilders.get("/people"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("people/index"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("people"));
    }

    @Test
    @SneakyThrows
    public void deleteTest() {
        int personId = 1;
        mockMvc.perform(MockMvcRequestBuilders.delete("/people/{id}", personId))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/people"));
    }
}
