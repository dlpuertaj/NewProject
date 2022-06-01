package com.dlp.project.api;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private T data;
    private String message;
}
