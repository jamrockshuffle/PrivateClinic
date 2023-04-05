package com.kj.clinic.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("Role")
public class Role {

    @Id
    private String id;

    private ERole name;

    @DBRef(lazy = true)
    private Set<User> userIds;

    public enum ERole {
        ROLE_USER,
        ROLE_ADMIN
    }
}