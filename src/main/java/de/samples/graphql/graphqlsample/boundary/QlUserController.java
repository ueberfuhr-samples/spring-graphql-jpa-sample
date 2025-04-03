package de.samples.graphql.graphqlsample.boundary;

import de.samples.graphql.graphqlsample.boundary.model.QlUserDto;
import de.samples.graphql.graphqlsample.domain.UserOptions;
import de.samples.graphql.graphqlsample.domain.UserService;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class QlUserController {

  private final UserService userService;
  private final QlUserDtoMapper mapper;

  @QueryMapping
  public Stream<QlUserDto> getUsers(
    DataFetchingEnvironment env
  ) {
    return this.userService
      .getUsers(
        UserOptions
          .builder()
          .posts(env.getSelectionSet().contains("posts"))
          .build()
      )
      .map(mapper::map);
  }


}
