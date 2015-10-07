package net.thumbtack.be.controller;

import net.thumbtack.be.persistence.entity.Account;
import net.thumbtack.be.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/accounts")
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm() {
        return "addAccount";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    String addAccount(@ModelAttribute(value = "account") Account account, BindingResult result) {
        String returnText;
        if (!result.hasErrors()) {
            Account added = accountService.create(account);
            returnText = "Entity has been added:" + added;
        } else {
            returnText = "Error has occurred. Entity hasn't been added.";
        }
        return returnText;
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView getAccounts() {
        logger.debug("display Account list");
        ModelAndView mv = new ModelAndView("accountList");
        mv.addObject("accountsModel", accountService.getAll());
        return mv;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable long id) {
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editAccountPage(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("editAccount");
        Account account = accountService.get(id);
        mav.addObject("acc", account);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account edit(@PathVariable long id,
                        @RequestBody Account account) {
        account.setId(id);
        return accountService.update(account);
    }


    @RequestMapping(value="/create", method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account create(@RequestBody Account account) {
        return accountService.create(account);
    }


}