package com.example.ws.tomcat;

import java.io.IOException;

public class GetMoneyServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get money");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post money");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
