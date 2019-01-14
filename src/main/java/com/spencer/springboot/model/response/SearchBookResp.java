package com.spencer.springboot.model.response;

import com.spencer.springboot.po.Book;

import java.util.List;

/**
 * @Author Spencer
 * @Date 2019/1/8 15:04
 * @Description
 */
public class SearchBookResp {
    private List<Book> books;
    private int count;
    private int start;
    private int total;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
