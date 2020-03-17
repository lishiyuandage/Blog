package com.bigbrotherlee.leeblog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.net.URLEncoder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml"})
@WebAppConfiguration
public class AdminControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext; 
	private MockMvc mockMvc;
	public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
		this.webApplicationContext = webApplicationContext;
	}
	@Before
	public void init() {
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/user/search/"+URLEncoder.encode("李", "utf-8")+"/1/10").accept(MediaType.APPLICATION_JSON));
	}
	@Test
	public void test2() throws Exception {
		mockMvc.perform(post("/user/login").param("userCode", "001").param("userPassword", "123456"));
	}
	@Test
	public void test3() throws Exception {
		mockMvc.perform(get("/user/search/001/"+URLEncoder.encode("李", "utf-8")+"/12/1/1/10"));
	}

}
