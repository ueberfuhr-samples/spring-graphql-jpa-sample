package de.samples.graphql.graphqlsample.boundary;

import de.samples.graphql.graphqlsample.boundary.model.QlPostDto;
import de.samples.graphql.graphqlsample.domain.model.Post;
import org.mapstruct.Mapper;

@Mapper(
  componentModel = "spring"
)
public interface QlPostDtoMapper {

  QlPostDto map(Post post);

  Post map(QlPostDto post);

}
