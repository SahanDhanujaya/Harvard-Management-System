package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    private String paymentId;
    private String method;
    private double upFrontPayment;
    private String upFrontdate;
    private double secondPayment;
    private String secondPaymentDate;
    private double thirdPayment;
    private String thirdPaymentDate;
    private String stId;
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
    private List<Registration> registrationList;
    @ManyToOne
    private Student student;

}
