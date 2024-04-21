package inm.od.biz.controller;

import inm.od.biz.dto.FormData;
import inm.od.biz.dto.SelectOption;
import inm.od.biz.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Autowired
    private MemberService memberService;

    @GetMapping("/selectComponent")
    public String selectComponent(Model model) {

        threadLocal.set("selectComponent");

        memberService.getMember();

        List<SelectOption> options = new ArrayList<>();
        options.add(new SelectOption("1", "Option 1"));
        options.add(new SelectOption("2", "Option 2"));
        options.add(new SelectOption("3", "Option 3"));
        model.addAttribute("options", options);
        model.addAttribute("selectedValue", "2");

        FormData formData = new FormData();
        formData.setName("John Doe");
        formData.setEmail("skdfjslfdjl@gmail.com");
        model.addAttribute("formData", formData);

        return "selectorComponent";
    }
}
