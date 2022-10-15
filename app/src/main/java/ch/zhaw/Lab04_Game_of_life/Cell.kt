package ch.zhaw.Lab04_Game_of_life

import kotlin.random.Random

class Cell constructor(){
    var state = Random.nextInt(0,2)
}