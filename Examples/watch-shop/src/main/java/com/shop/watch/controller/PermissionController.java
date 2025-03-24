package com.shop.watch.controller;

import com.shop.watch.dto.request.PermissionCreate;
import com.shop.watch.model.PermissionModel;
import com.shop.watch.service.PermissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("Api/permission")
@Tag(name = "Permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public List<PermissionModel> getAllPermission(){
        return  permissionService.getAllPermission();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionModel> getPermissionById(@PathVariable Integer id) {
        PermissionModel permission = permissionService.getPermissionById(id);
        return ResponseEntity.ok(permission);
    }

    @PostMapping
    public ResponseEntity<PermissionModel> createPermission(@RequestBody PermissionCreate permissionCreate){
        PermissionModel permissionModel = permissionService.createPermission(permissionCreate);
        return ResponseEntity.ok(permissionModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionModel> updatePermission(@RequestParam Integer id, @RequestBody PermissionCreate permissionCreate){
        PermissionModel updatedPermission = permissionService.updatePermission(id, permissionCreate);
        return ResponseEntity.ok(updatedPermission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Integer id){
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}
