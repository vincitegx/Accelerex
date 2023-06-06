package com.neptunesoftware.accelerex.general;

import com.neptunesoftware.accelerex.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Client {
    @jakarta.persistence.Id
    @SequenceGenerator(
            name = "client_id_sequence",
            sequenceName = "client_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_id_sequence"
    )
    private String clientId;
    private String secretKey;

      @OneToOne
    private User user;

    /**
     * The constructor is yet to be decided
     *
     */

    public Client() {

    }
}