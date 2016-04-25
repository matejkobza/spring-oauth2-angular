package net.homecredit.oauth2.test.restsp.security;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import net.homecredit.oauth2.test.RestServiceProviderApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author Dave Syer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestServiceProviderApplication.class)
@IntegrationTest("server.port=0")
@WebAppConfiguration
public class ApplicationTests {
    @Value("${local.server.port}")
    private int port;

    @Test
    public void passwordGrant() {
        MultiValueMap<String, String> request = new LinkedMultiValueMap<String, String>();
        request.set("username", "jlong");
        request.set("password", "password");
        request.set("grant_type", "password");
        @SuppressWarnings("unchecked")
        Map<String, Object> token = new TestRestTemplate("android-restsp", "123456")
                .postForObject("http://localhost:" + port + "/restsp/oauth/token", request,
                        Map.class);
        assertNotNull("Wrong response: " + token, token.get("access_token"));
    }
}
