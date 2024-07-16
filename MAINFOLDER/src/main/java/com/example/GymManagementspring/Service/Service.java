package com.example.GymManagementspring.Service;

import com.example.GymManagementspring.Entity.EnquiryEntity;
import com.example.GymManagementspring.Entity.EquipmentEntity;
import com.example.GymManagementspring.Entity.MemberEntity;
import com.example.GymManagementspring.Entity.PlanEntity;
import com.example.GymManagementspring.Repository.EnquiryRepo;
import com.example.GymManagementspring.Repository.EquipmentRepo;
import com.example.GymManagementspring.Repository.MemberRepo;
import com.example.GymManagementspring.Repository.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Member;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private EnquiryRepo enquiryRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private MemberRepo memberRepo;

    // for plan
    public void addEnquiry(EnquiryEntity e)
    {
        enquiryRepo.save(e);
    }

    public List<EnquiryEntity> getEnquiry(){

        return enquiryRepo.findAll();
    }
    // for Equipment
    public void addEquipment(EquipmentEntity e)
    {
        equipmentRepo.save(e);
    }

    public List<EquipmentEntity> getEquipment(){

        return equipmentRepo.findAll();
    }

    // for Plan
    public void addPlan(PlanEntity e)
    {
        planRepo.save(e);
    }

    public List<PlanEntity> getPlan(){

        return planRepo.findAll();
    }

    public void addMember(MemberEntity e)
    {
        memberRepo.save(e);
    }

    public List<MemberEntity> getMember(){

        return memberRepo.findAll();
    }

}
