package com.yk.example.designerPattern.observerPattern;

public interface Subject {
    public void registerObserver(Observer observer);
    
    public void removeObserver(Observer observer);
    
    /**
     * ������״̬�ı�ʱ��֪ͨ���еĹ۲���
     */
    public void notifyObservers();
}
