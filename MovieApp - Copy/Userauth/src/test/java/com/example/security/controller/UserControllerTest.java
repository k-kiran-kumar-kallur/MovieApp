package com.example.security.controller;

import com.example.security.exception.UserAlreadyExist;
import com.example.security.exception.UserNotFound;
import com.example.security.model.User;
import com.example.security.service.UserService;
import com.example.security.usercontroller.UserController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;
    private User user1,user2,user3;
    List<User> userList;

    @InjectMocks
    private UserController userControllerTest;

    @BeforeEach
    public void setup(){
        user1=new User("kiran","123456","kiran@123");
        user2=new User("samar","1234567","samar@123");
        user3=new User("anmol","123","anmol@123");
        userList= Arrays.asList(user1,user2,user3);
        mockMvc = MockMvcBuilders.standaloneSetup(userControllerTest).build();
    }
    @AfterEach
    public void tearDown(){
        user1=null;
        user2=null;
        user3=null;
    }
    @Test
    public void givenUserToRegisterAndReturnSuccess() throws Exception {
        when(userService.saveUser(any())).thenReturn(any());
        mockMvc.perform(post("/samar-api/register").contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(user1))).
                andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
        verify(userService,times(1)).saveUser(any());
    }

//    @Test
//    public void givenUserToRegisterAndReturnFailure() throws Exception{
//        when(userService.saveUser(any())).thenThrow(UserAlreadyExist.class);
//        mockMvc.perform(post("/samar-api/register").
//                        contentType(MediaType.APPLICATION_JSON).content(jsonToString(user1))).
//                andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//        verify(userService,times(1)).saveUser(any());
//    }
    //    @Test
//    public void givenUserToLoginAndReturnSuccess() throws Exception {
//        when(userService.findByUsernameAndPassword("kiran","123456")).thenReturn(user1);
//        mockMvc.perform(post("/samar-api/login").contentType(MediaType.APPLICATION_JSON).
//                        content(jsonToString(user1))).
//                andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//        verify(userService,times(1)).findByUsernameAndPassword(any(),any());
//    }
//            @Test
//    public void givenUserToLoginSuccess() throws Exception{
//        when(userService.findByEmailAndPassword(any())).thenReturn();
//    }
    private static String jsonToString(final Object ob) throws JsonProcessingException {
        String result;
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(ob);
            System.out.println("Json Content that has been posted:\n"+jsonContent);
            result = jsonContent;
        }
        catch(JsonProcessingException e) {
            result = "JSON processing error";
        }
        return result;
    }
}
