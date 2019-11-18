PFont stdFont;
final int EVENT_BUTTON1=1;
final int EVENT_BUTTON2=2;
final int EVENT_BUTTON3=3;
final int EVENT_BUTTON4=4;
final int EVENT_NULL=0;
Widget widget1, widget2, widget3, widget4;
Screen screen1, screen2, currentScreen;
color stroke;
void settings() {
  size(600, 600);
}
void setup() {
  stdFont=loadFont("Serif-18.vlw");
  stroke = (0);
  textFont(stdFont);
  widget1=new Widget(100, 200, 180, 40, 
    "Move to screen 2.", color(255, 0, 0), 
    stdFont, EVENT_BUTTON1);
  widget2=new Widget(300, 200, 180, 40, 
    "Press me!", color(#308BCE), 
    stdFont, EVENT_BUTTON2);                          
  widget3 = new Widget(100, 300, 180, 40, "Back to screen 1. ", 
    color(138, 43, 226), stdFont, EVENT_BUTTON3);
  widget4 = new Widget(300, 300, 180, 40, "Press me!", 
    color(0, 204, 4), stdFont, EVENT_BUTTON4);
  screen1 = new Screen(color(255, 200, 200));
  screen1.addWidget(widget1);
  screen1.addWidget(widget2);
  screen2 = new Screen(color(255, 204, 0));
  screen2.addWidget(widget3);
  screen2.addWidget(widget4);
  currentScreen = screen1;
}

void draw() {
  currentScreen.draw();
}

void mousePressed() {
  int event1;
  int event2;
  int event3;
  int event4;
  event1 = widget1.getEvent(mouseX, mouseY);
  event2 = widget2.getEvent(mouseX, mouseY);
  event3 = widget3.getEvent(mouseX, mouseY);
  event4 = widget4.getEvent(mouseX, mouseY);
  if (event1==EVENT_BUTTON1) {
    currentScreen = screen2;
  } 
  if (event2==EVENT_BUTTON2) {
    screen1.count++;
  } 
  if (event3==EVENT_BUTTON3) {
    currentScreen= screen1;
  } 
  if (event4==EVENT_BUTTON4) {
    screen2.count++;
  }
}
