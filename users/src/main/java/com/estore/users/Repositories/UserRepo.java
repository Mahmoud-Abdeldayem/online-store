package com.estore.users.Repositories;

import com.estore.users.UserRole;
import com.estore.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Long> {
    public User getUsersByRole(UserRole role);
    public User findByEmail(String email);
    public void deleteByEmail(String email);
    @Query("SELECT u.id FROM User u WHERE u.email = :email")
    public Long getIdByEmail(@Param("email") String email);
}
