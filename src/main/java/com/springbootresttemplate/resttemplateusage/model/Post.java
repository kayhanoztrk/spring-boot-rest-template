package com.springbootresttemplate.resttemplateusage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String id;
    private String title;
    private String body;
}
