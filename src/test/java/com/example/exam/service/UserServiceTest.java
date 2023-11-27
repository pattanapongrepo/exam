package com.example.exam.service;

import com.example.exam.entities.User;
import com.example.exam.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    public void setup() {
        user = User.builder().id(1).name("tom").age(1).build();
        System.out.println("Before data :" + user.toString());
    }

    @Test
    @DisplayName("test_getAll")
    void test_getAll() {
        var user1 = User.builder().id(2).name("tot").age(2).build();
        //given
        given(userRepository.findAll()).willReturn(List.of(user, user1));
        //when
        List<User> users = userService.getAll();
        //then
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("test_getNullLast")
    void test_getNullFirst() {
        var user1 = new User();
        var as = user1.getName().equals("A")? true: false;
    }
    
    @Test
    @DisplayName("test_getNullLast")
    void test_getNullLast() {
        var user1 = new User();
        var as = "A".equals(user1.getName())? true: false;
    }
}