package com.sistematestejava.sistemasubestacao.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SubestacaoControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/subestacao"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetById() throws Exception {
        mockMvc.perform(get("/subestacao/{id}", 1))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetByNome() throws Exception {
        mockMvc.perform(get("/subestacao/nome/{nome}", "Subestacao"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testPost() throws Exception {
        String newSubestacao = "{\"nome\": \"Subestacao Teste\", \"codigo\": \"ST1\"}";
        
        mockMvc.perform(post("/subestacao")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newSubestacao))
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testPut() throws Exception {
        String updatedSubestacao = "{\"id\": 1, \"nome\": \"Subestacao Atualizada\", \"codigo\": \"SA1\"}";

        mockMvc.perform(put("/subestacao")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedSubestacao))
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/subestacao/{id}", 1))
            .andExpect(status().isNoContent());
    }
}