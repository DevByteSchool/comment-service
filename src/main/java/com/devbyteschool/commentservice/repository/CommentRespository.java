package com.devbyteschool.commentservice.repository;

import com.devbyteschool.commentservice.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface CommentRespository extends MongoRepository<Comment, String> {

    List<Comment> findByBlogId(String blogId);

}
