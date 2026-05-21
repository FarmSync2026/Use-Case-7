public class Route {
    private String optimalPath;
    private int estimatedTime;

    public Route(String optimalPath, int estimatedTime) {
        this.optimalPath = optimalPath;
        this.estimatedTime = estimatedTime;
    }

    public String getOptimalPath() {
        return optimalPath;
    }
    public int getEstimatedTime() {
        return estimatedTime;
    }
}