package com.bugong.impl;

import com.bugong.event.FileEvent;

import java.util.EventListener;

public interface FileListener extends EventListener {
    public void fileEvent(FileEvent event);

}
