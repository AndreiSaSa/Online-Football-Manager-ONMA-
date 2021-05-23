package com.onma.service.player.observer;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LogObserver extends Observer {

    public LogObserver(final Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update()  {
        System.out.println(subject.getMessage());
        try {
            FileHandler handler = new FileHandler("logger.log", true);
            Logger logger = Logger.getLogger("logger");
            logger.addHandler(handler);
            logger.info(subject.getMessage());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
