package com.example.miniproject;

public class ticket {
    public double getDiscount (double price , double numTicket)
    {
    if (numTicket>2){
        return (price*numTicket)*0.5;
    }
        else {
            return (price*numTicket);
    }
    }
}
