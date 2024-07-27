package sixthsense.backend.dto.promo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Builder
@Data
public class DataPromo {

    private String image;
    private String title;
    private Date validUntil;
}
