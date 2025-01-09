package platformer.Wrappers;

import java.util.List;

import processing.core.PVector;

public class TouchingData {
    private List<String> touchingTypes;
    private List<PVector> touchingPos;
    private PVector dimensions;

    public TouchingData(List<String> touchingTypes, List<PVector> touchingPos, PVector dimensions) {
        this.touchingTypes = touchingTypes;
        this.touchingPos = touchingPos;
        this.dimensions = dimensions;
    }

    public List<String> getTouchingTypes() {
        return touchingTypes;
    }

    public List<PVector> getTouchingPos() {
        return touchingPos;
    }

    public PVector getDimensions() {
        return dimensions;
    }
}