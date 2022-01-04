package com.wash.wash_cloth_store.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wash.wash_cloth_store.entity.Administrator;
import com.wash.wash_cloth_store.entity.ClothesOrder;
import com.wash.wash_cloth_store.entity.ClothesType;
import com.wash.wash_cloth_store.entity.VIPMember;
import com.wash.wash_cloth_store.service.impl.AdministratorServiceImpl;
import com.wash.wash_cloth_store.service.impl.VIPMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    AdministratorServiceImpl administratorService;
    @Autowired
    VIPMemberServiceImpl vipMemberService;

    /*登录界面*/
    @RequestMapping({"/login", "/"})
    public String a0() {
        return "index";
    }

    /*首页*/
    @RequestMapping("/index")
    public String a2() {
        return "welcome/welcome";
    }

    /*修改密码*/
    @RequestMapping("/updatePassword")
    public String a1(HttpServletRequest httpServletRequest) {
        System.out.println("=====================");
        String username = httpServletRequest.getParameter("username_modify");
        String oldPassword = httpServletRequest.getParameter("password_modify_old");
        String newPassword = httpServletRequest.getParameter("password_modify_new");
        int result = vipMemberService.updatePassword(username, oldPassword, newPassword);
        System.out.println(result);
        System.out.println("修改成功");
        return "index";
    }

    //登录
    @RequestMapping("/loginin_in")
    public String login(HttpServletRequest httpServletRequest, HttpSession session, Model model) {
        String identity = httpServletRequest.getParameter("identity");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");

        if (identity != null && identity.equals("administrator")) {
            /*管理员身份登录*/
            Administrator administrator = administratorService.ifExist(username, password);
            if (administrator != null) {
                /*登录成功*/
                /*个人信息添加进session中*/
                session.setAttribute("user", administrator);
                session.setAttribute("identity", "administrator");
                return "welcome/welcome";
            } else {
                /*登录失败*/
                System.out.println("登陆失败");
                model.addAttribute("error", "身份信息错误");
                return "redirect:/";
            }
        } else {
            /*会员身份登录*/
            VIPMember vipMember = vipMemberService.ifExist(username, password);
//            System.out.println(vipMember);
            if (vipMember != null) {
                /*登录成功*/
                /*个人信息添加进session中*/
                session.setAttribute("user", vipMember);
                session.setAttribute("identity", "vipmember");
                return "welcome/welcome";
            } else {
                /*会员信息输入错误*/
                System.out.println("登陆失败");
                model.addAttribute("error", "身份信息错误");
                return "redirect:/";
            }
        }
    }

    /*个人信息*/
    @RequestMapping("/personalinfo")
    public String a(Model model, HttpSession httpSession) {
        Object user = httpSession.getAttribute("user");
        VIPMember vipMember = (VIPMember) user;

        model.addAttribute("vipMember", vipMember);

        return "list/personalinfo/info";
    }

    /*修改个人信息*/
    @RequestMapping("/updatePersonalInfo")
    public String b(HttpServletRequest httpServletRequest, HttpSession session) {
        VIPMember vipMember = new VIPMember();
        vipMember.setUsername(httpServletRequest.getParameter("username"));
        vipMember.setName(httpServletRequest.getParameter("name"));
        vipMember.setAge(Integer.parseInt(httpServletRequest.getParameter("age")));
        vipMember.setAddress(httpServletRequest.getParameter("address"));
        vipMember.setBalance(Double.parseDouble(httpServletRequest.getParameter("balance")));
        vipMember.setRegister_date(Timestamp.valueOf(httpServletRequest.getParameter("register_date")));
        vipMember.setPhone(httpServletRequest.getParameter("phone"));

        String id = httpServletRequest.getParameter("id");
        int result = vipMemberService.updateVIPMember(Integer.parseInt(id), vipMember);
        //数据库中的信息修改后，还要将session中的个人信息修改掉
        VIPMember vipMember1 = vipMemberService.queryPersonalInfo(Integer.parseInt(id));
        session.setAttribute("user", vipMember1);
        System.out.println(session.getAttribute("user"));

        return "redirect:/personalinfo";
    }

    /*会员列表*/
    @RequestMapping("/memberlist")
    public String c(Model model) {
        List<VIPMember> vipMembers = administratorService.queryAll();

        model.addAttribute("memberlist", vipMembers);

        return "list/customersinfo/list";
    }

    /*注销*/
    @RequestMapping("/logout")
    public String d(HttpSession httpSession) {
        httpSession.removeAttribute("idendity");
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

    /*删除用户*/
    @RequestMapping("/delete")
    public String e(int id) {
        int result = administratorService.deleteMember(id);

        /*接口写好后，可以使用重定向*/
        return "redirect:/memberlist";
    }

    /*去添加用户的界面*/
    @RequestMapping("toadd")
    public String f(Model model) {

        return "modify/addmember";
    }

    /*添加用户*/
    @RequestMapping("add")
    public String g(VIPMember vipMember) {
        /*
         * 添加用户
         * */
        int result = administratorService.addMember(vipMember);
        /*判断会员是否添加成功*/
        return "redirect:/memberlist";
    }

    /*根据用户id查找用户*/
    @RequestMapping("/query")
    public String h(Model model, int id) {
        VIPMember vipMember = administratorService.queryMember(id);
        List<VIPMember> memberList = new ArrayList<>();
        memberList.add(vipMember);
        model.addAttribute("memberlist", memberList);
        return "list/customersinfo/list";
    }

    /*去充值页面*/
    @RequestMapping("/torecharge")
    public String i(Model model, int id) {
        //根据传入的id查询到要充值的用户的信息
        VIPMember vipMember = administratorService.queryMember(id);
        model.addAttribute("vipmember", vipMember);

        return "modify/recharge";
    }

    /*进行充值*/
    @RequestMapping("/recharge")
    public String j(Model model, HttpServletRequest httpServletRequest) {
        String idStr = httpServletRequest.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        String amountStr = httpServletRequest.getParameter("amount");
        Integer amount = Integer.parseInt(amountStr);
        String balanceStr = httpServletRequest.getParameter("balance");
        float balanceFloat = Float.parseFloat(balanceStr);

        //float转换为int类型，使用了强制类型转换
        int balance = (int) balanceFloat;
        Integer newBalance = balance + amount;
        int result = administratorService.updateBalance(id, newBalance);

        /*接口写好后，需要重定向*/
        return "redirect:/memberlist";
    }

    /*查看所有用户订单列表*/
    @RequestMapping("/allorder")
    public String k(Model model) {
        List<ClothesOrder> allUserOrder = administratorService.getAllUserOrder();
        List<ClothesType> clothesTypes = administratorService.getClothesTypes();

        model.addAttribute("allUserOrder", allUserOrder);
        model.addAttribute("clothesTypes", clothesTypes);

        return "order/customers_orders/list";
    }

    /*订单详情*/
    @RequestMapping("/moreinfo")
    public String l(Model model, Timestamp order_date) {
        ClothesOrder orderByOrder_date = administratorService.getOrderByOrder_date(order_date);
        model.addAttribute("orderInfo", orderByOrder_date);
        List<ClothesType> clothesTypes = administratorService.getClothesTypes();
        model.addAttribute("clothesTypes", clothesTypes);
        return "order/customers_orders/orderInfo";
    }

    /*改变衣物状态：开始洗衣、完成订单*/
    @RequestMapping("/changestatus")
    public String m(HttpServletRequest httpServletRequest, ClothesOrder clothesOrder) {
        System.out.println(clothesOrder);
        switch (httpServletRequest.getParameter("operation")) {
            case "startOrder": {
                /*开始洗衣*/
                int result = administratorService.deleteUnhandledOrder(clothesOrder.getId());
                if (result > 0) {
                    clothesOrder.setStatus(2);
                    administratorService.addHandlingOrder(clothesOrder);
                }
                break;
            }
            case "finishOrder": {
                /*完成订单*/
                int result = administratorService.deleteHandlingOrder(clothesOrder.getId());
                if (result > 0) {
                    clothesOrder.setStatus(3);
                    administratorService.addHandledOrder(clothesOrder);
                }
                break;
            }

        }
        return "redirect:/allorder";
    }

    /*关于本店*/
    @RequestMapping("/about")
    public String n() {
        return "about/about";
    }

    /*取衣通知页面*/
    @RequestMapping("/notice")
    public String o(HttpSession httpSession, Model model) {
        int id = ((VIPMember) httpSession.getAttribute("user")).getId();
        List<ClothesOrder> allUnTakenOrders = vipMemberService.getAllUnTakenOrders(id);
        List<ClothesType> clothesTypes = administratorService.getClothesTypes();

        model.addAttribute("untakenOrders", allUnTakenOrders);
        model.addAttribute("clothesTypes", clothesTypes);

        return "notice/notice";
    }

    /*取走衣物*/
    @RequestMapping("/takeaway")
    public String p(Timestamp order_date) {
        vipMemberService.takeAwayClothes(order_date);

        return "redirect:/notice";
    }
}
