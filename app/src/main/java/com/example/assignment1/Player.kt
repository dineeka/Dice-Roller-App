package com.example.assignment1

import android.widget.Button
import android.widget.ImageView

open class Player(private val activity: NewGameActivity){

    private var targetScore = 101
    private var roundScore = 0
    private var totalScore = 0
    protected var rollCount = 0

    private var numOfRolls = 0

    open fun rollDice(vararg dice:Dice){
        for (die in dice)
            die.roll()
        rollCount++
        enableButton(activity,R.id.scoreBtn)
    }

    open fun reRoll(array: Array<Dice>){
        if(rollCount <= 2){
            var imageView: ImageView?

            for (die in array) {
                imageView = die.getImageResource()
                if (imageView.paddingLeft == 0) {
                    die.roll()
                }
            }
            rollCount++
        }
        else{
            rollCount = 0
            disableButton(activity, R.id.throwBtn)
        }
    }

    fun calculateScore(dice: Array<Dice>): Int{
        rollCount = 0
        disableButton(activity,R.id.scoreBtn)
        for(die in dice){
            println(die.score())
            roundScore += die.score()
        }
        return  roundScore
    }

    fun getRolledCount(): Int{
        return rollCount
    }

    fun setRolledCount(value: Int){
        rollCount = value
    }

    private fun enableButton(activity: NewGameActivity, buttonId: Int) {
        val button = activity.findViewById<Button>(buttonId)
        button.isEnabled = true
    }

    private fun disableButton(activity: NewGameActivity, buttonId: Int){
        val button = activity.findViewById<Button>(buttonId)
        button.isEnabled = false
    }



   /*

    var targetScore = 101
    var totalScore = 0
    protected var currentRoll = 0
    open var numOfRolls = 0

    open fun rollDice(vararg dice: Dice){
        currentRoll++
        for (die in dice)
            die.roll()
    }

    open fun reRoll(array: Array<Dice>){
        if (currentRoll < 3) {
            var imageView: ImageView?

            for (die in array) {
                imageView = die.getImageResource()
                if (imageView.paddingLeft == 0) {
                    rollDice(die)
                }
            }
            currentRoll++
        }
        else{
            currentRoll = 0
        }
    }

    open fun calculateScore(array: Array<Dice>): Int{
        for(n in array){
            totalScore += n.score()
        }
        return totalScore
    }

    open fun getCurrentRoll(): Int{
        return currentRoll
    }

    open fun setCurrentRoll(value: Int){
        currentRoll = value
    }
    */
}
