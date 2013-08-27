package com.sjtu.onlinelibrary.web.book;

import com.sjtu.onlinelibrary.DataAccessException;
import com.sjtu.onlinelibrary.service.impl.BookServiceImpl;
import com.sjtu.onlinelibrary.service.impl.ChapterServiceImpl;
import com.sjtu.onlinelibrary.service.impl.CommentService;
import com.sjtu.onlinelibrary.web.viewmodel.BookViewModel;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/book")
public class BookController {

    public static final String BOOK_CHAPTER_LIST = "book/chapterList";
    public static final String BOOK_BOOK_DETAIL = "book/bookDetail";
    public static final String BOOK_READER = "book/reader";
    private BookServiceImpl bookService;
    private ChapterServiceImpl chapterService;
    private CommentService commentService;

    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    public void setChapterService(ChapterServiceImpl chapterService) {
        this.chapterService = chapterService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("/{id}.do")
    public ModelAndView book(@PathVariable("id") String id) throws DataAccessException {
        BookViewModel bookViewModel = new BookViewModel();
        bookViewModel.setBook(this.bookService.findById(id).innerBookEntity());
        bookViewModel.setComments(this.commentService.findAll(id, 1));
//        return bookViewModel;
        return new ModelAndView(BOOK_BOOK_DETAIL, "book", bookViewModel);
    }

    @RequestMapping("/{id}/read.do")
    public ModelAndView read(@PathVariable("id") String id) throws DataAccessException {
        ModelMap map = getMap(id);
        map.put("chapters", this.chapterService.findAll(id));
        return new ModelAndView(BOOK_CHAPTER_LIST, map);
    }

    @RequestMapping("/{bookId}/chapter/{id}.do")
    public ModelAndView chapter(@PathVariable("bookId") String bookId, @PathVariable("id") String id) throws DataAccessException {
        ModelMap map = getMap(bookId);
        map.put("chapter",this.chapterService.findById(id));
        return new ModelAndView(BOOK_READER, map);
    }

    public ModelMap getMap(String bookId) throws DataAccessException {
        ModelMap map = new ModelMap();
        map.put("book", this.bookService.findById(bookId));
        return map;
    }
}
