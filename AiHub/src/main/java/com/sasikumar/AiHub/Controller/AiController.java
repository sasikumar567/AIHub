package com.sasikumar.AiHub.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sasikumar.AiHub.Service.AiService;
@CrossOrigin
@RestController
@RequestMapping("/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/{model}/{prompt}")
    public ResponseEntity<String> getAIResponse(
            @PathVariable String model,
            @PathVariable String prompt) {

        switch (model.toLowerCase()) {
            case "llama3.2":
                return ResponseEntity.ok(aiService.useLlama3(prompt));
            case "smollm2":
                return ResponseEntity.ok(aiService.useSmollm(prompt));
            case "deepseek-r1":
                return ResponseEntity.ok(aiService.useDeepSeek(prompt));
            default:
                return ResponseEntity.badRequest().body("Unsupported model: " + model);
    }
}
}