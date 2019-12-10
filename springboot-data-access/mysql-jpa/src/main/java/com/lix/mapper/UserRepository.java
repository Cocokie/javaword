package com.lix.mapper;//package com.lix.repository;

import com.lix.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
