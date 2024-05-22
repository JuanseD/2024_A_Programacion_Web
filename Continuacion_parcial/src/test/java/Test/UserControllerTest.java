package Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.segundo_parcial.Controller.UserController;
import com.example.segundo_parcial.model.User;
import com.example.segundo_parcial.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class UserControllerTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        when(mockUserRepository.findAll()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetUserById_WithValidId() {
        Long userId = 1L;
        User user = new User();
        when(mockUserRepository.findById(userId)).thenReturn(Optional.of(user));

        User result = userController.getUserById(userId);

        assertEquals(user, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetUserById_WithInvalidId() {
        Long userId = 1L;
        when(mockUserRepository.findById(userId)).thenReturn(Optional.empty());

        userController.getUserById(userId);
    }

    @Test
    public void testCreateUser() {
        User userToCreate = new User();
        userToCreate.setUsername("User1");
        when(mockUserRepository.save(userToCreate)).thenReturn(userToCreate);

        User result = userController.createUser(userToCreate);

        assertEquals(userToCreate, result);
    }

    @Test
    public void testUpdateUser() {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setIdUser(userId);
        existingUser.setUsername("User1");
        User updatedUserDetails = new User();
        updatedUserDetails.setUsername("UpdatedUser");
        when(mockUserRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(mockUserRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User result = userController.updateUser(userId, updatedUserDetails);

        assertEquals(updatedUserDetails.getUsername(), result.getUsername());
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setIdUser(userId);
        existingUser.setUsername("User1");
        when(mockUserRepository.findById(userId)).thenReturn(Optional.of(existingUser));

        userController.deleteUser(userId);

        verify(mockUserRepository, times(1)).delete(existingUser);
    }
}


