package Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.segundo_parcial.Controller.MenuController;
import com.example.segundo_parcial.model.Menu;
import com.example.segundo_parcial.repositories.MenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class MenuControllerTest {

    @Mock
    private MenuRepository mockMenuRepository;

    @InjectMocks
    private MenuController menuController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllMenus() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu());
        menus.add(new Menu());
        when(mockMenuRepository.findAll()).thenReturn(menus);

        List<Menu> result = menuController.getAllMenus();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetMenuById_WithValidId() {
        Long menuId = 1L;
        Menu menu = new Menu();
        when(mockMenuRepository.findById(menuId)).thenReturn(Optional.of(menu));

        Menu result = menuController.getMenuById(menuId);

        assertEquals(menu, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetMenuById_WithInvalidId() {
        Long menuId = 1L;
        when(mockMenuRepository.findById(menuId)).thenReturn(Optional.empty());

        menuController.getMenuById(menuId);
    }

    @Test
    public void testCreateMenu() {
        Menu menuToCreate = new Menu();
        menuToCreate.setMenuName("Menu1");
        when(mockMenuRepository.save(menuToCreate)).thenReturn(menuToCreate);

        Menu result = menuController.createMenu(menuToCreate);

        assertEquals(menuToCreate, result);
    }

    @Test
    public void testUpdateMenu() {
        Long menuId = 1L;
        Menu existingMenu = new Menu();
        existingMenu.setMenuId(menuId);
        existingMenu.setMenuName("Menu1");
        Menu updatedMenuDetails = new Menu();
        updatedMenuDetails.setMenuName("UpdatedMenu");
        when(mockMenuRepository.findById(menuId)).thenReturn(Optional.of(existingMenu));
        when(mockMenuRepository.save(any(Menu.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Menu result = menuController.updateMenu(menuId, updatedMenuDetails);

        assertEquals(updatedMenuDetails.getMenuName(), result.getMenuName());
    }

    @Test
    public void testDeleteMenu() {
        Long menuId = 1L;
        Menu existingMenu = new Menu();
        existingMenu.setMenuId(menuId);
        existingMenu.setMenuName("Menu1");
        when(mockMenuRepository.findById(menuId)).thenReturn(Optional.of(existingMenu));

        menuController.deleteMenu(menuId);

        verify(mockMenuRepository, times(1)).delete(existingMenu);
    }
}
