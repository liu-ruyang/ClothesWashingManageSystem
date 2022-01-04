package com.wash.wash_cloth_store.controller;

import javax.servlet.http.HttpSession;

import com.wash.wash_cloth_store.entity.VIPMember;
import com.wash.wash_cloth_store.service.impl.VIPMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VIPMemberController {

    @Autowired
    private VIPMemberServiceImpl vipMemberService;

    @RequestMapping("/user/vip")
    public String list(HttpSession session, Model model) {
        VIPMember users = (VIPMember) session.getAttribute("user");
        VIPMember members = vipMemberService.getById(users.getId());
        model.addAttribute("member", members);
        return "user_vip/list";
    }

    @RequestMapping("/user/vip_update")
    public String updateVIPMember(@RequestParam("vip_member") VIPMember vipMember) {
        vipMemberService.updateVIPMemberById(vipMember);
        return "user_vip/list";
    }


}
