package de.samples.graphql.graphqlsample.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserOptions {

  @Builder.Default
  private final boolean posts = true;

}
