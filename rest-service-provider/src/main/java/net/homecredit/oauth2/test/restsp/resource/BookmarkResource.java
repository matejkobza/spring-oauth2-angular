package net.homecredit.oauth2.test.restsp.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import net.homecredit.oauth2.test.restsp.controller.BookmarkRestController;
import net.homecredit.oauth2.test.restsp.model.Bookmark;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 *
 * @author Pavel.Botos
 */
public class BookmarkResource extends ResourceSupport {
    private final Bookmark bookmark;

    public BookmarkResource(Bookmark bookmark) {
        String username = bookmark.getAccount().getUsername();
        this.bookmark = bookmark;
        this.add(new Link(bookmark.getUri(), "bookmark-uri"));
        this.add(linkTo(BookmarkRestController.class, username).withRel("bookmarks"));
        this.add(linkTo(methodOn(BookmarkRestController.class, username).readBookmark(username, bookmark.getId())).withSelfRel());
    }

    public Bookmark getBookmark() {
        return bookmark;
    }
}
