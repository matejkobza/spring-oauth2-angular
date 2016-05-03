package net.homecredit.oauth2.test.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserResource {

    @RequestMapping("/user")
    @ResponseBody
    public Map user(Principal user) {
        OAuth2Authentication authentication = (OAuth2Authentication) user;
        HashMap map = new HashMap();
        map.put("userInfo", authentication.getPrincipal());
        map.put("roles", authentication.getUserAuthentication().getAuthorities());
        return map;
    }
}
