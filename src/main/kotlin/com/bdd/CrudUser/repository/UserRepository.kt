package com.bdd.CrudUser.repository

import com.bdd.CrudUser.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>