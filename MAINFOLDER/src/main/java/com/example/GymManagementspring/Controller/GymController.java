package com.example.GymManagementspring.Controller;

import com.example.GymManagementspring.Entity.EnquiryEntity;
import com.example.GymManagementspring.Entity.EquipmentEntity;
import com.example.GymManagementspring.Entity.MemberEntity;
import com.example.GymManagementspring.Entity.PlanEntity;
import com.example.GymManagementspring.Repository.EnquiryRepo;
import com.example.GymManagementspring.Repository.EquipmentRepo;
import com.example.GymManagementspring.Repository.MemberRepo;
import com.example.GymManagementspring.Repository.PlanRepo;
import com.example.GymManagementspring.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class GymController {
    @Autowired
    private Service service;
    @Autowired
    private EnquiryRepo enquiryRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private MemberRepo memberRepo;

    @RequestMapping(path="/",method = RequestMethod.GET)
    public String home(Model m){
        List<EnquiryEntity> enquiry=service.getEnquiry();
        List<EquipmentEntity> equipment=service.getEquipment();
        List<PlanEntity> plan=service.getPlan();
        List<MemberEntity> member=service.getMember();
        long ec=0;
        long eqc=0;
        long pc=0;
        long mc=0;
        ec=enquiry.stream().count();
        eqc=equipment.stream().count();
        pc=plan.stream().count();
        mc=member.stream().count();
        m.addAttribute("ecount",ec);
        m.addAttribute("eqcount",eqc);
        m.addAttribute("pcount",pc);
        m.addAttribute("mcount",mc);
        return "index";
    }

    @RequestMapping(path="/show_enquiry",method = RequestMethod.GET)
    public String showEnquiryForm(){
        return "add_Enquiry";
    }
    
    @RequestMapping(path="/add_enquiry",method = RequestMethod.POST)
    public String addEnquiry(EnquiryEntity e, Model m, HttpSession session){
        service.addEnquiry(e);
        session.setAttribute("msg","Enquiry Added Successfully..");
        return "redirect:/view_enquiry";
    }
    
    @RequestMapping(path="/view_enquiry",method = RequestMethod.GET)
    public String getEnquiry(Model m){
        List<EnquiryEntity> doc=service.getEnquiry();
        m.addAttribute("doc",doc);
        return "view_Enquiry";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        EnquiryEntity user = enquiryRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_Enquiry";
    }
    @RequestMapping(path = "/update_enquiry/{id}",method = RequestMethod.POST)
    public String updateEnquiry(@PathVariable("id") int id, EnquiryEntity d, BindingResult result, Model m, HttpSession session){
        if(result.hasErrors()){
            d.setId(id);
            return "update_Enquiry";
        }
        service.addEnquiry(d);
        session.setAttribute("msg","Enquiry Updated Successfully..");
        return "redirect:/view_enquiry";
    }
    @GetMapping("/delete/{id}")
    public String deleteEnq(@PathVariable("id") int id, Model model) {
        EnquiryEntity user = enquiryRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        enquiryRepo.delete(user);
        return "redirect:/view_enquiry";
    }


    @RequestMapping(path="/show_enquiry_eq",method = RequestMethod.GET)
    public String showEnquiryFormEq(){
        return "add_Equipment";
    }
    @RequestMapping(path="/add_equipment",method = RequestMethod.POST)
    public String addEquipment(EquipmentEntity e, Model m, HttpSession session){
        service.addEquipment(e);
        session.setAttribute("msg","Equipment Added Successfully..");
        return "redirect:/view_equipment";
    }
    @RequestMapping(path="/view_equipment",method = RequestMethod.GET)
    public String getEquipment(Model m){
        List<EquipmentEntity> doc=service.getEquipment();
        m.addAttribute("doc",doc);
        return "view_Equipment";
    }
    @GetMapping("/edit_eq/{id}")
    public String showUpdateFormEq(@PathVariable("id") int id, Model model) {
        EquipmentEntity user = equipmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_Equipment";
    }
    @RequestMapping(path = "/update_equipment/{id}",method = RequestMethod.POST)
    public String updateEq(@PathVariable("id") int id, EquipmentEntity d, BindingResult result, Model m, HttpSession session){
        if(result.hasErrors()){
            d.setId(id);
            return "update_Equipment";
        }
        service.addEquipment(d);
        session.setAttribute("msg","Equipment Updated Successfully..");
        return "redirect:/view_equipment";
    }
    @GetMapping("/delete_eq/{id}")
    public String deleteEq(@PathVariable("id") int id, Model model) {
        EquipmentEntity user = equipmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        equipmentRepo.delete(user);
        return "redirect:/view_equipment";
    }


    @RequestMapping(path="/show_plan",method = RequestMethod.GET)
    public String showPlan(){
        return "add_Plan";
    }
    @RequestMapping(path="/add_plan",method = RequestMethod.POST)
    public String addPlan(PlanEntity e, Model m, HttpSession session){
        service.addPlan(e);
        session.setAttribute("msg","Plan Added Successfully..");
        return "redirect:/view_plan";
    }
    @RequestMapping(path="/view_plan",method = RequestMethod.GET)
    public String getPlan(Model m){
        List<PlanEntity> doc=service.getPlan();
        m.addAttribute("doc",doc);
        return "view_plan";
    }
    @GetMapping("/edit_plan/{id}")
    public String showUpdateFormPlan(@PathVariable("id") int id, Model model) {
        PlanEntity user = planRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_Plan";
    }
    @RequestMapping(path = "/update_plan/{id}",method = RequestMethod.POST)
    public String updatePlan(@PathVariable("id") int id, PlanEntity d, BindingResult result, Model m, HttpSession session){
        if(result.hasErrors()){
            d.setId(id);
            return "update_Plan";
        }
        service.addPlan(d);
        session.setAttribute("msg","Plan Updated Successfully..");
        return "redirect:/view_plan";
    }
    @GetMapping("/delete_plan/{id}")
    public String deletePlan(@PathVariable("id") int id, Model model) {
        PlanEntity user = planRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        planRepo.delete(user);
        return "redirect:/view_plan";
    }

    @RequestMapping(path="/show_member",method = RequestMethod.GET)
    public String showMember(Model m){
        List<PlanEntity> planList=service.getPlan();
        m.addAttribute("planList",planList);
        return "add_Member";
    }
    @RequestMapping(path="/plan_list",method = RequestMethod.GET)
    public ResponseEntity<List<PlanEntity>> planData() {
        return ResponseEntity.ok().body(service.getPlan());
    }
    @RequestMapping(path="/add_member",method = RequestMethod.POST)
    public String addMember(MemberEntity e, Model m, HttpSession session){
        service.addMember(e);
        session.setAttribute("msg","Member Added Successfully..");
        return "redirect:/view_member";
    }
    @RequestMapping(path="/view_member",method = RequestMethod.GET)
    public String getMember(Model m){
        List<MemberEntity> doc=service.getMember();
        m.addAttribute("doc",doc);
        return "view_Member";
    }
    @GetMapping("/edit_member/{id}")
    public String showUpdateFormMember(@PathVariable("id") int id, Model model) {
        MemberEntity user = memberRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_Member";
    }
    @RequestMapping(path = "/update_member/{id}",method = RequestMethod.POST)
    public String updateMember(@PathVariable("id") int id, MemberEntity d, BindingResult result, Model m, HttpSession session){
        if(result.hasErrors()){
            d.setId(id);
            return "update_Member";
        }
        service.addMember(d);
        session.setAttribute("msg","Member Updated Successfully..");
        return "redirect:/view_member";
    }
    @RequestMapping(path = "/update_gym_value/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<MemberEntity>> updateGymvalue(@PathVariable("id") int id, MemberEntity d, BindingResult result, Model m, HttpSession session){
        return ResponseEntity.ok().body(memberRepo.findAllById(Collections.singleton(id)));
    }

    @GetMapping("/delete_member/{id}")
    public String deleteMember(@PathVariable("id") int id, Model model) {
        MemberEntity user = memberRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        memberRepo.delete(user);
        return "redirect:/view_member";
    }


}
