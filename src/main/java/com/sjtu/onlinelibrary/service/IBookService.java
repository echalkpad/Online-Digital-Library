package com.sjtu.onlinelibrary.service;

import com.sjtu.onlinelibrary.DataAccessException;
import com.sjtu.onlinelibrary.entity.Book;
import com.sjtu.onlinelibrary.entity.UserBook;
import com.sjtu.onlinelibrary.web.viewmodel.BookEditModel;
import com.sjtu.onlinelibrary.web.viewmodel.BusinessResult;
import com.sjtu.onlinelibrary.web.viewmodel.Pager;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-3
 * Time: 下午1:18
 */
public interface IBookService {
    void save(final Book book) throws DataAccessException;

    Pager<BookEditModel> findAll(int pageIndex) throws DataAccessException;

    BookEditModel findById(String id) throws DataAccessException;

    boolean delete(String id);

    BusinessResult increaseAmount(String bookId,String userId, AmountType amountType) throws DataAccessException;
    void decreaseAmount(String bookId, AmountType amountType) throws DataAccessException;
    BusinessResult hasVoted(String bookId, String userId) throws DataAccessException ;
    /**
     * 根据类别查询该类别的图书
     */
    Pager<BookEditModel> findBooksByType(int pageIndex, final String category) throws DataAccessException;

    /**
     * 根据条件查询图书
     */
    Pager<BookEditModel> findBooksByName(int pageIndex, Map<String, Object> condition) throws DataAccessException;
    
    /**
     * 判断是否有图书属于该类别
     */
    boolean findBookByType(final String category) throws DataAccessException;
    
    /**
     * 根据点击量/鲜花/鸡蛋/购买量排序得到图书列表
     */
    Pager<BookEditModel> findAll(int pageIndex, String orderFields) throws DataAccessException;
    List<BookEditModel> findTop(String orderFields) throws DataAccessException;

    List<UserBook> findUserBook(String userId,boolean purchased) throws DataAccessException;

    UserBook deleteUserBook(String userBookId) throws DataAccessException;
}
