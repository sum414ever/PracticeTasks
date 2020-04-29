enum LineType {
  SOLID("solid"), DOTTED("dotted"), DASHED("dashed"), DOUBLE("double");

  String lowerCase;

  LineType(String lowerCase) {
    this.lowerCase = lowerCase;
  }

}

  public static String drawLine(LineType lineType) {

    return "The line is " + lineType.lowerCase + " type";

  }
