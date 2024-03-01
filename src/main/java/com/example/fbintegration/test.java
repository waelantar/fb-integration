package com.example.fbintegration;

import org.springframework.social.facebook.api.Comment;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.stereotype.Service;

@Service
public class test implements CommentOperations {

    test(){}

    @Override
    public PagedList<Comment> getComments(String s) {
        return null;
    }

    @Override
    public PagedList<Comment> getComments(String s, PagingParameters pagingParameters) {
        return null;
    }

    @Override
    public Comment getComment(String s) {
        return null;
    }

    @Override
    public String addComment(String s, String s1) {
        return null;
    }

    @Override
    public void deleteComment(String s) {

    }
}
