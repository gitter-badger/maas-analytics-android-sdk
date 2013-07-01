#Mobile as a Service

######Android MaaS Analytics Documentation
**v 1.0.0**
________________
##Overview
The MaaS Analytics SDK provides the ability to generate custom analytic events. Events can be created at a single point
in time or with duration data (for timed events).

##Prerequisites
The MaaS Analytics SDK requires the latest `MaaS Core SDK`.

Be sure to install the module in the `Application` `onCreate` method before registering keys. For example:
``` Java
@Override
public void onCreate() {
    super.onCreate();
    /* Other Code */
    PwCoreSession.getInstance().installModules(PwAnalyticsModule.getInstance(), ...);
    /* Other code */
}
```

### Adding Events

Adding events with MaaSAnalytics is easy:
```JAVA
public class AnalyticsSample extends Activity
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        
        /* Other code */
        
        //Requires a context and event name
	     PwAnalyticsModule.addEvent(this, "Featured Page View");
        
        /* Other code */
    }
}
```

### Timed Events

MaaSAnalytics supports timed analytics:
```Java
public void startLevel()
{	
    // Start a timed event like so
    PwAnalyticsModule.startTimedEvent(this, "My Awesome Game - Level 1");
    // 'this' refers to a context
}

public void endLevel()
{	
	// To end a timed event pass in the same event name:
	PwAnalyticsModule.endTimedEvent(this, "My Awesome Game - Level 1");
  // 'this' referes to a context
}
```

#### Pausing and Resuming Timed Events
MaaSAnalytics allows you to pause and resume timed events. If an event is in a paused state when `endTimedEvent` is called on it then the paused timestamp will be used to calculate an event's duration.

public void pauseGame()
{	
    // Pause a timed event like so
    PwAnalyticsModule.pauseTimedEvent("My Awesome Game - Level 1");
}

public void resumeGame()
{	
	// To end a timed event pass in the same event name:
	PwAnalyticsModule.resumeTimedEvent("My Awesome Game - Level 1");
}
```

### Event Parameters

MaaSAnalytics allows you to paramaterize all of your events with up to 10 string key pair values.
```Java
@Override
public void onCreate()
{
    super.onCreate();
    
    /* Other code */
    
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("gender", "male");
    PwAnalyticsModule.addEventWithParameters(this, "Featured Page View", params);
    
    params = new HashMap<String, String>();
    params.put("difficulty", "easy");
    PwAnalyticsModule.startTimedEventWithParameters(this, "My Awesome Game - Level 1", params);
    /* Other code */
}

@Override
public void onStop()
{
    super.onStop();
    params = new HashMap<String, String>();
    params.put("difficulty", "easy");
    params.put("attempts", "5");
    // Keep in mind that when calling endTimedEvent:withParameters it will replace any parameters that you specified in startTimedEvent:withParameters.
    PwAnalyticsModule.endTimedEventWithParameters(this, "My Awesome Game - Level 1", params);
}
```

That's all there is to it!
