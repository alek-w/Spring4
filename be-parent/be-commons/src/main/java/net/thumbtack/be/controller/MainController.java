package net.thumbtack.be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


@Controller
public class MainController {

    private final static String status = String.valueOf( HttpServletResponse.SC_FORBIDDEN);

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("redirect:" + "accounts/list");
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(status);
        return mv;
    }
}
