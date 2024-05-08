package com.devbyteschool.commentservice.service;

import com.devbyteschool.commentservice.dto.CreateCommentRequest;
import com.devbyteschool.commentservice.model.Comment;
import com.devbyteschool.commentservice.repository.CommentRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRespository commentRespository;

    public Comment createComment(CreateCommentRequest createCommentRequest) throws Exception {
        Comment comment = new Comment();
        BeanUtils.copyProperties(createCommentRequest, comment);
        return commentRespository.save(comment);
    }




    public List<Comment> getComments(String blogId) throws Exception {
        return commentRespository.findByBlogId(blogId);
    }

}
