package com.github.tddiaz.springwebsockets.controllers.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifyRequest {
    private String message;
    private String user;
}
