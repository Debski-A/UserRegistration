package com.adamdebski.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(secure = false, controllers = { HomeController.class })
public class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private HomeController homeController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
	}

	@Test
	public void shouldReturnPageTitle() throws Exception {
		this.mockMvc.perform(get("/?lang=pl")).andExpect(status().isOk())
				.andExpect(content().string(containsString("<title>Rób swoje</title>")));
	}

	@Test
	public void shouldReturnPageTitleEN() throws Exception {
		this.mockMvc.perform(get("/?lang=en")).andExpect(status().isOk())
				.andExpect(content().string(containsString("<title>Do Your job dude</title>")));
	}

	@Test
	public void shouldReturnHomeView() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"));
	}
	
	@Test
	public void shouldReturnLoginView() throws Exception {
		this.mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("home"));
	}
}
