package net.homecredit.oauth2.test.restsp.repository;

import java.util.Collection;

import net.homecredit.oauth2.test.restsp.model.Bookmark;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 * @author Pavel.Botos
 */
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    Collection<Bookmark> findByAccountUsername(String name);
}
