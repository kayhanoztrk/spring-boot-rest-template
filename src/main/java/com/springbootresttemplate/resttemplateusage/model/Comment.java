package com.springbootresttemplate.resttemplateusage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Comment is dto class.
 *
 * @author  Kayhan Öztürk
 * @version 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @NotNull(message = "postId can not be null")
    private String postId;
    @NotNull(message = "id can not be null")
    private String id;
    @NotNull(message = "name can not be null")
    @Size(min = 4)
    private String name;

    @NotNull(message = "email can not be null!")
    private String email;

    @NotNull(message = "body can not be null!")
    private String body;
}