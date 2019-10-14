package com.AlfExample.alfExample;

import com.AlfExample.alfExample.controllers.AlfController;
import com.AlfExample.alfExample.service.AlfService;
import com.AlfExample.alfExample.service.AlfServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AlfControllerTests {
    private MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;
    @MockBean
    private AlfService alfServiceMock;
    @Autowired
    private AlfController alfController;
    String displayedText;


    @Before
    public void setup(){
        alfController = new AlfController();
        this.mockMvc = standaloneSetup(this.alfController).build();
        displayedText = "The list is: [1, 2, alfredo, 4, buzz]. Report: fizz 0, buzz 1, fizzbuzz 0, alfredo 1, integer 3";
    }
    @Test
    public void testDisplayOutput() throws Exception {
   /* when(alfServiceMock.printFizzBuzz(any(Integer.class))).thenReturn(displayedText);
    mockMvc.perform(get("/display/{number}", 5)).andExpect(status().isOk());*/
    }
}
