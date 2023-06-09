/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 25.05.23, 11:58
 *  * @Version: LoginAttemptService: 1.0
 *
 */

package com.kj.clinic.security.bruteForce;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class LoginAttemptService {

    private static final int attemptsBeforeBlock = 5;

    private LoadingCache<String, Integer> cachedAttempts;

    public LoginAttemptService() {
        cachedAttempts = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES)
                .build(new CacheLoader<String, Integer>() {
                    public Integer load(String key) {
                        return 0;
                    }
                });
    }

    public void loginSucceeded(String key) {
        cachedAttempts.invalidate(key);
    }

    public void loginFailed(String key) {
        int attemptCounter;
        try {
            attemptCounter = cachedAttempts.get(key);
        } catch (ExecutionException e) {
            attemptCounter = 0;
        }
        attemptCounter++;
        cachedAttempts.put(key, attemptCounter);
    }

    public boolean checkIfIPBlocked(String key) {
        try {
            return cachedAttempts.get(key) >= attemptsBeforeBlock;
        } catch (ExecutionException e) {
            return false;
        }

    }
}
