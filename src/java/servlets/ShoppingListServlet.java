/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 826847
 */
public class ShoppingListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
  
       
        String username = request.getParameter("username");
        
           if(session.getAttribute("username") != null)
      {
         
        if(action != null && action.equals("reset"))
        {
            request.setAttribute("message", "Successfully Logged out");
            session.invalidate();
            session = request.getSession();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
       return;
      }
    
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
       
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   HttpSession session = request.getSession();
   String username = request.getParameter("username");
  String action = request.getParameter("action");
    String item = request.getParameter("item");
    String pickedItem = request.getParameter("pickedItem");
    ArrayList<String> item2;
        
        
         if(action != null && action.equals("register"))
        {
                if(username != null && !username.isEmpty())
        {
            session.setAttribute("username", username);
           getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
           return;
        }
                if(username == null || username.isEmpty())
                {
                    request.setAttribute("message", "Username cannot be blank");
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    return;
                    
                }
        }
                
        
            
         if(action != null && action.equals("delete"))
        {
            item2 = (ArrayList<String>) session.getAttribute("items");
            request.setAttribute("message", pickedItem);
           
          
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;
        }
         if(action != null && action.equals("add"))
        {
            request.setAttribute("message", "Successfully Added");
             try {
            item2 = (ArrayList<String>) session.getAttribute("items");
            
             ArrayList<String> items = new  ArrayList<>(item2);  
             if(item != null)
         {
             
             items.add(item);
            
            request.setAttribute("item", item);
            
            
             session.setAttribute("items", items);
               getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
               return;
             
         }
        } catch (Exception ex) {
            
        }
      
      try {
            
            
             ArrayList<String> items = new  ArrayList<>();  
             if(item != null)
         {
            
           
             
             
             items.add(item);
            
            request.setAttribute("item", item);
            
            
             session.setAttribute("items", items);
               getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
               return;
             
         }
        } catch (Exception ex) {
            
        }
         
        
        
              
         
         
         
         
         if(item.isEmpty() || item == null)
         {
             request.setAttribute("message", "item is empty");
             getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
             return;
         }
         getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
         return;
         
        }
        
     
         
           
            
        
         
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        
      
    }

  

}
