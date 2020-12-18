package com.nguvel.progwebapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "bets")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Bet {

    @Id
    @Column(name="bet_id", nullable = false)
    @SequenceGenerator(name = "bet_seq", sequenceName = "bet_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bet_seq")
    private Long bet_id;
    private String player1;
    private String player2;
    private Long price;
    private String game;
    private String description;
    private Boolean detail;
    private Boolean accepted;
}
