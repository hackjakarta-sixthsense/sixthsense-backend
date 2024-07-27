package sixthsense.backend.dto.paymentDto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {

    private ListPayment payment;
}
