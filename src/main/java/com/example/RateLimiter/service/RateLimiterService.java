package com.example.RateLimiter.service;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterService {
    private final Map<String, UserAccess> accessMap = new ConcurrentHashMap<>();
    private final int REQUEST_LIMIT=5;
    private final long TIME_WINDOW_MS = 60_000;
    
    public boolean isAllowed(String clientId)
    {
        long now= Instant.now().toEpochMilli();
        UserAccess access = accessMap.getOrDefault(clientId, new UserAccess(0,now));

        if(now-access.WindowStart >= TIME_WINDOW_MS)
        {
            access= new UserAccess(1, now);

        }
        else if(access.requestCount < REQUEST_LIMIT)
        {
            access = new UserAccess(access.requestCount+1, access.WindowStart);
        }

        else 
        {
            return false;
        }

        accessMap.put(clientId, access);

        return true;
    }

    private record UserAccess(int requestCount, long WindowStart){}
}
