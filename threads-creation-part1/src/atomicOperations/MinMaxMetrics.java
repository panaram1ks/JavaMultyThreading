package atomicOperations;

public class MinMaxMetrics {

    // Add all necessary member variables
    private volatile long max;
    private volatile long min;

    // private volatile double sample;

    /**
     * Initializes all member variables
     */
    public MinMaxMetrics(/*double max, double min*/) {
        // Add code here
        // this.max = max;
        // this.min = min;
    }

    /**
     * Adds a new sample to our metrics.
     */
    public synchronized void addSample(long newSample) {
        // Add code here
        if(newSample > max){
            max = newSample;
        }
        if(min > newSample){
            min = newSample;
        }

    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        // Add code here
        return min;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        // Add code here
        return max;
    }
}
