package za.ac.cput.repository;
// User UserRepositoryImplTest  class
//Author: Bonga Velem (220052379)
//Date: 27 March 2025
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.repository.impl.UserRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private static UserRepositoryImpl repository;
    private static User user;


    @BeforeEach
    void setUp() {
        repository = (UserRepositoryImpl) UserRepositoryImpl.getRepository();
        user = new User.Builder()
                .setUserId(1)
                .setName("Bonga Velem")
                .setEmail("bongavelem@example.com")
                .setPhoneNumber("0798135811")
                .setLicenseNumber("ABC12345")
                .build();
    }


    @Test
    void create() {
        User createdUser = repository.create(user);
        assertNotNull(createdUser);
        assertEquals(user.getUserId(), createdUser.getUserId());
        assertEquals(user.getEmail(), createdUser.getEmail());

    }

    @Test
    void read() {
        repository.create(user);
        User retrievedUser = repository.read(user.getUserId());
        assertNotNull(retrievedUser);
        assertEquals(user.getUserId(), retrievedUser.getUserId());
        assertEquals(user.getName(), retrievedUser.getName());
    }

    @Test
    void update() {
        repository.create(user);


        User updatedUser = new User.Builder()
                .copy(user)
                .setName("Bonga Velem")
                .setEmail("bongav22@gmail.com")
                .build();

        User result = repository.update(updatedUser);
        assertNotNull(result);
        assertEquals("Bonga Velem", result.getName());
        assertEquals("bongav22@gmail.com", result.getEmail());
    }



    @Test
     void delete() {
        repository.create(user);
        repository.delete(user.getUserId());
        User deletedUser = repository.read(user.getUserId());
        assertNull(deletedUser);
    }


}