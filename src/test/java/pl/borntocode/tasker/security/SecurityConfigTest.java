package pl.borntocode.tasker.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void accessToApiDenied() throws Exception {
        mockMvc.perform(get("/api"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void accessToRepositoryUsersDenied() throws Exception {
        mockMvc.perform(get("/api/users/"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void accessToTasksDenied() throws Exception {
        mockMvc.perform(get("/tasks"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void accessToSignIn() throws Exception {
        mockMvc.perform(get("/signin"))
                .andExpect(status().isOk());
    }

    @Test
    void accessToSignUp() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "test", password = "testowy")
    void expectSuccessfulLogin() throws Exception {
        mockMvc.perform(get("/signin"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/tasks/alltasks"))
                .andExpect(status().isOk());
    }

}