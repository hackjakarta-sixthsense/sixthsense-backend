package sixthsense.backend.dto.promo;


import lombok.Builder;
import lombok.Data;
import sixthsense.backend.dto.paymentDto.ListPayment;

@Data
@Builder
public class PromoResponse {

    private ListPromo promo;
}
