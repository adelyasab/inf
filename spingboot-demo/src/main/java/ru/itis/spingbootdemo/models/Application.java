package ru.itis.spingbootdemo.models;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "application2")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private String time;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "photosession_id")
    private Photosession photosession;

    private String phoneNumber;
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}

