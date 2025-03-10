package vn.test.vtibackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

import java.io.Serializable;

@Entity
@Table(name ="`group`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    private String creator;


    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @PrePersist
    protected void onCreate() {
        createDate = new Date();
    }


}
