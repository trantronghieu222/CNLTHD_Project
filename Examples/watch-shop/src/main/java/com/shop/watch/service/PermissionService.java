package com.shop.watch.service;
import com.shop.watch.dto.request.PermissionCreate;
import com.shop.watch.model.PermissionModel;
import com.shop.watch.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public List<PermissionModel> getAllPermission(){
        return permissionRepository.findAll();
    }

    public PermissionModel getPermissionById(Integer id){
        return permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found"));
    }

    public PermissionModel createPermission(PermissionCreate permission){
        PermissionModel permissionModel = new PermissionModel();
        permissionModel.setPermissionName(permission.getPermissionName());
        return permissionRepository.save(permissionModel);
    }

    public PermissionModel updatePermission(Integer id, PermissionCreate permission){
        PermissionModel permissionModel = getPermissionById(id);
        permissionModel.setPermissionName(permission.getPermissionName());
        return permissionRepository.save(permissionModel);
    }

    public void deletePermission(Integer id){
        permissionRepository.deleteById(id);
    }
}
