package main.Entities;

public class Report {
    private String name;
    private String executionTime;
    private int calls;
    private int comparations;
    private int swaps;

    public Report(String name, String executionTime, int calls, int comparations, int swaps) {
        this.name = name;
        this.executionTime = executionTime;
        this.calls = calls;
        this.comparations = comparations;
        this.swaps = swaps;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }

    public int getComparations() {
        return comparations;
    }

    public void setComparations(int comparations) {
        this.comparations = comparations;
    }

    public int getSwaps() {
        return swaps;
    }

    public void setSwaps(int swaps) {
        this.swaps = swaps;
    }

    @Override
    public String toString() {
        return "\n" + "Report " + name + "\n"
                + "Calls: " + calls + "\n"
                + "Comparisons: " + comparations + "\n"
                + "Swaps: " + swaps + "\n"
                + "Time: " + executionTime + "ns. \n";
    }

    public void imprimir(){
        System.out.println(this.toString());
    }

}
