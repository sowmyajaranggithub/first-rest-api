package com.in28minutes.springboot.firstrestapi.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = )
public interface UserDetailsRestRepository extends PagingAndSortingRepository<UserDetails, Long> {
List<UserDetails>findByRole(String role);
}
