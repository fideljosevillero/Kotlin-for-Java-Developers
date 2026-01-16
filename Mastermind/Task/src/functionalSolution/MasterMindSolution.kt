package functionalSolution

class MasterMindSolution {

    data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

    fun evaluateGuess(secret: String, guess: String): Evaluation {

        val rightPositions = secret.zip(guess).count { it.first == it.second }

        val commonLetters = "ABCDEF".sumBy { ch ->

            Math.min(secret.count { ch == it }, guess.count { ch == it })
        }
        return Evaluation(rightPositions, commonLetters - rightPositions)
    }

    fun main(args: Array<String>) {
        val result = Evaluation(rightPosition = 1, wrongPosition = 1)
        evaluateGuess("BCDF", "ACEB") == result
        evaluateGuess("AAAF", "ABCA") == result
        evaluateGuess("ABCA", "AAAF") == result
    }

}