package hello.controller;

import hello.Application;
import hello.DemoApplication;
import hello.model.EventModel;
import hello.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by kevin on 30/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest({"server.port=8080"})
public class EventControllerTest {

    @Autowired
    EventRepository eventRepository;

    @Before
    public void setUp() {
        EventModel eventModel = new EventModel("12/11/2016", "Event1", "Devops");
        EventModel eventModel2 = new EventModel("12/11/2016", "Event2", "Java");
        EventModel eventModel3 = new EventModel("12/11/2016", "Event3", "Android");

        eventRepository.save(eventModel);
        eventRepository.save(eventModel2);
        eventRepository.save(eventModel3);
    }


    @Test
    public void should_create_event_market() {

        given().param("date", "12/11/2012").param("nom", "hello123").param("description", "Market for fun")
                .when().post("/event").then().log().all()
                .body("date", is("12/11/2012"))
                .body("name", is("hello123"))
                .body("description", is("Market for fun"));
    }

    @Test
    public void fail_create_event_market() {


//        given().param("date","12/11/2012").param("nom","hello123").param("description","Market for fun")
//                .when().post("/event").then().log().all()
//                .body("date",is("12/11/2012"))
//                .body("name", is("hello"))
//                .body("description",is("Market for fun"));
    }
}