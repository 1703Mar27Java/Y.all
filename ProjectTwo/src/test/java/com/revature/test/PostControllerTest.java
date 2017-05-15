/*package com.revature.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.*;

import org.junit.*;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.beans.Post;
import com.revature.controllers.PostController;
import com.revature.dao.PostDao;

public class PostControllerTest {

	@InjectMocks
    private PostController postController;
	
	@Mock
	private PostDao postDao;
 
    private MockMvc mockMvc;
    
    @Before
    public void setup() { 
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(postController).build(); 
    }
	
	@Test
	public void testGetThreads() throws Exception {
		Post testPost = new Post();
		List<Post> listPosts = Arrays.asList(testPost);
		this.mockMvc.perform(get("/catalog"))
            .andExpect(status().isOk())
            .andExpect(forwardedUrl("catalog"));
	}

	@Test
	public void testAddPost() throws Exception {
	    Post p = new Post();
	    mockMvc.perform(
	            post("/post"))
	            .andExpect(forwardedUrl("result"));
	}

}
*/