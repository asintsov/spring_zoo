package test.event;

import org.springframework.context.ApplicationEvent;

public class ZooEvent extends ApplicationEvent {

    //private String message;
    private int index;

//    public ZooEvent(Object source, int index) {
//        super(source);
//        this.index = index;
//    }

    public ZooEvent(Object source, int index) {
        super(source);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex() {
        this.index++;
    }
}
