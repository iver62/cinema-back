//package org.sid.domain.entities;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Country implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String name;
//
//    private String flag;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = false)
//    private Date creationDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = false)
//    private Date lastUpdate;
//
//}
