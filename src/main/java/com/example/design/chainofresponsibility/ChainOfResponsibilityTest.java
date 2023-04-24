package com.example.design.chainofresponsibility;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Request build = new Request.RequestBuilder().frequentOk(true).loggedOn(true).containsSensitiveWords(true).isPermits(true).build();

        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(new SensitiveWordsHandler(new PermissionHandler(null))));
        boolean process = requestFrequentHandler.process(build);
        System.out.println(process);
    }
}

class Request{
    private boolean loggedOn;
    private boolean frequentOk;

    private boolean isPermits;
    private boolean containsSensitiveWords;
    private String requestBody;

    private Request(boolean loggedOn, boolean frequentOk, boolean containsSensitiveWords, boolean isPermits){
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.containsSensitiveWords = containsSensitiveWords;
        this.isPermits = isPermits;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }

    public boolean isPermits() {
        return isPermits;
    }

    static class RequestBuilder{
        private boolean loggedOn;
        private boolean frequentOk;
        private boolean containsSensitiveWords;
        private boolean isPermits;

        private String requestBody;

        public RequestBuilder loggedOn(boolean loggedOn){
            this.loggedOn = loggedOn;
            return this;
        }

        public RequestBuilder frequentOk(boolean frequentOk){
            this.frequentOk = frequentOk;
            return this;
        }

        public RequestBuilder containsSensitiveWords(boolean containsSensitiveWords){
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public RequestBuilder isPermits(boolean isPermits){
            this.isPermits = isPermits;
            return this;
        }

        public RequestBuilder requestBody(String requestBody){
            this.requestBody = requestBody;
            return this;
        }

        public Request build(){
            return new Request(loggedOn, frequentOk, containsSensitiveWords, isPermits);
        }
    }
}

abstract class Handler{
    Handler next;
    public Handler(Handler next){
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class  RequestFrequentHandler extends Handler{

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("请求频率控制");
        if(!request.isFrequentOk()){
            System.out.println("请求频率过高");
            return false;
        }
        return checkNext(request);
    }

    private boolean checkNext(Request request) {
        Handler next = getNext();
        if(next != null){
            return next.process(request);
        }
        return true;
    }
}

class LoggingHandler extends Handler{
    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登录控制");
        if(!request.isLoggedOn()){
            System.out.println("未登录");
            return false;
        }
        return checkNext(request);
    }

    private boolean checkNext(Request request) {
        Handler next = getNext();
        if(next != null){
            return next.process(request);
        }
        return true;
    }
}

class SensitiveWordsHandler extends Handler{
    public SensitiveWordsHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("敏感词控制");
        if(!request.isContainsSensitiveWords()){
            System.out.println("包含敏感词");
            return false;
        }
        return checkNext(request);
    }

    private boolean checkNext(Request request) {
        Handler next = getNext();
        if(next != null){
            return next.process(request);
        }
        return true;
    }
}

class PermissionHandler extends Handler{
    public PermissionHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("权限控制");
        if(!request.isPermits()){
            System.out.println("权限不足");
            return false;
        }
        return checkNext(request);
    }

    private boolean checkNext(Request request) {
        Handler next = getNext();
        if(next != null){
            return next.process(request);
        }
        return true;
    }
}