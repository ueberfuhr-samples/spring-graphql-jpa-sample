package de.samples.graphql.graphqlsample.boundary.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QlUserDto {

  private Long id;
  private String name;
  private String email;
  private List<QlPostDto> posts;

}
