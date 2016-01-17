package com.saha.persistence.repository;

import com.saha.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    Collection<UserEntity> findByLastName(String param);

    UserEntity findByUserName(String param);

    UserEntity findByUserNameAndLastName(String userName, String lastName);


}
