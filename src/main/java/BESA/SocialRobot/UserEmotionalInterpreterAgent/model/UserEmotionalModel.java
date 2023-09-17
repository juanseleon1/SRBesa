package BESA.SocialRobot.UserEmotionalInterpreterAgent.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;

public abstract class UserEmotionalModel {
    
    List<EmotionBundle> emotionBundles;
    private Timer timer = new Timer();
    private long cleanUpTime;

    public UserEmotionalModel() {
            timer.schedule(new TimerTask() {
            @Override
            public void run() {
                cleanupExpiredBundles();
            }
        }, cleanUpTime);
    }
    public abstract void persist();

    public abstract List<UserEmotion> calculateCompositeEmotions();

    public void addEmotionBundle(EmotionBundle bundle) {
        this.emotionBundles.add(bundle);
    }

    public void setCleanUpTime(long cleanUpTime) {
        this.cleanUpTime = cleanUpTime;
    }

    public void cleanupExpiredBundles() {
        LocalDateTime dateLimit = LocalDateTime.now().minus(cleanUpTime, ChronoUnit.MINUTES);
        //Get iterator for the bundle list
        Iterator<EmotionBundle> iterator = this.emotionBundles.iterator();
        //traverse iterator and remove expired bundles
        while (iterator.hasNext()) {
            EmotionBundle bundle = iterator.next();
            if (bundle.getTimestamp().isBefore(dateLimit)) {
                iterator.remove();
            }
        }
    }
}
