package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String id = req.getParameter("id");
        List<String> messages = HolderServlet.getChatHistory(id);

        if (id.length() > 0) {
            session.setAttribute("id", id);
            session.setAttribute("chatHistory", messages);
            HolderServlet.createChat(id);
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("chat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String message = req.getParameter("message");
        String username;

        if (req.getParameter("username").length() != 0) {
            username = req.getParameter("username");
        } else {
            username = "Unknown User";
        }

        if (id.length() > 0 && message.length() > 0 && username.length() > 0) {
            req.getSession().setAttribute("id", id);
            req.getSession().setAttribute("message", message);
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("chatHistory", HolderServlet.getChatHistory(id));
            HolderServlet.addMessage(id, new SimpleDateFormat("hh:mm").format(Calendar.getInstance().getTime()) + " " + username + ": " + message);
        }

        req.getRequestDispatcher("chat.jsp").forward(req, resp);
    }
}
