package de.samples.graphql.graphqlsample.boundary.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QlPostDto {

  private Long id;
  private String title;
  private String content;
}
