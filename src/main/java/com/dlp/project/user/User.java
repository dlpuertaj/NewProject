package com.dlp.project.user;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;
}
