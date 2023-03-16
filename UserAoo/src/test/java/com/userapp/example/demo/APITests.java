package com.userapp.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class APITests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEndpoint() throws Exception {
        MvcResult result = mockMvc.perform(get("/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testPostEndpoint() throws Exception {
        String requestBody =
                "{ \"firstName\": \"Leonid\", \"lastName\": \"Starobinski\"" +
                ",\"email\": \"leonstarobinski@gmail.com\", \"password\": \"theBestPassword123!\"," +
                        "\"birthday\": \"16.09.1994\"}";

        MvcResult result = mockMvc.perform(post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void testPutEndpoint() throws Exception {

        String requestBody = "{ \"firstName\": \"Leonid\", \"lastName\": \"Starobinski\"" +
                ",\"email\": \"8lsrage@gmail.com\", \"password\": \"theBestPassword123!\"," +
                "\"birthday\": \"16.09.1994\"}";


        MvcResult result = mockMvc.perform(put("/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void testDeleteEndpoint() throws Exception {
        MvcResult result = mockMvc.perform(delete("/delete/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
