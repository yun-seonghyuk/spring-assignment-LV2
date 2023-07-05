package com.assignment.springassignmentlv2.entity;

import com.assignment.springassignmentlv2.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "post")
@NoArgsConstructor
public class Post extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", nullable = false)
    private String title;



    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "username", nullable = false, length = 500)
    private String username;

    public Post(PostRequestDto postRequestDto, User user){
        this.title = postRequestDto.getTitle();
        this.username = user.getUsername();
        this.user = user;
        this.content = postRequestDto.getContent();
    }

    public void update(PostRequestDto postRequestDto, User user) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.user = user;
    }
}