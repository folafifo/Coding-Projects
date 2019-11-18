class Screen {
  color background;
  ArrayList widgets;
  int count;

  Screen(color screenColor) {
    this.background = screenColor;
    widgets = new ArrayList();
    count = 0;
  }
  void draw() {
    background(background);
    for (int i = 0; i<widgets.size(); i++) {
      Widget currentWidget = (Widget)widgets.get(i);
      currentWidget.draw();
      text("count = " +count,200,500);
    }
  }
  int getEvent() {
    for (int i = 0; i<widgets.size(); i++) {
      Widget currentWidget = (Widget)widgets.get(i);
      if (!(currentWidget.getEvent(mouseX, mouseY)==EVENT_NULL)) {
        return currentWidget.event();
      }
    }
    return EVENT_NULL;
  }

  void addWidget(Widget widget1) {
    widgets.add(widget1);
  }
}
