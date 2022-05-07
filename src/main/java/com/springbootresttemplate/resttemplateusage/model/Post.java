package com.springbootresttemplate.resttemplateusage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Post is dto class.
 *
 * @author  Kayhan Öztürk
 * @version 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String userId;
    @NotNull(message = "id can not be null")
    private String id;
    @NotNull(message = "title can not be null")
    @Size(min = 5)
    private String title;
    @NotNull(message = "body can not be null!")
    private String body;
}
