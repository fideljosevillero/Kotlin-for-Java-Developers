package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var thisRightPosition = 0
    var thisWrongPosition = 0
    // evaluate all rightPosition
    if(secret.contentEquals(guess))
        return Evaluation(4, 0)

    val secretListChar = secret.toCharArray()
    val guessListChar = guess.toCharArray()

    val arr1 = arrayOf(1, 2, 3)

    // evaluate and count rightPosition
    for(index in secretListChar.indices){
        if(secretListChar[index].equals(guessListChar[index])){
            thisRightPosition++
            secretListChar[index] = '*'
            guessListChar[index] = '*'
        }
    }

    for(i in secretListChar.indices){
        if(secretListChar[i] == '*') continue
        for(j in guessListChar.indices) {
            //println("comparando..." + secretListChar[i] + " con " + guessListChar[j])
            if (secretListChar[i].equals(guessListChar[j])) {
                guessListChar[j] = '*'
                    thisWrongPosition++
                    //println("thisWrongPosition -> $thisWrongPosition")
                break
            }
        }

    }

    return Evaluation(thisRightPosition,thisWrongPosition)
}
