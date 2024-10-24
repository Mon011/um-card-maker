package com.monodev.ummaker.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveUserRequest {
    private String username;

    private String picture;

}
