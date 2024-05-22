package Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.segundo_parcial.Controller.SubMenuController;
import com.example.segundo_parcial.model.SubMenu;
import com.example.segundo_parcial.repositories.SubMenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class SubMenuControllerTest {

    @Mock
    private SubMenuRepository mockSubMenuRepository;

    @InjectMocks
    private SubMenuController subMenuController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllSubMenus() {
        List<SubMenu> subMenus = new ArrayList<>();
        subMenus.add(new SubMenu());
        subMenus.add(new SubMenu());
        when(mockSubMenuRepository.findAll()).thenReturn(subMenus);

        List<SubMenu> result = subMenuController.getAllSubMenus();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetSubMenuById_WithValidId() {
        Long subMenuId = 1L;
        SubMenu subMenu = new SubMenu();
        when(mockSubMenuRepository.findById(subMenuId)).thenReturn(Optional.of(subMenu));

        SubMenu result = subMenuController.getSubMenuById(subMenuId);

        assertEquals(subMenu, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetSubMenuById_WithInvalidId() {
        Long subMenuId = 1L;
        when(mockSubMenuRepository.findById(subMenuId)).thenReturn(Optional.empty());

        subMenuController.getSubMenuById(subMenuId);
    }

    @Test
    public void testCreateSubMenu() {
        SubMenu subMenuToCreate = new SubMenu();
        subMenuToCreate.setSubmenuname("SubMenu1");
        when(mockSubMenuRepository.save(subMenuToCreate)).thenReturn(subMenuToCreate);

        SubMenu result = subMenuController.createSubMenu(subMenuToCreate);

        assertEquals(subMenuToCreate, result);
    }

    @Test
    public void testUpdateSubMenu() {
        Long subMenuId = 1L;
        SubMenu existingSubMenu = new SubMenu();
        existingSubMenu.setSubmenuId(subMenuId);
        existingSubMenu.setSubmenuname("SubMenu1");
        SubMenu updatedSubMenuDetails = new SubMenu();
        updatedSubMenuDetails.setSubmenuname("UpdatedSubMenu");
        when(mockSubMenuRepository.findById(subMenuId)).thenReturn(Optional.of(existingSubMenu));
        when(mockSubMenuRepository.save(any(SubMenu.class))).thenAnswer(invocation -> invocation.getArgument(0));

        SubMenu result = subMenuController.updateSubMenu(subMenuId, updatedSubMenuDetails);

        assertEquals(updatedSubMenuDetails.getSubmenuname(), result.getSubmenuname());
    }

    @Test
    public void testDeleteSubMenu() {
        Long subMenuId = 1L;
        SubMenu existingSubMenu = new SubMenu();
        existingSubMenu.setSubmenuId(subMenuId);
        existingSubMenu.setSubmenuname("SubMenu1");
        when(mockSubMenuRepository.findById(subMenuId)).thenReturn(Optional.of(existingSubMenu));

        subMenuController.deleteSubMenu(subMenuId);

        verify(mockSubMenuRepository, times(1)).delete(existingSubMenu);
    }
}
