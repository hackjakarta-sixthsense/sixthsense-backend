package sixthsense.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import sixthsense.backend.dto.LlmRequest;
import sixthsense.backend.dto.LlmResponse;
import sixthsense.backend.dto.SearchResponse;
import sixthsense.backend.util.Validator;


@Service
@RequiredArgsConstructor
@Slf4j
public class LlmService {

    private final WebClient.Builder webClientBuilder;


    @Value("${llm.api.url}")
    private String llmUrl;

    @Value("${llm.type}")
    private String llmType;

    public SearchResponse sendPrompt(String prompt) {

        LlmRequest searchRequest = new LlmRequest();
        searchRequest.setModel(llmType);
        searchRequest.setStream(false);
        searchRequest.setPrompt(prompt + " -> Please response with 2 sentences in one line separated with one period. the first sentence is the value of what user want, its either type of food or location, and just state the value (example: ayam bakar, nasi padang, bni city, stasiun sudirman). the second one is the category, either food or location, and just state the category (for example: food, location)");

        LlmResponse llmResponse = webClientBuilder.build()
                .post()
                .uri(llmUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(searchRequest))
                .retrieve()
                .bodyToMono(LlmResponse.class)
                .block();

        if (Validator.isNotNullOrEmpty(llmResponse)){
            return mappingData(llmResponse);
        }else {
            return null;
        }
    }


    public SearchResponse mappingData(LlmResponse llmResponse){
        String response = llmResponse.getResponse();
        String newLineRegex = "\n";
        SearchResponse searchResponse = new SearchResponse();
        String[] parts = response.split("[,\\\\.]");

        searchResponse.setValueRegex(parts[0]);
        searchResponse.setCategoryRegex(parts[1].replaceAll( newLineRegex, "").replaceAll( " ", ""));
        searchResponse.setValue(response);
        searchResponse.setCategory(response);
        return searchResponse;
    }


}
