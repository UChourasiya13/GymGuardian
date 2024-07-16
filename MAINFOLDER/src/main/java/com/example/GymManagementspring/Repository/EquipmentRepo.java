package com.example.GymManagementspring.Repository;

import com.example.GymManagementspring.Entity.EnquiryEntity;
import com.example.GymManagementspring.Entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository<EquipmentEntity,Integer> {
}
