package com.sistematestejava.sistemasubestacao.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.sistematestejava.sistemasubestacao.model.RedeMT;

@SpringBootTest
@AutoConfigureMockMvc
public class RedeMTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/redeMT"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetById() throws Exception {
        Long id = 1L;

        mockMvc.perform(get("/redeMT/{id}", id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetByNome() throws Exception {
        String nome = "ExampleName";

        mockMvc.perform(get("/redeMT/nome/{nome}", nome))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testPost() throws Exception {
        RedeMT newRedeMT = new RedeMT();
        newRedeMT.setNome("New RedeMT");
        newRedeMT.setCodigo("NT1");

        mockMvc.perform(post("/redeMT")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newRedeMT)))
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testPut() throws Exception {
        Long id = 1L;
        
        RedeMT updateRedeMT = new RedeMT();
        updateRedeMT.setId(id);
        updateRedeMT.setNome("Updated RedeMT");
        updateRedeMT.setCodigo("UT1");

        mockMvc.perform(put("/redeMT")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateRedeMT)))
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDelete() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/redeMT/{id}", id))
            .andExpect(status().isNoContent());
    }
}

