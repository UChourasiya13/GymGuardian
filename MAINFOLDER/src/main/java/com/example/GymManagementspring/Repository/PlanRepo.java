package com.example.GymManagementspring.Repository;

import com.example.GymManagementspring.Entity.EnquiryEntity;
import com.example.GymManagementspring.Entity.EquipmentEntity;
import com.example.GymManagementspring.Entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepo extends JpaRepository<PlanEntity,Integer> {
}
