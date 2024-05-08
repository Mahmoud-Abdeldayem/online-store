package com.estore.users.Repositories;

import com.estore.users.models.CustomerDetails;
import com.estore.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, Long> {

    //public String findByEmail(String email);
}
