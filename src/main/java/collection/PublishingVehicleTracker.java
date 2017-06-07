package collection;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Andrew  on 2017/5/30.
 */

public class PublishingVehicleTracker {
    private final Map<String,SafePoint> location;
    private final Map<String,SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String,SafePoint> location){
        this.location = new ConcurrentHashMap<>(location);
        this.unmodifiableMap = Collections.unmodifiableMap(this.location);
    }

    public Map<String,SafePoint>getLocations(){
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id){
        return location.get(id);
    }

    public void  setLocation(String id, int x, int y){
        if (!location.containsKey(id)){
            throw  new IllegalArgumentException("invalid vehicle name: "+id);
        }
            location.get(id).set(x,y);
    }
}
