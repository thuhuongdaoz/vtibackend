package vn.test.vtibackend.entity;

import jakarta.persistence.*;
import lombok.*;
import vn.test.vtibackend.common.RoleEnum;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @PrePersist
    protected void onCreate() {
        createDate = new Date();
    }
}
