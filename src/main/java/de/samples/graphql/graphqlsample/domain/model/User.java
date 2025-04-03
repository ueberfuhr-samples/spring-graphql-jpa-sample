package de.samples.graphql.graphqlsample.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class User {

  private Long id;
  private String name;
  private String email;
  @Setter
  private List<Post> posts;

}
