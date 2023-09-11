package jsf.osf.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import jsf.osf.demo.services.SejourService;
import jsf.osf.demo.services.UserService;

import java.util.Arrays;
import java.util.List;

@SpringJUnitConfig
@WebMvcTest(SejourController.class) // Replace YourController with your actual controller class name
@AutoConfigureMockMvc

public class SejourControllersTests {
    @MockBean
  private SejourService sejourService;

  @MockBean
    private UserService userService;

  @Autowired
  private MockMvc mvc;

  @Test
  public void getAllSejours_shouldReturnStatusOk() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/sejour/client"))
       .andExpect(status().isOk());
  }

}