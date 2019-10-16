package com.AlfExample.alfExample;

import com.AlfExample.alfExample.controllers.AlfController;
import com.AlfExample.alfExample.service.AlfService;
import com.AlfExample.alfExample.service.AlfServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AlfControllerIntegrationTests {
    private MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;

    @Mock
    private AlfService alfService;
    @InjectMocks
    private AlfController alfController;

    @Before
    public void setup() {
        alfController = new AlfController();
        this.mockMvc = standaloneSetup(this.alfController).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDisplayOutputWithANumberVariable() throws Exception {
        this.alfService = spy(AlfService.class);
        mockMvc.perform(get("/display/{number}", 5)).andDo(print())
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void testDisplayOutputWithAStringVariable() throws Exception {
        this.alfService = spy(AlfService.class);
        MvcResult result = mockMvc.perform(get("/display/{number}", "String")).andDo(print())
                .andExpect(status().is4xxClientError()).andReturn();
    }
}
