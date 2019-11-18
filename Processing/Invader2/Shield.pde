class Shield {
  int xpos, ypos, health;
  Shield(Player player) {
    xpos = player.x()-25;
    ypos = player.y() -35;
    health = SHIELD_HEALTH;
  }
  int x() {
    return xpos;
  }
  int y() {
    return ypos;
  }
  int health() {
    return health;
  }
  
  void draw() {
    if (health>= 600){
      fill(0, 204, 4);
    }
    else if ((health>=300)&&(health<=599)){
       fill(255, 204, 0);
    }
    else {
      fill(255, 0, 0);
    }
    rect(xpos, ypos, SHIELD_WIDTH, SHIELD_HEIGHT);
  }
  void move(int x) {
    if (x>SCREENX-SHIELD_WIDTH) xpos = SCREENX-SHIELD_WIDTH;
    else xpos=x;
  }
  boolean healthZero() {
    if (health<= 0) {
      return true;
    }
    return false;
  }
}
