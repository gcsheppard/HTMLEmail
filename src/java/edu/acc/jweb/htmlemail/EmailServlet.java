package edu.acc.jweb.htmlemail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"", "/email"})
public class EmailServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
            String host = "smtp.gmail.com";
            String port = "587";
            String user = "atypicalcat";
            String pass = "quickcat";
            String recipient = "atypicalcat@gmail.com";
            String subject = "shipment notification";
            String message = "<div><font color=blue size=5 align=center>Hello Frodo Baggins:</font></div><br>";
            message = message + "<div><font color=blue size=3>Your order #1 has shipped.</font></div><br>";
            message = message + "<div><font color=blue size=3>This shipment includes:</font></div><br>";
            message = message + "<table border=1><tr><td>11</td><td>12</td></tr>"
                    + "<tr><td>21</td><td>22</td></tr></table>";
            try {
                EmailUtility.sendEmail(host, port, user, pass, recipient, subject, message);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                getServletContext().getRequestDispatcher("/mail_sent.jsp").forward(request, response);
            }
        }
    }
