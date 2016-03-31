
package sears.myapplication;

import java.util.ArrayList;
import java.util.List;



public class Results {

    private int resultCount;
    private List<TrackInfo> results = new ArrayList<TrackInfo>();

    /**
     *
     * @return
     *     The resultCount
     */
    public int getResultCount() {
        return resultCount;
    }

    /**
     *
     * @param resultCount
     *     The resultCount
     */
    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    /**
     *
     * @return
     *     The results
     */
    public List<TrackInfo> getResults() {
        return results;
    }

    /**
     *
     * @param results
     *     The results
     */
    public void setResults(List<TrackInfo> results) {
        this.results = results;
    }

}
