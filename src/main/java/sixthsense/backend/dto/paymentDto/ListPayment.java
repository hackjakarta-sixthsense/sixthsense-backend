package sixthsense.backend.dto.paymentDto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListPayment {
    private List<DataPayment> listPayment;
}
