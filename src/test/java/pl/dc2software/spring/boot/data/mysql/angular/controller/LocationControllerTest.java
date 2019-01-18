package pl.dc2software.spring.boot.data.mysql.angular.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.dc2software.spring.boot.data.mysql.angular.service.LocationService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationController.class)
public class LocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    @Test
    public void saveLocation_success() throws Exception {
        mockMvc.perform(post("/location/save")
                .param("name", "Katowice")
                .param("code", "KAT")
                .param("description", "This is a great city modafuka!!!"))
                .andExpect(status().isOk());
    }
}
