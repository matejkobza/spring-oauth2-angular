package net.homecredit.oauth2.test.restsp.repository;

import java.util.Optional;

import net.homecredit.oauth2.test.restsp.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 * @author Pavel.Botos
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

}
