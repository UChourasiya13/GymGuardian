package com.example.GymManagementspring.Repository;

import com.example.GymManagementspring.Entity.EnquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepo extends JpaRepository<EnquiryEntity,Integer> {
}
