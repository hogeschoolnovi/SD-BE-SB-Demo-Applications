package nl.novi.testjunitjupiter.end_to_end;

import nl.novi.testjunitjupiter.TestJunitJupiterApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(CustomerController.class)
@SpringBootTest(classes = TestJunitJupiterApplication.class)
@AutoConfigureMockMvc
@EnableConfigurationProperties
class TestCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturn200() throws Exception {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnJson() throws Exception {

        mockMvc.perform(get("/customers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

}