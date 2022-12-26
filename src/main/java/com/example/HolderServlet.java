package com.example;

import java.util.*;

public class HolderServlet {
    private static Map<String, List<String>> chatHistory = new LinkedHashMap<>();

    public static List<String> getChatHistory(String id) {
        return chatHistory.get(id);
    }

    public static void addMessage(String id, String message) {
        chatHistory.get(id).add(message);
    }

    public static void createChat(String chatID) {
        if (!chatHistory.containsKey(chatID)) {
            chatHistory.put(chatID, new LinkedList<>());
        }
    }
}