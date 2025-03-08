package com.shop.watch.repository;
import com.shop.watch.model.PermissionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionModel, Integer> {
}
