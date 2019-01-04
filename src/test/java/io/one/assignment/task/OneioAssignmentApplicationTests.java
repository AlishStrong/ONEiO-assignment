package io.one.assignment.task;

import io.one.assignment.task.controller.FizzBuzzController;
import io.one.assignment.task.service.FizzBuzzService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OneioAssignmentApplicationTests {

    private String input;
    private String output;

    @Before
    public void setUp() {
        output = "output";
    }

    @Autowired
    private FizzBuzzController controller;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FizzBuzzService service;

    @Test
    public void testProcessWithCorrectInputData() throws Exception {
        input = "1,2,3";
        FizzBuzzService fizzBuzzService = new FizzBuzzService();
        output = fizzBuzzService.validateInput(input);
        when(service.validateInput(input)).thenReturn(output);
        mvc.perform(post("/process").param("input", input))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(content().string(containsString("<title>Output page</title>")));
    }

    @Test
    public void testProcessWithIncorrectInputData() throws Exception {
        input = "1,2, , ";
        FizzBuzzService fizzBuzzService = new FizzBuzzService();
        output = fizzBuzzService.validateInput(input);
        when(service.validateInput(input)).thenReturn(output);
        mvc.perform(post("/process").param("input", input))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(content().string(containsString("Please, input number/s")));
    }

    @Test
    public void testIndex() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("<title>ONEiO assignment</title>"))
                );
    }

    @Test
    public void testInput() throws Exception {
        mvc.perform(get("/input"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("<title>Input page</title>"))
                );
    }
}
