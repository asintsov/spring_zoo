package test.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        zooEvent.setIndex();
    }
}
