package com.ada.album.transacao.handle;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class CustomExceptionHandlerTest {

    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new CustomExceptionHandler()).build();

    @Test
    public void testHandleErrorException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/test")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
