package com.company;

public class CommercialPlane extends Aircraft {
    private boolean autoPilot = false;

    public CommercialPlane(String name, int maxPassengers) {
        super( name, maxPassengers );
    }
    public CommercialPlane(String name) {
        super( name, 200 );
    }

}
