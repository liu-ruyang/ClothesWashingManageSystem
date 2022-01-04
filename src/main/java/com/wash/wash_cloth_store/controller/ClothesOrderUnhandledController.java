package com.wash.wash_cloth_store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.wash.wash_cloth_store.entity.ClothesOrderHandled;
import com.wash.wash_cloth_store.entity.ClothesOrderHandling;
import com.wash.wash_cloth_store.entity.ClothesOrderUnhandled;
import com.wash.wash_cloth_store.entity.VIPMember;
import com.wash.wash_cloth_store.service.ClothesOrderHandledServiceImpl;
import com.wash.wash_cloth_store.service.ClothesOrderHandlingServiceImpl;
import com.wash.wash_cloth_store.service.ClothesOrderUnhandledServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClothesOrderUnhandledController {
    @Autowired
    private ClothesOrderUnhandledServiceImpl clothesOrderUnhandledService;
    @Autowired
    private ClothesOrderHandledServiceImpl clothesOrderHandledService;
    @Autowired
    private ClothesOrderHandlingServiceImpl clothesOrderHandlingService;

    /*跳转到个人订单页面*/
    @RequestMapping("/personalOrder")
    public String a0(HttpSession session, Model model) {
        VIPMember vipMember = (VIPMember) session.getAttribute("user");
        List<ClothesOrderHandled> handled_orders = clothesOrderHandledService.getAll(vipMember.getId());
        List<ClothesOrderHandling> handling_orders = clothesOrderHandlingService.getAll(vipMember.getId());
        List<ClothesOrderUnhandled> unhandled_orders = clothesOrderUnhandledService.getAll(vipMember.getId());
        model.addAttribute("handled_orders", handled_orders);
        model.addAttribute("handling_orders", handling_orders);
        model.addAttribute("unhandled_orders", unhandled_orders);

        return "order/personal_orders/list";

    }


    /*查询个人所有订单*/
    @RequestMapping("/user/order/status")
    public String list(HttpSession session, String status, Model model) {
        System.out.println("=======================");
        System.out.println(status);

        VIPMember vipMember = (VIPMember) session.getAttribute("user");
        if (status.equals("1")) {
            List<ClothesOrderUnhandled> unhandled_orders = clothesOrderUnhandledService.getAll(vipMember.getId());
            model.addAttribute("unhandled_orders", unhandled_orders);

        } else if (status.equals("2")) {
            List<ClothesOrderHandling> handling_orders = clothesOrderHandlingService.getAll(vipMember.getId());
            model.addAttribute("handling_orders", handling_orders);

        } else if (status.equals("3")) {
            List<ClothesOrderHandled> handled_orders = clothesOrderHandledService.getAll(vipMember.getId());
            model.addAttribute("handled_orders", handled_orders);

        } else {

            List<ClothesOrderHandled> handled_orders = clothesOrderHandledService.getAll(vipMember.getId());
            List<ClothesOrderHandling> handling_orders = clothesOrderHandlingService.getAll(vipMember.getId());
            List<ClothesOrderUnhandled> unhandled_orders = clothesOrderUnhandledService.getAll(vipMember.getId());
            model.addAttribute("handled_orders", handled_orders);
            model.addAttribute("handling_orders", handling_orders);
            model.addAttribute("unhandled_orders", unhandled_orders);
        }

        return "order/personal_orders/list";
    }

    /*查询详情页面的，查询个人已洗订单*/
    @RequestMapping("/user/order/handled")
    public String list_handled(int id, Model model) {

        List<ClothesOrderHandled> handled_orders = clothesOrderHandledService.getById(id);
        model.addAttribute("handled_orders", handled_orders);
        return "order/personal_orders/handled_details";
    }

    /*查看订单详情，查看个人进行中*/
    @RequestMapping("/user/order/handling")
    public String list_handling(int id, Model model) {
        List<ClothesOrderHandling> handling_orders = clothesOrderHandlingService.getById(id);
        model.addAttribute("handling_orders", handling_orders);
        return "order/personal_orders/handling_details";
    }

    /*查看订单详情，查看个人未洗*/
    @RequestMapping("user/order/unhandled")
    public String list_unhandled(int id, Model model) {
        List<ClothesOrderUnhandled> unhandled_orders = clothesOrderUnhandledService.getById(id);
        model.addAttribute("unhandled_orders", unhandled_orders);
        return "order/personal_orders/details";
    }


    /*根据衣服种类查询*/
    @RequestMapping("/user/order/type")
    public String getByClothesType(HttpSession session, String clothesType, Model model) {
        VIPMember vipMember = (VIPMember) session.getAttribute("user");
        List<ClothesOrderUnhandled> unhandled_orders = clothesOrderUnhandledService.getByClothesType(vipMember.getId(),
                Integer.parseInt(clothesType));
        List<ClothesOrderHandling> handling_orders = clothesOrderHandlingService.getByClothesType(vipMember.getId(),
                Integer.parseInt(clothesType));
        List<ClothesOrderHandled> handled_orders = clothesOrderHandledService.getByClothesType(vipMember.getId(),
                Integer.parseInt(clothesType));
        model.addAttribute("unhandled_orders", unhandled_orders);
        model.addAttribute("handling_orders", handling_orders);
        model.addAttribute("handled_orders", handled_orders);

        return "order/personal_orders/list";
    }

    /*根据日期查询*/
    @RequestMapping("/user/order/date")
    public String getByOrderDate(HttpSession session, String orderDate, Model model) {
        VIPMember vipMember = (VIPMember) session.getAttribute("user");
        List<ClothesOrderUnhandled> unhandled_orders = clothesOrderUnhandledService.getByOrderDate(vipMember.getId(), orderDate);
        List<ClothesOrderHandling> handling_orders = clothesOrderHandlingService.getByOrderDate(vipMember.getId(), orderDate);
        List<ClothesOrderHandled> handled_orders = clothesOrderHandledService.getByOrderDate(vipMember.getId(), orderDate);
        model.addAttribute("unhandled_orders", unhandled_orders);
        model.addAttribute("handling_orders", handling_orders);
        model.addAttribute("handled_orders", handled_orders);
        return "order/personal_orders/list";
    }

    /*跳转到添加界面信息*/
    @RequestMapping("/user/order/toadd")
    public String toadd() {
        return "order/personal_orders/add";
    }

    /*添加订单*/
    @RequestMapping("/user/order/add")
    public String insert(ClothesOrderUnhandled clothesOrderUnhandled, HttpSession session) {
        VIPMember vipMember = (VIPMember) session.getAttribute("user");
        clothesOrderUnhandled.setVipMemberId(vipMember.getId());
        System.out.println(clothesOrderUnhandled);
        clothesOrderUnhandledService.insert(clothesOrderUnhandled);
        return "redirect:/personalOrder";
    }

    /*查看详情页面的更新*/
    @RequestMapping("/user/order/details")
    public String updateDescriptionById(int id, String description) {
        ClothesOrderUnhandled clothesOrderUnhandled = new ClothesOrderUnhandled();
        clothesOrderUnhandled.setId(id);
        clothesOrderUnhandled.setDescription(description);
        clothesOrderUnhandledService.updateDescriptionById(clothesOrderUnhandled);
        return "redirect:/personalOrder";
    }

    /*删除*/
    @RequestMapping("/user/order/delete")
    public String delete(@RequestParam("id") int id) {
        int delete = clothesOrderUnhandledService.delete(id);
        System.out.println(delete);
        return "redirect:/personalOrder";
    }

}
