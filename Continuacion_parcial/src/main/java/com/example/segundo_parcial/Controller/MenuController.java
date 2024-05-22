package com.example.segundo_parcial.Controller;

import com.example.segundo_parcial.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.segundo_parcial.repositories.MenuRepository;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/allmenus")
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @GetMapping("/searchmenu/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu not found with id: " + id));
    }

    @PostMapping("/createmenu")
    public Menu createMenu(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }

    @PutMapping("/updatemenu/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menuDetails) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu not found with id: " + id));

        menu.setMenuName(menuDetails.getMenuName());
        return menuRepository.save(menu);
    }

    @DeleteMapping("/deletemenu/{id}")
    public void deleteMenu(@PathVariable Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu not found with id: " + id));

        menuRepository.delete(menu);
    }
}

