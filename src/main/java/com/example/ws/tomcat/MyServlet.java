package com.example.ws.tomcat;

public abstract class MyServlet {
    public abstract void doGet(MyRequest myRequest, MyResponse myResponse);

    public abstract void doPost(MyRequest myRequest, MyResponse myResponse);

    public void service(MyRequest request, MyResponse response) {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            doPost(request, response);
        } else if (request.getMethod().equalsIgnoreCase("GET")) {
            doGet(request, response);
        }
    }

}
