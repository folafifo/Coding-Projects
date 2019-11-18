class Widget {
  int x, y, width, height, k;
  String label, user; 
  int event;
  color widgetColor, labelColor;
  PFont widgetFont;
  Widget() {
  }
  Widget(int x, int y, int width, int height, String label, 
    color widgetColor, PFont widgetFont, int event) {
    this.x = x; 
    this.y = y; 
    this.width = width; 
    this.height = height;
    this.label = label; 
    this.event = event; 
    this.widgetColor = widgetColor; 
    this.widgetFont = widgetFont;
    labelColor= color(0); 
    k = 0;
    this.user = "";
  }

  Widget(int x, int y, int width, int height, 
    color widgetColor, PFont widgetFont, int event) {
    this.x = x; 
    this.y = y; 
    this.width = width; 
    this.height = height;
    this.label = ""; 
    this.event = event; 
    this.widgetColor = widgetColor; 
    this.widgetFont = widgetFont;
    labelColor= color(0); 
    k = 0;
  }

  void draw() {
    stroke(k);
    fill(widgetColor);
    rect(x, y, width, height);
    fill(labelColor);
    if (label != null) {
      text(label, x + 10, y + height - 10);
    }
  }

  void getTheStroke(int mX, int mY) {
    if (mX > x && mX < x + width && mY > y && mY < y + height) {
      k = 255;
    } else {
      k = 0;
    }
  }
  int getEvent(int mX, int mY) {
    if (mX > x && mX < x + width && mY > y && mY < y + height) {
      return event;
    }
    return EVENT_NULL;
  }

  String inputViewing(char keyEntered) {
    if (keyEntered == BACKSPACE && label.length() != 0) {
      label = label.substring(0, label.length() - 1);
    }
    if (keyEntered == DELETE && label.length() != 0) {
      label = label.substring(0, label.length() - 1);
    }
    if (keyEntered != ENTER && keyEntered != BACKSPACE && keyEntered != DELETE) {  
      label = label + keyEntered;
    }
    if (keyEntered == ENTER) {
      return label;
    }
    if (keyEntered == RETURN) {
      return label;
    }
    return null;
  }
}
