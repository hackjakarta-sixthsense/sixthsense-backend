package sixthsense.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchResponse {
    private String value;
    private String category;
    private String valueRegex;
    private String categoryRegex;
    private String optionRegex;
}
