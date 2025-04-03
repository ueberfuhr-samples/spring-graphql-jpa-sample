package de.samples.graphql.graphqlsample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GraphqlSampleApplicationTests {

  @Autowired
  MockMvc mockMvc;

  @Test
  void shouldReturnPosts() throws Exception {
    mockMvc
      .perform(
        post("/graphql")
          .accept(MediaType.APPLICATION_JSON, MediaType.MULTIPART_MIXED)
          .contentType(MediaType.APPLICATION_JSON)
          .content("""
            {
               "query": "query { getUsers {id}}"
            }
            """)
      )
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.data.getUsers").isArray());

  }

}
