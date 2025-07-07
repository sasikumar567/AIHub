package com.sasikumar.AiHub.Service;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatClient llama3Client;
    private final ChatClient smollm2Client;
    private final ChatClient deepseekClient;

    public AiService(@Qualifier("llama3Model") OllamaChatModel llama3Client,
            @Qualifier("smollm2Model") OllamaChatModel smollm2Client,
            @Qualifier("deepseekModel") OllamaChatModel deepseekClient) {
        this.llama3Client = ChatClient.create(llama3Client);
        this.smollm2Client = ChatClient.create(smollm2Client);
        this.deepseekClient= ChatClient.create(deepseekClient);
    }

    public String useLlama3(String input) {
        return llama3Client.prompt(input).call().content(); }

    public String useSmollm(String input) {
        return smollm2Client.prompt(input).call().content();
    }

    public String useDeepSeek(String input) {
        return deepseekClient.prompt(input).call().content();
    }
}
