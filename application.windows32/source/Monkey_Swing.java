import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Monkey_Swing extends PApplet {


SoundFile file;
int level;
float x;
float y;
float z;
float rep1;
float rep2;
float xBrzina;
float yVisina;
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
Lijana lijana1,lijana2,lijana3;
Stablo stablo1,stablo2,stablo3,stablo4,stablo5,stablo6;


public void setup() {
  
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
  lBrzina = 0;
  limit = 0;
  currentTime = 0;
  currentFire = 0;
  bestTime = 0;
  bestFire = 0;
  v = 0;
  vBrzina = 3;
  check = 0;
  lijana1 = new Lijana (100);
  lijana2 = new Lijana (400);
  lijana3 = new Lijana (700);
  stablo1 = new Stablo (random(50,90),random(30,50));
  stablo2 = new Stablo (random(180,220),random(30,50));
  stablo3 = new Stablo (random(310,350),random(30,50));
  stablo4 = new Stablo (random(450,490),random(30,50));
  stablo5 = new Stablo (random(580,620),random(30,50));
  stablo6 = new Stablo (random(710,750),random(30,50));
}

public void draw() {
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

public void menu() {
  noStroke();
  fill(64, 32, 0);
  rect(0, 200, 800, 400);
  stroke(0, 64, 0);
  strokeWeight(2);
  fill(0, 192, 0);
  rect(395, 195, 10, 410);
  noStroke();
  fill(0, 128, 0);
  rect(0, 0, 800, 200);
  textSize (100);
  fill(128, 64, 0);
  for (int i = -1; i < 5; i++) {
    text("Monkey Swing", 55+i, 135);
    text("Monkey Swing", 55, 135+i);
  }
  fill(255, 192, 128);
  text("Monkey Swing", 55, 135);
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

public void timeAttack() {
  background(0);
  noStroke();
  //suma
  fill(64, 144, 208);
  rect(0, 100, 800, 400);
  //stabla
  stablo1.stablo(lBrzina);
  stablo2.stablo(lBrzina);
  stablo3.stablo(lBrzina);
  stablo4.stablo(lBrzina);
  stablo5.stablo(lBrzina);
  stablo6.stablo(lBrzina);
  //lijane
  lijana1.lijana(lBrzina);
  lijana2.lijana(lBrzina);
  lijana3.lijana(lBrzina);
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

public void fireRun() {
  background(0);
  noStroke();
  //suma
  fill(64, 144, 208);
  rect(0, 100, 800, 400);
  //stabla
  stablo1.stablo(lBrzina);
  stablo2.stablo(lBrzina);
  stablo3.stablo(lBrzina);
  stablo4.stablo(lBrzina);
  stablo5.stablo(lBrzina);
  stablo6.stablo(lBrzina);
  //lijane
  lijana1.lijana(lBrzina);
  lijana2.lijana(lBrzina);
  lijana3.lijana(lBrzina);
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
  //vatra
  vBrzina += 0.001f;
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

public void keyReleased() {
  klik = 0;
}
class Lijana{
  float l1;
  Lijana (float _l1){
    l1 = _l1;
  }
  public void lijana (float l2){
    l1 += l2;
  if (l1 < -95) {
    l1 = 800;
  }
  if (l1 > 885) {
    l1 = -10;
  }
  stroke(0, 64, 0);
  strokeWeight(2);
  fill(0, 192, 0);
  rect(l1, 98, 10, 225);
  noStroke();
  }
}
class Stablo{
  float s1;
  float s2;
  Stablo (float _s1, float _s2){
    s1 = _s1;
    s2 = _s2;
  }
  public void stablo (float l2){
    s1 += l2/3;
  if (s1 < -s2) {
    s1 = 800;
  }
  if (s1 > 800) {
    s1 = -s2;
  }
  fill(64, 48, 32);
  rect(s1, 100, s2, 400);
  }
}
  public void settings() {  size(800, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Monkey_Swing" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
