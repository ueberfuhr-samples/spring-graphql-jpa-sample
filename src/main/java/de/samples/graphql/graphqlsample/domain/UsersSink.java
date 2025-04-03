package de.samples.graphql.graphqlsample.domain;

import de.samples.graphql.graphqlsample.domain.model.User;

import java.util.stream.Stream;

public interface UsersSink {

  void createUser(User user);

  Stream<User> getUsers(UserOptions userOptions);

  long count();
}
