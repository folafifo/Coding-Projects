
class Alien {
  int x, y, direction;
  int status;
  PImage normalImg, explodeImg;
  boolean canDrop;
  Bomb myBomb;
  Alien (int xpos, int ypos, PImage okImg, PImage exImg) { 
    x = xpos;
    y = ypos;
    status = ALIEN_ALIVE;
    normalImg=okImg; 
    explodeImg=exImg; 
    direction=FORWARD;
    myBomb = null;
    canDrop = true;
  }
  int x() {
    return x;
  }
  int y() {
    return y;
  }
  int getStatus() {
    return status;
  }
  void move() { 
    if (direction==FORWARD) {
      if (x+normalImg.width<SCREENX-1) x+=2;
      else {
        direction=BACKWARD; 
        y+=normalImg.height+GAP;
      }
    } else if (x>0) x-=2; 
    else {
      direction=FORWARD;
      y+=normalImg.height+GAP;
    }
    if (status==ALIEN_ALIVE) {
      int dropBomb = int(random(0, 650));
      if ((dropBomb==25)&&(canDrop)) {
        myBomb = new Bomb(x+(normalImg.width/2), y+normalImg.height);
      }
    }
    if ((theShield!=null)&&(myBomb!=null)) {
      if (myBomb.collideShield(theShield)) {
        myBomb=null;
      }
    }
  }
  Bomb getBomb() {
    if (myBomb!=null) {
      canDrop = myBomb.offScreen();
      return myBomb;
    }
    return null;
  }
  void draw() { 
    if (status==ALIEN_ALIVE) {
      image(normalImg, x, y);
    } else if (status!=ALIEN_DEAD) {
      image(explodeImg, x, y);
    }
  }
}
