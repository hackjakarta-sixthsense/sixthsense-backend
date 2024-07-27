package sixthsense.backend.dto.paymentDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataPayment {
    private String icon;
    private String caption;
    private String content;
}
