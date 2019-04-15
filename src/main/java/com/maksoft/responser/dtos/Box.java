package com.maksoft.responser.dtos;

/**
 *
 * @author markw
 */
public class Box {
        private String id;
        private String colour;
        private String size;

    public Box() {
    }

    public Box(String id, String colour, String size) {
        this.id = id;
        this.colour = colour;
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Box{" + "id=" + id + ", colour=" + colour + ", size=" + size + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

    
}
