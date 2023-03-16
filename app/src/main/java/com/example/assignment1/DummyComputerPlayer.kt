package com.example.assignment1

import java.util.*

class DummyComputerPlayer(newGameActivity: NewGameActivity): Player(newGameActivity) {
    fun chooseReRoll(): Boolean{
        val random = Random()
        return random.nextBoolean()
    }

    override fun reRoll(array: Array<Dice>) {
        if(rollCount<3){
            for (die in array){
                die.roll()
            }
            rollCount++
        }
    }



/*
    /**
     *
     *
     * @param dice
     */
    override fun rollDice(vararg dice: Dice) {
        super.rollDice(*dice)
    }

    fun chooseReRoll(): Boolean{
        val random = Random()
        return random.nextBoolean()
    }

    override fun reRoll(array: Array<Dice>) {
        val random: Random = Random()
        val value = random.nextInt(5)

        if(currentRoll<3){
            for (die in array){
                die.roll()
            }
            currentRoll++
        }
    }

    */

}