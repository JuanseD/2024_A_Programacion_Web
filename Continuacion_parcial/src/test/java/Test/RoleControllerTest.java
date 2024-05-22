package Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.segundo_parcial.Controller.RoleController;
import com.example.segundo_parcial.model.Role;
import com.example.segundo_parcial.repositories.RoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class RoleControllerTest {

    @Mock
    private RoleRepository mockRoleRepository;

    @InjectMocks
    private RoleController roleController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role());
        roles.add(new Role());
        when(mockRoleRepository.findAll()).thenReturn(roles);

        List<Role> result = roleController.getAllRoles();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetRoleById_WithValidId() {
        Long roleId = 1L;
        Role role = new Role();
        when(mockRoleRepository.findById(roleId)).thenReturn(Optional.of(role));

        Role result = roleController.getRoleById(roleId);

        assertEquals(role, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetRoleById_WithInvalidId() {
        Long roleId = 1L;
        when(mockRoleRepository.findById(roleId)).thenReturn(Optional.empty());

        roleController.getRoleById(roleId);
    }

    @Test
    public void testCreateRole() {
        Role roleToCreate = new Role();
        roleToCreate.setRoleName("Role1");
        when(mockRoleRepository.save(roleToCreate)).thenReturn(roleToCreate);

        Role result = roleController.createRole(roleToCreate);

        assertEquals(roleToCreate, result);
    }

    @Test
    public void testUpdateRole() {
        Long roleId = 1L;
        Role existingRole = new Role();
        existingRole.setRoleId(roleId);
        existingRole.setRoleName("Role1");
        Role updatedRoleDetails = new Role();
        updatedRoleDetails.setRoleName("UpdatedRole");
        when(mockRoleRepository.findById(roleId)).thenReturn(Optional.of(existingRole));
        when(mockRoleRepository.save(any(Role.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Role result = roleController.updateRole(roleId, updatedRoleDetails);

        assertEquals(updatedRoleDetails.getRoleName(), result.getRoleName());
    }

    @Test
    public void testDeleteRole() {
        Long roleId = 1L;
        Role existingRole = new Role();
        existingRole.setRoleId(roleId);
        existingRole.setRoleName("Role1");
        when(mockRoleRepository.findById(roleId)).thenReturn(Optional.of(existingRole));

        roleController.deleteRole(roleId);

        verify(mockRoleRepository, times(1)).delete(existingRole);
    }
}

