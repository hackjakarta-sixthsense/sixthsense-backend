package sixthsense.backend.dto.promo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListPromo {
    private String title;
    private List<DataPromo> listPromo;
}
