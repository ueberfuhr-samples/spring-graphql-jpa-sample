package de.samples.graphql.graphqlsample.boundary;

import de.samples.graphql.graphqlsample.boundary.model.QlUserDto;
import de.samples.graphql.graphqlsample.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(
  componentModel = "spring",
  uses = QlPostDtoMapper.class
)
public interface QlUserDtoMapper {

  QlUserDto map(User user);

  User map(QlUserDto user);

}
