package jgrapht;

/**
 * Created by viacheslav on 6/12/17.
 */
public enum Color {
    BLACK("black"),
    WHITE("white");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
