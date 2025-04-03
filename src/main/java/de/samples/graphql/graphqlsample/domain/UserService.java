package de.samples.graphql.graphqlsample.domain;

import de.samples.graphql.graphqlsample.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UsersSink sink;

  public void createUser(User user) {
    sink.createUser(user);
  }

  public Stream<User> getUsers() {
    return this.getUsers(
      UserOptions
        .builder()
        .build()
    );
  }

  public Stream<User> getUsers(UserOptions userOptions) {
    return sink.getUsers(userOptions);
  }

  public long count() {
    return sink.count();
  }

}
