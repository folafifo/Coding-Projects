class Ball {
  float x; 
  float y;
  float dx; 
  float dy;
  int radius;
  color ballColor = color(0);
  Ball() {
    x = random(SCREENX/4, SCREENX/2);
    y = random(SCREENY/4, SCREENY/2);
    dx = random(1, 2); 
    dy = random(1, 2);
    radius=15;
  }

  void move() {
    x = x+dx; 
    y = y+dy;
  }
  float positionY() {
    return y;
  }
  float positionX()
  {
    return x;
  }
  void draw() {
    fill(ballColor);
    ellipse(int(x), int(y), radius, 
      radius);
  }
  void collide(Computer tc) {
    if (y+radius >= tc.ypos && y-radius<tc.ypos+PADDLEHEIGHT && x >=tc.xpos && x <=tc.xpos+PADDLEWIDTH)
    {
      println("collided!");
      dy=-dy;
    }
  }
  void collide(Player tp) {
    if (x-radius <=0) dx=-dx;
    else if (x+radius>=SCREENX) dx=-dx;

    if (y+radius >= tp.ypos && y-radius<tp.ypos+PADDLEHEIGHT && x >=tp.xpos && x <=tp.xpos+PADDLEWIDTH)
    {
      println("collided!");
      dy=-dy;
    }
  }
}
