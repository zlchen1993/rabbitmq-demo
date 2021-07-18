package com.example.webdemo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author czl
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private static final Long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String nickName;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime creatTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
    /**
     * Entity 中不映射成列的字段得加 @Transient 注解，不加注解也会映射成列
     */
    @Transient
    private Long phoneNumber;

}
