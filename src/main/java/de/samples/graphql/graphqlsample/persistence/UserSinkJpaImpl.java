package de.samples.graphql.graphqlsample.persistence;

import de.samples.graphql.graphqlsample.domain.UserOptions;
import de.samples.graphql.graphqlsample.domain.UsersSink;
import de.samples.graphql.graphqlsample.domain.model.User;
import de.samples.graphql.graphqlsample.persistence.model.UserEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component // besser: @Configuration mit UserSink
@RequiredArgsConstructor
public class UserSinkJpaImpl implements UsersSink {

  private final UserEntityMapper mapper;
  private final UserEntityRepository repo;
  private final EntityManager em;

  @Override
  public void createUser(User user) {
    final var entity = mapper.map(user);
    repo.save(entity);
    user.setPosts(null); // avoid calling clear() on immutable list
    mapper.copy(entity, user);
  }

  @Override
  public Stream<User> getUsers(UserOptions userOptions) {
    // We build the EntityGraph dynamically here,
    // so we could not use the repository pattern.
    // otherwise, we could use: https://github.com/Cosium/spring-data-jpa-entity-graph
    var entityGraph = em.createEntityGraph(UserEntity.class);
    if (userOptions.isPosts()) {
      entityGraph.addSubgraph("posts");
    }
    return em
      .createQuery("select u from UserEntity u", UserEntity.class)
      .setHint("jakarta.persistence.fetchgraph", entityGraph)
      .getResultList()
      .stream()
      .map(mapper::map);
  }

  @Override
  public long count() {
    return repo.count();
  }
}
