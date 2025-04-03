package de.samples.graphql.graphqlsample.persistence.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<PostEntity> posts;

//    public List<PostEntity> getPosts() {
//        return Hibernate.isInitialized(posts) ? posts : List.of();
//    }


}
