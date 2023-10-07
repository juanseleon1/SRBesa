package BESA.SocialRobot.UserEmotionalInterpreterAgent.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotionalData;

public abstract class UserEmotionalModel {
    
    private List<UserEmotionalData> emotionBundles;
    private Timer timer = new Timer();
    private long cleanUpTime=20000;

    public UserEmotionalModel() {
        emotionBundles = new ArrayList<>();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                cleanupExpiredBundles();
            }
        }, cleanUpTime);
    }
    public abstract void persist();

    public abstract List<UserEmotion> calculateCompositeEmotions();

    public void addEmotionBundle(UserEmotionalData bundle) {
        this.emotionBundles.add(bundle);
    }

    public void setCleanUpTime(long cleanUpTime) {
        this.cleanUpTime = cleanUpTime;
    }

    public void cleanupExpiredBundles() {
        LocalDateTime dateLimit = LocalDateTime.now().minus(cleanUpTime, ChronoUnit.MINUTES);
        //Get iterator for the bundle list
        Iterator<UserEmotionalData> iterator = this.emotionBundles.iterator();
        //traverse iterator and remove expired bundles
        while (iterator.hasNext()) {
            UserEmotionalData bundle = iterator.next();
            if (bundle.getTimestamp().isBefore(dateLimit)) {
                iterator.remove();
            }
        }
    }
    public List<UserEmotionalData> getEmotionBundles() {
        return emotionBundles;
    }
    public void setEmotionBundles(List<UserEmotionalData> emotionBundles) {
        this.emotionBundles = emotionBundles;
    }
}
