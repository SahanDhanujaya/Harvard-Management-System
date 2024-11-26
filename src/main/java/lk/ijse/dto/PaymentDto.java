package lk.ijse.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {
    private String paymentId;
    private String method;
    private double upFrontPayment;
    private Date date;
    private String studentId;
}
