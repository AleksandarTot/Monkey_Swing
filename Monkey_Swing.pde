import processing.sound.*;
SoundFile file;
int level;
float x;
float y;
float z;
float rep1;
float rep2;
float xBrzina;
float yVisina;
float l1;
float l2;
float l3;
float lBrzina;
float limit;
int currentTime;
int currentFire;
int bestTime;
int bestFire;
int highTime;
int highFire;
int timer;
float v;
float vBrzina;
int smer;
int check;
int klik;


void setup() {
  size(800, 600);
  file = new SoundFile(this, "monkeymusic.wav");
  file.loop();
  level = 0;
  x = 350;
  y = 300;
  z = 5;
  rep1 = 15;
  rep2 = 35;
  xBrzina = 3;
  yVisina = -1;
  l1 = 100;
  l2 = 400;
  l3 = 700;
  lBrzina = 0;
  limit = 0;
  currentTime = 0;
  currentFire = 0;
  bestTime = 0;
  bestFire = 0;
  v = 0;
  vBrzina = 3;
  check = 0;
}

void draw() {
  switch(level) {
  case 0:
    menu();
    break;
  case 1:
    timeAttack();
    break;
  case 2:
    fireRun();
  }
}

void menu() {
  noStroke();
  fill(0, 128, 0);
  rect(0, 0, 800, 200);
  fill(64, 32, 0);
  rect(0, 200, 800, 400);
  textSize (100);
  fill(128, 64, 0);
  for (int i = -1; i < 5; i++) {
    text("Monkey Swing", 55+i, 135);
    text("Monkey Swing", 55, 135+i);
  }
  fill(255, 192, 128);
  text("Monkey Swing", 55, 135);
  fill(0, 192, 0);
  rect(395, 200, 10, 400);
  fill(255);
  textSize(50);
  text("Time Attack", 50, 400);
  textSize(30);
  text("High Score:"+highTime, 100, 550);
  text("High Score:"+highFire, 505, 550);
  fill(255, 0, 0);
  textSize(50);
  text("Fire Run", 500, 400);
  if (mousePressed && mouseX < 400 && mouseY > 200) {
    level ++;
    check += millis() / 1000;
  }
  if (mousePressed && mouseX > 400 && mouseY > 200) {
    level += 2;
  }
}

void timeAttack() {
  background(0);
  noStroke();
  //suma
  fill(0, 128, 0);
  rect(0, 0, 800, 100);
  fill(64, 32, 0);
  rect(0, 500, 800, 600);
  //rezultat
  fill (0, 192, 0);
  textSize (40);
  text ("Current Score:"+currentTime, 50, 565);
  //rekord
  if (currentTime > bestTime) {
    bestTime = currentTime;
  }
  text ("Best Score:"+bestTime, 490, 565);
  //stoperica
  fill (255);
  if (timer < 10) {
    fill (255, 0, 0);
  }
  textSize (75);
  timer = 30 + check - millis() / 1000;
  text (timer, 355, 75);
  //titl
  textSize (40);
  fill(128, 64, 0);
  for (int i = -1; i < 3; i++) {
    text("Monkey Swing", 30+i, 60);
    text("Monkey Swing", 30, 60+i);
  }
  fill(255, 192, 128);
  text("Monkey Swing", 30, 60);
  fill(128, 64, 0);
  for (int i = -1; i < 3; i++) {
    text("Monkey Swing", 500+i, 60);
    text("Monkey Swing", 500, 60+i);
  }
  fill(255, 192, 128);
  text("Monkey Swing", 500, 60);
  //lijana1
  noStroke();
  l1 += lBrzina;
  if (l1 < -95) {
    l1 = 800;
  }
  if (l1 > 895) {
    l1 = 0;
  }
  fill(0, 192, 0);
  rect(l1, 100, 10, 225);
  //lijana2
  l2 += lBrzina;
  if (l2 < -95) {
    l2 = 800;
  }
  if (l2 > 895) {
    l2 = 0;
  }
  fill(0, 192, 0);
  rect(l2, 100, 10, 225);
  //lijana3
  l3 += lBrzina;
  if (l3 < -95) {
    l3 = 800;
  }
  if (l3 > 895) {
    l3 = 0;
  }
  fill(0, 192, 0);
  rect(l3, 100, 10, 225);
  //majmun
  if (lBrzina == 0) {
    x += xBrzina;
    if (x > 390 || x < 320) {
      xBrzina *= -1;
      z *= -1;
      rep1 *= -1;
      rep2 *= -1;
    }
  } else {
    y += yVisina;
    if (y < 271) {
      yVisina *= -1;
    }
  }
  fill(128, 64, 0);
  rect(x, y, 100, 100);
  rect(x + 45, y + 100, 10, 10);
  rect(x + 30 - rep1, y + 110, 40, 10);
  rect(x + 40 - rep2, y + 120, 20, 10);
  fill(255, 192, 128);
  rect(x + 10, y + 10, 80, 80);
  fill(0);
  rect(x + 30 + z, y + 30, 10, 10);
  rect(x + 60 + z, y + 30, 10, 10);
  rect(x + 40, y + 50, 20, 10);
  rect(x + 30, y + 70, 40, 10);
  if (keyPressed && klik == 0) {
    if (limit == 0) {
      if (xBrzina > 0) {
        lBrzina = -5;
        currentTime ++;
      } else {
        lBrzina = 5;
        currentTime = 0;
      }
    }
    klik = 1;
  }
  if (lBrzina != 0) {
    limit ++;
  }
  if (limit == 61) {
    lBrzina = 0;
    limit = 0;
    yVisina = -1;
  }
  if (timer < 1) {
    fill(0, 128, 0);
    rect(0, 0, 800, 200);
    fill(64, 32, 0);
    rect(0, 200, 800, 400);
    fill(255);
    textSize(75);
    text("SCORE:"+bestTime, 230, 375);
    text("RESTART", 235, 130);
    if (bestTime > highTime) {
      fill(0, 192, 0);
      text("HIGH SCORE!", 165, 475);
    }
    limit = 1;
    if (mousePressed && mouseY < 200) {
      if (bestTime > highTime) {
        highTime = bestTime;
      }
      file.stop();
      setup();
    }
  }
}

