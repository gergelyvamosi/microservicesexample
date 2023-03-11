package org.gvamosi.microservicesexample.web;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Client controller, fetches Account info from the microservice via
 * {@link WebAccountsService}.
 * 
 * @author Paul Chapman, Gergely Vamosi
 */
@CrossOrigin(origins = "*")
@RestController
public class WebAccountsController {

    @Autowired
    protected WebAccountsService accountsService;

    protected Logger logger = Logger.getLogger(WebAccountsController.class.getName());

    public WebAccountsController(WebAccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @GetMapping("/accounts/{accountNumber}")
    public List<Account> byNumber(@PathVariable("accountNumber") String accountNumber) {

        logger.info("web-service byNumber() invoked: " + accountNumber);

        List<Account> results = new ArrayList<Account>();

        Account account = accountsService.findByNumber(accountNumber);

        logger.info("web-service byNumber() found: " + account);

        if (account != null) {
            results.add(account);
        }
        return results;

    }

    @GetMapping("/accounts/owner/{name}")
    public List<Account> byOwner(@PathVariable("name") String partialName) {
        logger.info("web-service byOwner() invoked: " + partialName);

        List<Account> results = new ArrayList<Account>();

        List<Account> accounts = accountsService.byOwnerContains(partialName);
        logger.info("web-service byOwner() found: " + accounts);

        if (accounts != null && accounts.size() > 0) {
            results.addAll(accounts);
        }

        return results;

    }

}