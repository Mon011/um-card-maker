package com.monodev.ummaker.user

import com.monodev.ummaker.user.dto.request.SaveUserRequest
import com.monodev.ummaker.user.exception.UserAlreadyExistsException
import com.monodev.ummaker.user.exception.UserNotFoundException
import spock.lang.Specification

class UserServiceTest extends Specification {


    private def userRepository = Mock(UserRepository)
    private def userService = new UserService(userRepository)


    def "should return user details"() {
        given:
        userRepository.findById(_ as Long) >> Optional.of(testUser())

        when:
        def result = userService.findUserById(1L)

        then:
        result.id == 1L
        result.username == "John"
        result.picture == "test.png"
    }

    def "should throw UserNotFoundException"() {
        given:
        userRepository.findById(_ as Long) >> Optional.empty()

        when:
        userService.removeUserById(1L)

        then:
        thrown(UserNotFoundException)
    }

    def "should throw UserAlreadyExistsException"() {
        given:
        userRepository.findByUsername(_ as String) >> Optional.of(testUser())

        when:
        userService.saveUser(new SaveUserRequest(testUser().username, testUser().picture))

        then:
        thrown(UserAlreadyExistsException)
    }

    private static def testUser() {
        return new User()
                .setId(1L)
                .setUsername("John")
                .setPicture("test.png")
    }

}
