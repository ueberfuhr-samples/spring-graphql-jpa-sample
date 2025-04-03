package de.samples.graphql.graphqlsample.persistence;

import de.samples.graphql.graphqlsample.domain.model.User;
import de.samples.graphql.graphqlsample.persistence.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
  componentModel = "spring",
  uses = PostEntityMapper.class
)
public interface UserEntityMapper {

  UserEntity map(User user);

  /*
   * Independent from Hibernate: Use the EntityManager
   * em
   *  .getEntityManagerFactory()
   *  .getPersistenceUnitUtil()
   *  .isLoaded(entity, "posts")
   */

  @Mapping(
    target = "posts",
    conditionExpression = "java(org.hibernate.Hibernate.isInitialized(entity.getPosts()))"
  )
  User map(UserEntity entity);

  @Mapping(
    target = "posts",
    conditionExpression = "java(org.hibernate.Hibernate.isInitialized(entity.getPosts()))"
  )
  void copy(UserEntity entity, @MappingTarget User user);

}
