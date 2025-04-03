package de.samples.graphql.graphqlsample.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Post {

  private Long id;
  private String title;
  private String content;
}
