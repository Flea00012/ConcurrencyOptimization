package com.lee.threads;

enum CallStatus{
    QUEUED,
    COMPLETED,

}

public class Call {

    private int duration;

    private CallStatus callStatus;

    public Call(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public CallStatus getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(CallStatus callStatus) {
        this.callStatus = callStatus;
    }

    public void answerTheCall(){
        this.setCallStatus(CallStatus.COMPLETED);
    }
    public CallStatus logCompletedCall(){
        return this.callStatus;
    }

}
