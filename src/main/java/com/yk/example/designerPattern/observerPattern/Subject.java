package com.yk.example.designerPattern.observerPattern;

public interface Subject {
    public void registerObserver(Observer observer);
    
    public void removeObserver(Observer observer);
    
    /**
     * 当主题状态改变时，通知所有的观察者
     */
    public void notifyObservers();
}
