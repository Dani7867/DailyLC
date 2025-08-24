class BrowserHistory {

    private List<String> pages;
    private int currpg,latestpg;
    
    public BrowserHistory(String homepage) {
        this.pages = new ArrayList<>();
        this.pages.add(homepage);
        currpg = 0;
        latestpg = 0;
    }
    
    public void visit(String url) {
        if(currpg + 1 == pages.size()){
            pages.add(url);
        }else{
            pages.set(currpg+1,url);
        }
        currpg++;
        latestpg = currpg;
    }
    
    public String back(int steps) {
        currpg = Math.max(currpg - steps,0);
        return pages.get(currpg);
    }
    
    public String forward(int steps) {
        currpg = Math.min(currpg + steps,latestpg);
        return pages.get(currpg);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */