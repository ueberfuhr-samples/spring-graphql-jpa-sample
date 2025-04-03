package de.samples.graphql.graphqlsample.domain;

import de.samples.graphql.graphqlsample.domain.model.Post;
import de.samples.graphql.graphqlsample.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersInitializer {

  private final UserService userService;

  @EventListener(ContextRefreshedEvent.class)
  void initialize() {
    if (userService.count() == 0) {
      userService.createUser(
        User
          .builder()
          .name("John Doe")
          .email("john.doe@example.com")
          .posts(
            List.of(
              Post
                .builder()
                .content("Hello World Content")
                .title("Hello World")
                .build()
            )
          )
          .build()
      );
    }
  }

}
