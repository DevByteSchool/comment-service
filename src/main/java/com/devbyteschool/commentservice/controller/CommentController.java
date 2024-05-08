package com.devbyteschool.commentservice.controller;

import com.devbyteschool.commentservice.dto.CreateCommentRequest;
import com.devbyteschool.commentservice.dto.DBSResponseEntity;
import com.devbyteschool.commentservice.model.Comment;
import com.devbyteschool.commentservice.service.CommentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@Slf4j
public class CommentController {


    @Autowired
    private CommentService commentService;


    @PostMapping("v1/comments")
    public ResponseEntity<DBSResponseEntity> createCommentCall(@Valid @RequestBody CreateCommentRequest createCommentRequest) {

        DBSResponseEntity dbsResponseEntity = new DBSResponseEntity();

        log.info("BlogController:createBlogCall request received with body : {}", createCommentRequest.toString());

        try {
            Comment comment =  commentService.createComment(createCommentRequest);
            log.info("CommentController:createCommentCall record save successfully with blogId : {}", comment.getBlogId());
            dbsResponseEntity.setMessage("Comment created successfully.");
            dbsResponseEntity.setData(comment);
            return ResponseEntity.ok(dbsResponseEntity);
        } catch (Exception exception) {
            log.debug("CommentController:createCommentCall something when wrong : {}", exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("v1/comments/{blogId}")
    public ResponseEntity<DBSResponseEntity> getBlogCall(@PathVariable String blogId) {
        DBSResponseEntity dbsResponseEntity = new DBSResponseEntity();

        try {
            List<Comment> comments = commentService.getComments(blogId);
            dbsResponseEntity.setData(comments);
            return ResponseEntity.ok(dbsResponseEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
