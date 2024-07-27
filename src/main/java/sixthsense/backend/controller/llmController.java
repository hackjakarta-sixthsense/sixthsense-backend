package sixthsense.backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sixthsense.backend.dto.SearchResponse;
import sixthsense.backend.service.LlmService;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class llmController {

    private final LlmService llmService;

    @PostMapping
    public ResponseEntity<SearchResponse> searchPrompt(@RequestBody String prompt) {
        return ResponseEntity.ok(llmService.sendPrompt(prompt));
    }
}
