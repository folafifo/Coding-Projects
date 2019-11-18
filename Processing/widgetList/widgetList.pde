PFont stdFont;
final int EVENT_BUTTON1=1;
final int EVENT_BUTTON2=2;
final int EVENT_BUTTON3=3;
final int EVENT_NULL=0;
final int CHECKBOX_EVENT = 5;
Widget widget1, widget2, widget3;
checkBox checkBox;
ArrayList widgetList;
color sqColor;
color stroke;
void settings() {
  size(800, 800);
}
void setup() {
  stdFont=loadFont("Serif-18.vlw");
  stroke = (0);
  textFont(stdFont);
  sqColor = (0);
  widget1=new Widget(200, 100, 180, 40, 
    "RED", color(255, 0, 0), 
    stdFont, EVENT_BUTTON1);
  widget2=new Widget(100, 200, 180, 40, 
    "BLUE", color(#308BCE), 
    stdFont, EVENT_BUTTON2);                          
  widget3 = new Widget(300, 200, 180, 40, "GREEN", 
    color(0, 204, 4), stdFont, EVENT_BUTTON3);
  checkBox = new checkBox(200, 600, 300, 100, CHECKBOX_EVENT);
  widgetList = new ArrayList();
  widgetList.add(widget1);
  widgetList.add(widget2);
  widgetList.add(widget3);
}

void draw() {
  background(138, 43, 226);
  for (int i = 0; i<widgetList.size(); i++) {
    Widget aWidget = (Widget)widgetList.get(i);
    aWidget.draw();
    stroke(stroke);
    fill(sqColor);
    rect( 230, 260, 150, 150);
  }
  checkBox.draw();
}

void mousePressed() {
  int event;

  for (int i = 0; i<widgetList.size(); i++) {
    Widget aWidget = (Widget) widgetList.get(i);
    event = aWidget.getEvent(mouseX, mouseY);
    switch(event) {
    case EVENT_BUTTON1:
      sqColor= color(255, 0, 0);
      break;
    case EVENT_BUTTON2:
      sqColor = color(#308BCE);
      break;
    case EVENT_BUTTON3:
      sqColor = color(0, 204, 4);
      break;
    }
  }

  if ((checkBox.getEvent(mouseX, mouseY)==CHECKBOX_EVENT)) {
    if ((mouseX > checkBox.x)&&(mouseX<checkBox.x+100)) {
      checkBox.state1 = true;
      checkBox.state2 = false;
      checkBox.state3 = false;
    } else if ((mouseX > checkBox.x+100)&&(mouseX<checkBox.x+200)) {
      checkBox.state1 = false;
      checkBox.state2 = true;
      checkBox.state3 = false;
    } else  if ((mouseX > checkBox.x+200)&&(mouseX<checkBox.x+300)) {
      checkBox.state1 = false;
      checkBox.state2 = false;
      checkBox.state3 = true;
    }
  }
}
void mouseMoved() {
  int event1;
  int event2;
  int event3;
  event1 = widget1.getEvent(mouseX, mouseY);
  event2 = widget2.getEvent(mouseX, mouseY);
  event3 = widget3.getEvent(mouseX, mouseY);
  if (event1==EVENT_BUTTON1) {
    widget1.strokeColor= color(255);
  } else {
    widget1.strokeColor= color(0);
  }
  if (event2==EVENT_BUTTON2) {
    widget2.strokeColor= color(255);
  } else {
    widget2.strokeColor= color(0);
  }
  if (event3==EVENT_BUTTON3) {
    widget3.strokeColor= color(255);
  } else {
    widget3.strokeColor= color(0);
  }
}
