package com.example.assignment1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class NewGameActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_game)

        /*val userDiceOne :ImageView = findViewById(R.id.userDieOne)
        val userDiceTwo :ImageView = findViewById(R.id.userDieTwo)
        val userDiceThree :ImageView = findViewById(R.id.userDieThree)
        val userDiceFour :ImageView = findViewById(R.id.userDieFour)
        val userDiceFive :ImageView = findViewById(R.id.userDieFive)*/

        //val userDiceImageViews = arrayOf(userDiceOne, userDiceTwo, userDiceThree, userDiceFour, userDiceFive)

        val dice1 = Dice(findViewById(R.id.userDieOne))
        val dice2 = Dice(findViewById(R.id.userDieTwo))
        val dice3 = Dice(findViewById(R.id.userDieThree))
        val dice4 = Dice(findViewById(R.id.userDieFour))
        val dice5 = Dice(findViewById(R.id.userDieFive))

        val userDice = arrayOf(dice1, dice2, dice3, dice4,dice5)

        /*val compDiceOne: ImageView = findViewById(R.id.compDieOne)
        val compDiceTwo: ImageView = findViewById(R.id.compDieTwo)
        val compDiceThree: ImageView = findViewById(R.id.compDieThree)
        val compDiceFour: ImageView = findViewById(R.id.compDieFour)
        val compDiceFive: ImageView = findViewById(R.id.compDieFive)*/

        val compDice1 = Dice(findViewById(R.id.compDieOne))
        val compDice2 = Dice(findViewById(R.id.compDieTwo))
        val compDice3 = Dice(findViewById(R.id.compDieThree))
        val compDice4 = Dice(findViewById(R.id.compDieFour))
        val compDice5= Dice(findViewById(R.id.compDieFive))

        val computerDice = arrayOf(compDice1, compDice2, compDice3, compDice4, compDice5)

        val throwButton: Button = findViewById(R.id.throwBtn)
        throwButton.setOnClickListener {
            rollDice(dice1,dice2, dice3, dice4, dice5, compDice1, compDice2, compDice3, compDice4, compDice5)
        }

        val scoreButton: Button = findViewById(R.id.scoreBtn)
        scoreButton.setOnClickListener {

            updateScore(calculateScore(userDice),
            calculateScore(computerDice))
        }

    }

    private fun rollDice(vararg dice: Dice){
        for (die in dice)
            die.roll()

    }

    private fun calculateScore(array: Array<Dice>): Int{
        var score = 0
        for(n in array){
            score += n.score()
        }

        return score
    }

    private fun updateScore(userScore: Int, compScore: Int){
        val score = findViewById<TextView>(R.id.liveScore)

        val scoreText = score.text.toString()
        val divideScores: Array<String>?

        if(scoreText.contains("/")){
            //https://stackoverflow.com/questions/8517730/how-to-get-text-from-textview

            divideScores = scoreText.split("/").toTypedArray()
            val newUserScore = divideScores[0].toInt() + userScore
            val newCompScore = divideScores[1].toInt() + compScore

            val result = "$newUserScore/$newCompScore"

            score.text = result
        }

    }


    fun checkSelected(array: Array<Dice>){
        //set mouse click appearance pass the relevant image views only
        var imageView: ImageView?
        for(die in array){
            imageView = die.getImageResource()
            if(imageView.paddingLeft == 0){
                imageView.setPadding(5, 5,5,5)
                imageView.setBackgroundColor(Color.GREEN)
            }
            else{
                imageView.setPadding(0,0,0,0)
                imageView.setBackgroundColor(Color.WHITE)
            }
        }
        
    }

}