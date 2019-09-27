package com.jcombat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jcombat.dao.LoginModal;

public interface LoginRepository extends JpaRepository<LoginModal, Long>{

}
