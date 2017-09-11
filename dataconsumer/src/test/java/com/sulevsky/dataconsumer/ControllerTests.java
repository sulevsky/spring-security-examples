package com.sulevsky.dataconsumer;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ControllerTests {

    @Rule
    public WireMockRule crmStubServer = new WireMockRule(10177);

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        stubFor(WireMock.get(urlPathMatching("/message"))
                        .willReturn(aResponse()
                                            .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                                            .withBody("{" +
                                                      "\"id\": \"some_id\"," +
                                                      "\"content\": \"some_provider's content\"" +
                                                      "}")));
    }

    @Test
    public void respondsWithAggregatedMessage() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/")
                                              .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id", is("some_id")))
               .andExpect(jsonPath("$.providersContent", is("some_provider's content")))
               .andExpect(jsonPath("$.ownContent", notNullValue()));
    }
}
