package net.homecredit.oauth2.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoResource {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map> helloWorld(Principal principal) {
        Map response = new HashMap();
        response.put("message", "Hello World");
        response.put("testPrincipal", principal);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/withPermission", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Map> withPermission() {
        Map response = new HashMap<>();
        response.put("message", "Hello I have been authorized with role ROLE_ADMIN");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
