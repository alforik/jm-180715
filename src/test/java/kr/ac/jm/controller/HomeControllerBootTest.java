package kr.ac.jm.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class HomeControllerBootTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	
	@Autowired
	private WebApplicationContext context;
	
	//HomeController homeController;

	private MockMvc mvc;

	@Before
	public void setup(){
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		//this.mvc = MockMvcBuilders.webAppContextSetup(homeController).build();
	}

	@Test
	public void contextLoads() throws Exception {
		this.mvc.perform(post("/").param("test", "한글")).andDo(print())
		.andExpect(content().contentType("application/json;charset=utf-8"));
	}
	
}
