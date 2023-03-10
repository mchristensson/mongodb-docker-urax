package org.mac.urax;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mac.urax.ctrl.UraxRestController;
import org.mac.urax.model.PersonSearchResult;
import org.mac.urax.service.PersonService;
import org.mac.urax.service.PersonServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(UraxRestController.class)
public class UraxRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @AfterEach
    public void verifyMocks() {
        verifyNoMoreInteractions(personService);
    }

    @Test
    public void greeting_whenNoParam_ShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content")
                        .value("Hello, World!"));
    }

    @Test
    public void greeting_whenParam_ShouldReturnTailoredMessage() throws Exception {
        this.mockMvc.perform(get("/api/greeting")
                        .param("name", "Spring Community"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content")
                        .value("Hello, Spring Community!"));
    }

    @Test
    public void findperson_whenNoParam_ShouldReturnEmptyResult() throws Exception {
        PersonSearchResult mockResult = new PersonSearchResult();
        mockResult.setCount(0);
        when(personService.freeTextSearch(anyString())).thenReturn(mockResult);
        this.mockMvc.perform(get("/api/person/find"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count")
                        .value(0))
                .andExpect(jsonPath("$.result").isEmpty());

        verify(personService).freeTextSearch("");
    }

    @Test
    public void findperson_whenParam_ShouldReturnTailoredResult() throws Exception {
        PersonSearchResult mockResult = new PersonSearchResult();
        mockResult.setCount(2);
        when(personService.freeTextSearch(anyString())).thenReturn(mockResult);
        this.mockMvc
                .perform(get("/api/person/find")
                        .param("query", "Bob"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count")
                        .value(2))
                .andExpect(jsonPath("$.result").isEmpty());

        verify(personService).freeTextSearch("Bob");
    }

}
