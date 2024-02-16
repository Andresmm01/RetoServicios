package com.jsonplaceholder.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentsModel {

    public long postId;

    public long id;

    public String name;

    public String email;

    public String body;
}
