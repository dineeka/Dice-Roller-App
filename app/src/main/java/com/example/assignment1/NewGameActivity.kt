package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewGameActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_game)

        val dice1 = Dice(findViewById(R.id.userDieOne))
        val dice2 = Dice(findViewById(R.id.userDieTwo))
        val dice3 = Dice(findViewById(R.id.userDieThree))
        val dice4 = Dice(findViewById(R.id.userDieFour))
        val dice5 = Dice(findViewById(R.id.userDieFive))

        val userDice = arrayOf(dice1, dice2, dice3, dice4,dice5)

        val compDice1 = Dice(findViewById(R.id.compDieOne))
        val compDice2 = Dice(findViewById(R.id.compDieTwo))
        val compDice3 = Dice(findViewById(R.id.compDieThree))
        val compDice4 = Dice(findViewById(R.id.compDieFour))
        val compDice5= Dice(findViewById(R.id.compDieFive))

        val computerDice = arrayOf(compDice1, compDice2, compDice3, compDice4, compDice5)

        val human: HumanPlayer = HumanPlayer(this)
        val computer: DummyComputerPlayer = DummyComputerPlayer(this)

        //-------------------------------------------------------------------------------------------

        val throwButton: Button = findViewById(R.id.throwBtn)
        throwButton.setOnClickListener {
            if (human.getRolledCount() == 0 && computer.getRolledCount() == 0) {
                human.rollDice(*userDice)
                setListeners(userDice)

                computer.rollDice(*computerDice)
            } else {
                setListeners(userDice)
                human.reRoll(userDice)

                if (computer.chooseReRoll()) {
                    computer.reRoll(computerDice)
                }
            }
        }

        val scoreButton: Button = findViewById(R.id.scoreBtn)

        scoreButton.setOnClickListener {
            if (computer.chooseReRoll()) {
                computer.reRoll(computerDice)
            }

            human.setRolledCount(0)
            computer.setRolledCount(0)

            for(n in userDice){
                n.resetAppearance()
            }
                //ENABLE DISABLE THE THROW BUTTON
            updateScore(human.calculateScore(userDice),
                computer.calculateScore(computerDice))

        }
    }

    private fun updateScore(userScore: Int, compScore: Int){
        val score = findViewById<TextView>(R.id.liveScore)

        val scoreText = score.text.toString()
        val divideScores: Array<String>?

        if(scoreText.contains("/")){
            //https://stackoverflow.com/questions/8517730/how-to-get-text-from-textview

            divideScores = scoreText.split("/").toTypedArray()
            println(divideScores[0] +" " +divideScores[1])

            println("user Score: $userScore comp score: $compScore" )
            val newUserScore = divideScores[0].toInt() + userScore
            val newCompScore = divideScores[1].toInt() + compScore

            val result = "$newUserScore/$newCompScore"

            score.text = result
        }
    }

    private fun setListeners(array: Array<Dice>){
        var imageView: ImageView?

        for (die in array){
            imageView = die.getImageResource()
            imageView.setOnClickListener{
                die.setClicked(true)
                setAppearance(die)
            }
        }
    }

    private fun setAppearance(die: Dice){
        //set mouse click appearance pass the relevant image views only
        val imageView: ImageView?

        imageView = die.getImageResource()
        if (imageView.paddingLeft == 0) {
            die.setAppearance()
        } else {
            die.resetAppearance()
        }
    }


}