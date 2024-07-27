package sixthsense.backend.dto.menuDto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListMenu{
    List<DataMenu> listMenu;
}
