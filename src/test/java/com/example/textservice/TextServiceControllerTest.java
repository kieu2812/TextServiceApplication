package com.example.textservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TextServiceController.class)
public class TextServiceControllerTest {

    @Autowired
    MockMvc mvc;
    @Test
    public void testGetCamelize() throws Exception{
        RequestBuilder request = get("/camelize")
                .param("original", "this_is_a_thing")
                .param("initialCap", "true");
        this.mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string("ThisIsAThing"));


    }
    @Test
    public void testGetCamelizeInitialCapFalse() throws Exception{
        RequestBuilder request = get("/camelize")
                .param("original", "this_is_a_thing")
                .param("initialCap", "false");
        this.mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string("thisIsAThing"));


    }

}
