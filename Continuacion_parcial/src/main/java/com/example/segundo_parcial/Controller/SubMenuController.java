package com.example.segundo_parcial.Controller;

import com.example.segundo_parcial.model.SubMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.segundo_parcial.repositories.SubMenuRepository;

import java.util.List;

@RestController
@RequestMapping("/submenus")
public class SubMenuController {

    @Autowired
    private SubMenuRepository subMenuRepository;

    @GetMapping("/allsubmenus")
    public List<SubMenu> getAllSubMenus() {
        return subMenuRepository.findAll();
    }

    @GetMapping("/searchsubmenu/{id}")
    public SubMenu getSubMenuById(@PathVariable Long id) {
        return subMenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubMenu not found with id: " + id));
    }

    @PostMapping("/createsubmenu")
    public SubMenu createSubMenu(@RequestBody SubMenu subMenu) {
        return subMenuRepository.save(subMenu);
    }

    @PutMapping("/updatesubmenu/{id}")
    public SubMenu updateSubMenu(@PathVariable Long id, @RequestBody SubMenu subMenuDetails) {
        SubMenu subMenu = subMenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubMenu not found with id: " + id));

        subMenu.setSubmenuname(subMenuDetails.getSubmenuname());
        return subMenuRepository.save(subMenu);
    }

    @DeleteMapping("/deletesubmenu/{id}")
    public void deleteSubMenu(@PathVariable Long id) {
        SubMenu subMenu = subMenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubMenu not found with id: " + id));

        subMenuRepository.delete(subMenu);
    }
}
