/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportationmanagementsystem;


public class busShedule {
    
    private int bid;
    private String origin;
    private String destination;
    private String time;

    public busShedule(int did, String origin, String destination, String time) {
        this.bid = did;
        this.origin = origin;
        this.destination = destination;
        this.time = time;
    }

    public busShedule() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int did) {
        this.bid = did;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "busShedule{" + "did=" + bid + ", origin=" + origin + ", destination=" + destination + ", time=" + time + '}';
    }
    
}
