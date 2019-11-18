class Bullet {
  int xpos, ypos;
  color bulletColor = color(255);

  Bullet( int x) {
    xpos = x+50 ;
    ypos = SCREENY-MARGIN-PADDLEHEIGHT-BULLET_HEIGHT;
  }
  int x() {
    return xpos;
  }
  int y() {
    return ypos;
  }
  void move() {
    ypos-=5;
    if (ypos < 0) {
      canShoot = true;
    } else {
      canShoot = false;
    }
  }
  void draw() {
    fill(bulletColor);
    rect(xpos, ypos, BULLET_WIDTH, BULLET_HEIGHT);
  }
  void collide (Alien[] currentAlien) {
    for (int i = 0; i<currentAlien.length; i++) {
      if ( (ypos >= currentAlien[i].y()) && (ypos <= currentAlien[i].y() + currentAlien[i].normalImg.height) && 
        (xpos >= currentAlien[i].x()) && (xpos <= currentAlien[i].x() + currentAlien[i].normalImg.width) ) {
        currentAlien[i].status = ALIEN_DEAD;
      }
    }
  }
  void collideShield(Shield shield) {
    if ((ypos>=shield.y())&&(ypos<=shield.y()+SHIELD_HEIGHT)&&(xpos>=shield.x())&&(xpos<=shield.x()+SHIELD_WIDTH)) {
      shield.health -= 10;
    }
  }
}
