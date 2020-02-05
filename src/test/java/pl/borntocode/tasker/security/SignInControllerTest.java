package pl.borntocode.tasker.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SignInControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public RequestPostProcessor testUser() {
        return user("test").password("test");
    }

    @Test
    void signInPage() throws Exception {
        mockMvc.perform(get("/signin"))
                .andExpect(status().isOk())
                .andExpect(view().name("signin"))
                .andExpect(content().string(containsString("Tasker Repository")));
    }

    @Test
    void logInAsUser() throws Exception {
        mockMvc.perform(get("/signin")
                       .with(testUser()));
        mockMvc.perform((get("/tasks/alltasks")))
                .andExpect(result -> result.getResponse().setForwardedUrl("/tasks/alltasks"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/signin"))
                .andExpect(view().name("alltasks"));
    }

    @Test
    void logoutUser() throws Exception {
        mockMvc.perform(get("/signin").with(testUser()))
                .andExpect(redirectedUrl("/tasks/alltasks"));
        mockMvc.perform(get("/logout").with(testUser()))
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/index"));
    }

}