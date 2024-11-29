package lk.ijse.dto;

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
    private String upFrontdate;
    private double secondPayment;
    private String secondPaymentDate;
    private double thirdPayment;
    private String thirdPaymentDate;
    private String studentId;
}