void fireRun() {
  background(0);
  noStroke();
  //suma
  fill(0, 128, 0);
  rect(0, 0, 800, 100);
  fill(64, 32, 0);
  rect(0, 500, 800, 600);
  //rezultat
  fill (0, 192, 0);
  textSize (40);
  text ("Current Score:"+currentFire, 50, 565);
  //rekord
  if (currentFire > bestFire) {
    bestFire = currentFire;
  }
  text ("Best Score:"+bestFire, 490, 565);
  //stoperica
  fill (2 * v, 128, 0);
  textSize (60);
  text ("FIRE!", 335, 70);
  //titl
  textSize (40);
  fill(128, 64, 0);
  for (int i = -1; i < 3; i++) {
    text("Monkey Swing", 30+i, 60);
    text("Monkey Swing", 30, 60+i);
  }
  fill(255, 192, 128);
  text("Monkey Swing", 30, 60);
  fill(128, 64, 0);
  for (int i = -1; i < 3; i++) {
    text("Monkey Swing", 500+i, 60);
    text("Monkey Swing", 500, 60+i);
  }
  fill(255, 192, 128);
  text("Monkey Swing", 500, 60);
  //lijana1
  noStroke();
  l1 += lBrzina;
  if (l1 < -95) {
    l1 = 800;
  }
  if (l1 > 895) {
    l1 = 0;
  }
  fill(0, 192, 0);
  rect(l1, 100, 10, 225);
  //lijana2
  l2 += lBrzina;
  if (l2 < -95) {
    l2 = 800;
  }
  if (l2 > 895) {
    l2 = 0;
  }
  fill(0, 192, 0);
  rect(l2, 100, 10, 225);
  //lijana3
  l3 += lBrzina;
  if (l3 < -95) {
    l3 = 800;
  }
  if (l3 > 895) {
    l3 = 0;
  }
  fill(0, 192, 0);
  rect(l3, 100, 10, 225);
  //vatra
  vBrzina += 0.001;
  v += vBrzina;
  fill(255, random(255), 0);
  rect(0, 100, v, 400);
  //majmun
  if (lBrzina == 0) {
    x += xBrzina;
    if (x > 390 || x < 320) {
      xBrzina *= -1;
      z *= -1;
      rep1 *= -1;
      rep2 *= -1;
    }
  } else {
    y += yVisina;
    if (y < 271) {
      yVisina *= -1;
    }
  }
  fill(128, 64, 0);
  rect(x, y, 100, 100);
  rect(x + 45, y + 100, 10, 10);
  rect(x + 30 - rep1, y + 110, 40, 10);
  rect(x + 40 - rep2, y + 120, 20, 10);
  fill(255, 192, 128);
  rect(x + 10, y + 10, 80, 80);
  fill(0);
  rect(x + 30 + z, y + 30, 10, 10);
  rect(x + 60 + z, y + 30, 10, 10);
  rect(x + 40, y + 50, 20, 10);
  rect(x + 30, y + 70, 40, 10);
  if (keyPressed && klik == 0) {
    if (limit == 0) {
      if (xBrzina > 0) {
        lBrzina = -5;
        vBrzina -= 5;
        currentFire ++;
        smer = 1;
      } else {
        lBrzina = 5;
        vBrzina += 5;
        currentFire --;
        smer = 0;
      }
    }
    klik = 1;
  }
  if (lBrzina != 0) {
    limit ++;
  }
  if (limit == 61) {
    lBrzina = 0;
    limit = 0;
    yVisina = -1;
    if (smer == 1) {
      vBrzina += 5;
    } else {
      vBrzina -=5;
    }
  }
  if (x < v) {
    fill(0, 128, 0);
    rect(0, 0, 800, 200);
    fill(64, 32, 0);
    rect(0, 200, 800, 400);
    fill(255);
    textSize(75);
    text("SCORE:"+bestFire, 230, 375);
    text("RESTART", 235, 130);
    if (bestFire > highFire) {
      fill(0, 192, 0);
      text("HIGH SCORE!", 165, 475);
    }
    limit = 1;
    if (mousePressed && mouseY < 200) {
      if (bestFire > highFire) {
        highFire = bestFire;
      }
      file.stop();
      setup();
    }
  }
}

void keyReleased() {
  klik = 0;
}
