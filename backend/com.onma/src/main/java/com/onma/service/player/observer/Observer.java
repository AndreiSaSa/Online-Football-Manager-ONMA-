package com.onma.service.player.observer;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
