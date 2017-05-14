package com.revature.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.beans.Post;
import com.revature.controllers.PostController;

public class PostControllerTest {

	@InjectMocks
    private PostController postController;
 
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

	@Test
	public void testReportPost() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetThread() {
		fail("Not yet implemented");
	}

	@Test
	public void testFlagPost() {
		fail("Not yet implemented");
	}

	@Test
	public void testIgnoreFlag() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfirmDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemovePost() {
		fail("Not yet implemented");
	}

	@Test
	public void testListImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testListThumb() {
		fail("Not yet implemented");
	}

	@Test
	public void testResizeImage() {
		fail("Not yet implemented");
	}

}
