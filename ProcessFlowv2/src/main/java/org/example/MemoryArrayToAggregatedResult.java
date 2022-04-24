package org.example;

public class MemoryArrayToAggregatedResult implements Step{

    private String commaSeparatedData;
    private String aggregatedResult;
    private final AggregateResultAdapter aggregateResultAdapter;

    public MemoryArrayToAggregatedResult(AggregateResultAdapter aggregateResultAdapter) {
        this.aggregateResultAdapter = aggregateResultAdapter;
    }

    @Override
    public void setInput(String input) {
        commaSeparatedData = input;
    }

    @Override
    public String getOutput() {
        return aggregatedResult;
    }

    @Override
    public void doIt() {
       aggregatedResult = aggregateResultAdapter.count(commaSeparatedData);

    }
}
