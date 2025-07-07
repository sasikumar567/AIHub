package com.sasikumar.AiHub.Configuration;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;

import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class OllamaConfig {

    @Bean
    public OllamaApi ollamaApi() {
          return OllamaApi.builder()
        	    .baseUrl("http://localhost:11434")
        	    .restClientBuilder(RestClient.builder())
        	    .webClientBuilder(WebClient.builder())
        	    .responseErrorHandler(new DefaultResponseErrorHandler())
        	    .build();
         

    }

    @Bean
    public OllamaChatModel smollm2Model(OllamaApi ollamaApi) {
        return OllamaChatModel.builder()
            .ollamaApi(ollamaApi)
            .defaultOptions(OllamaOptions.builder()
                .model("smollm2:latest")
                .build())
            .build();
    }

    @Bean
    public OllamaChatModel llama3Model(OllamaApi ollamaApi) {
        return OllamaChatModel.builder()
            .ollamaApi(ollamaApi)
            .defaultOptions(OllamaOptions.builder()
                .model("llama3.2:latest")
                .build())
            .build();
    }

    @Bean
    public OllamaChatModel deepseekModel(OllamaApi ollamaApi) {
        return OllamaChatModel.builder()
            .ollamaApi(ollamaApi)
            .defaultOptions(OllamaOptions.builder()
                .model("deepseek-r1:1.5b")
                .build())
            .build();
    }
}