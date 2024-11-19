package org.example;


import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.huggingface.HuggingFaceChatModel;


import static java.time.Duration.ofSeconds;


public class Main {
    public static void main(String[] args) {
        UserMessage userMessage = UserMessage.from(TextContent.from("who is ismail mhiri?"));
        String HF_API_KEY=System.getenv("HF_API_KEY");
        HuggingFaceChatModel model = HuggingFaceChatModel.builder()
                .accessToken(HF_API_KEY)
                .modelId("meta-llama/Llama-3.2-3B-Instruct")  // Change to a conversational model
                .timeout(ofSeconds(15))
                .temperature(0.7)
                .maxNewTokens(20)
                .waitForModel(true)
                .build();
        AiMessage aiMessage=model.generate(userMessage).content()   ;
        System.out.println(aiMessage);
    }
}