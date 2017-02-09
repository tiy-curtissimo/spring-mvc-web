package com.theironyard;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.theironyard.controllers.PeopleController;
import com.theironyard.models.Person;
import com.theironyard.services.PersonDao;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PeopleController.class)
@AutoConfigureMockMvc(secure=false)
public class PeopleControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private PersonDao daoMock;

    private Person person;
    private List<Person> people;
    
    @Before
    public void setUpProduct() throws Exception{
        person = new Person();
        person.setId(1);
        person.setFirstName("Curtis");
        person.setLastName("Schlak");
        person.setMiddleInitial("X");
        
        people = new ArrayList<Person>();
        people.add(person);
    }
    
    @Test
    public void indexPutsPeopleInTheModel() throws Exception {
    		when(daoMock.getPeople()).thenReturn(people);
    		mockMvc.perform(get("/people"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("text/html;charset=UTF-8"))
			.andExpect(view().name("people/list"))
			.andExpect(model().attribute("people", is(people)));
    }
    
    @Test
    public void indexPutsNullInTheModel() throws Exception {
    		when(daoMock.getPeople()).thenReturn(null);
    		mockMvc.perform(get("/people"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("text/html;charset=UTF-8"))
			.andExpect(view().name("people/list"))
			.andExpect(model().attribute("people", is(nullValue())));
    }
}



