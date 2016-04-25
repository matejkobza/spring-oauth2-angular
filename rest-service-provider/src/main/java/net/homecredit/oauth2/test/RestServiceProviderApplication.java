package net.homecredit.oauth2.test;

import java.util.Arrays;

import net.homecredit.oauth2.test.restsp.model.Account;
import net.homecredit.oauth2.test.restsp.model.Bookmark;
import net.homecredit.oauth2.test.restsp.repository.AccountRepository;
import net.homecredit.oauth2.test.restsp.repository.BookmarkRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * curl --noproxy localhost -X POST -vu android-restsp:123456 http://localhost:9888/oauth/token -H "Accept: application/json" -d "password=password&username=jlong&grant_type=password&scope=write&client_secret=123456&client_id=android-restsp"
 * curl --noproxy 127.0.0.1 -v POST http://127.0.0.1:9888/jhoeller/bookmarks -H "Authorization: Bearer 3fb24f4c-d245-47e1-8f9d-bd69a5b66caf"
 */

@SpringBootApplication
@ComponentScan(basePackages = { "net.homecredit.oauth2.test.restsp" })
@EnableJpaRepositories(basePackages = {"net.homecredit.oauth2.test.restsp.repository"})
public class RestServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceProviderApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
        return (evt) -> Arrays.asList(
                "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(
                        a -> {
                            Account account = accountRepository.save(new Account(a,
                                    "password"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/1/" + a, "A description"));
                            bookmarkRepository.save(new Bookmark(account,
                                    "http://bookmark.com/2/" + a, "A description"));
                        });
    }
}
