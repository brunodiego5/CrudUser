package com.bdd.CrudUser.resource

import com.bdd.CrudUser.model.User
import com.bdd.CrudUser.repository.UserRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@RestController @RequestMapping(value = "/user") @EnableWebMvc
class UserResource(val userRepository: UserRepository) {

    @GetMapping(value = "/")
    fun getAll() = userRepository.findAll()

    @GetMapping(value = "/{id}")
    fun getOne(@PathVariable id: Long) = userRepository.findById(id)

    @PostMapping(value = "/")
    fun new(@RequestBody user: User) = userRepository.save(user)

    @DeleteMapping(value = "/{id}")
    fun delete(@PathVariable id: Long) = userRepository.deleteById(id)

    @PutMapping(value = "/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User): User {
        val userUpdate: User = userRepository.findById(id).orElseThrow { Exception("server error") }
        userUpdate.name = user.name
        userUpdate.email = user.email
        return userRepository.save(userUpdate)
    }
}