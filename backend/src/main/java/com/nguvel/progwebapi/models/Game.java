package com.nguvel.progwebapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "games")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Game {
    @Id
    @Column(name="game_id", nullable = false)
    @SequenceGenerator(name = "game_seq", sequenceName = "game_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    private Long game_id;
    private String name;
    private String img;

}
