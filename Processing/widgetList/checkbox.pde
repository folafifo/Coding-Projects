class checkBox extends Widget {
  boolean state1, state2, state3;
  color boxColor;
  checkBox(int x, int y, int width, int height, 
    int event) {
    this.x=x; 
    this.y=y;  
    this.width = width;
    this.height= height;
    this.event=event; 
    strokeColor = (255);
    state1= false;
    state2= false;
    state3=false;
    boxColor= color(0);
  }
  void draw() {
    stroke(strokeColor);
    fill(boxColor);
    rect(x, y, width, height);
    line(x+100, y, x+100, y+100);
    line(x+200, y, x+200, y+100);
    if (state1) {
      fill(#308BCE);
      rect(x+35, y+35, 30, 30);
    }
    if (state2) {
      fill(#308BCE);
      rect(x+135, y+35, 30, 30);
    }
    if (state3) {
      fill(#308BCE);
      rect(x+235, y+35, 30, 30);
    }
  }
}
