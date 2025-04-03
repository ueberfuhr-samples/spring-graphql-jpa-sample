package de.samples.graphql.graphqlsample.persistence;

import de.samples.graphql.graphqlsample.domain.model.Post;
import de.samples.graphql.graphqlsample.persistence.model.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
  componentModel = "spring"
)
public interface PostEntityMapper {

  PostEntity map(Post post);

  Post map(PostEntity post);

  void copy(PostEntity entity, @MappingTarget Post user);

}
