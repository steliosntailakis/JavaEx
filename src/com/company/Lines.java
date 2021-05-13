package com.company;

public class Lines {

  private int numberOfLines;
  private int numberOfRows;

  public Lines(int numberOfLines, int numberOfRows) {
    this.numberOfLines = numberOfLines;
    this.numberOfRows = numberOfRows;
  }

  public int getNumberOfLines() {
    return numberOfLines;
  }

  public void setNumberOfLines(int numberOfLines) {
    this.numberOfLines = numberOfLines;
  }

  public int getNumberOfRows() {
    return numberOfRows;
  }

  public void setNumberOfRows(int numberOfRows) {
    this.numberOfRows = numberOfRows;
  }
}
