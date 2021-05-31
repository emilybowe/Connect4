import java.util.*
import kotlin.random.Random

fun main(args: Array<String>) {
    var testList : MutableList<Int> = mutableListOf<Int>()
    testList.add(0, 0)
    testList.add(1, 0)

    var connectFour = ConnectFour()
    connectFour.playConnectFour(testList)

}

enum class Script(val shortHandScript: String) {
    Move("Your Move"),
    Turn("Now my turn....hmm"),
    MoveMe("ok I'm moving")
}

class ConnectFour {
    var board = arrayOf<Array<Int>>()
    var playersCounter = 1
    var opponentsCounter = 2
    var xValue : Int = 0
    var yValue : Int = 0
    var xMax : Int = 5
    var yMax : Int = 6

    fun playConnectFour(playerMoveList : MutableList<Int> = mutableListOf<Int>()) {
        setup(playerMoveList)
        play(playerMoveList)
    }

    fun setup(playerMoveList : MutableList<Int> = mutableListOf<Int>()) {
        setupBoard()
    }

    fun setupBoard(){
        buildBoard()
        printBoard()
    }

    fun buildBoard() {
        for (i in 0..5) {
            var array = arrayOf<Int>()
            for (j in 0..6) {
                array += 0
            }
            board += array
        }
    }

    fun printBoard() {
        for (array in board) {
            for (value in array) {
                print("$value ")
            }
            println()
        }
    }

    fun play(playerMoveList : MutableList<Int> = mutableListOf<Int>()) {
        while (true) {
            setupPlayerMoves(playerMoveList)
            setupOpponentMoves()
            useAndRemovePlayerMove()
            useAndRemoveOpponentMove()

            if() {
                break
            }
        }

    }

    fun checkForWinner() {

    }

    fun setupPlayerMoves(playerMoveList : MutableList<Int> = mutableListOf<Int>()) {
        getNextMoveForPlayer(playerMoveList)
        addPlayerMoveToList(xValue, yValue, playerMoveList)
    }

    fun setupOpponentMoves(opponentMoveList : MutableList<Int> = mutableListOf<Int>()) {
        getNextMoveForOpponent(opponentMoveList)
        addOpponentMoveToList(xValue, yValue, opponentMoveList)
    }

    fun getNextMoveForPlayer(playerMoveList : MutableList<Int> = mutableListOf<Int>()) {
        if(playerMoveList.isEmpty()) {
            xValue = Integer.valueOf(readLine())
            yValue = Integer.valueOf(readLine())
            addPlayerMoveToList(xValue, yValue)
        }
    }

    fun getNextMoveForOpponent(opponentMoveList : MutableList<Int> = mutableListOf<Int>()) {
        if(opponentMoveList.isEmpty()) {
            xValue = generateRandomXValue()
            yValue = generateRandomYValue()
            addOpponentMoveToList(xValue, yValue)
        }
    }

    fun addPlayerMoveToList(xValue: Int, yValue: Int, playerMoveList: MutableList<Int> = mutableListOf<Int>()) {
        playerMoveList.add(xValue)
        playerMoveList.add(yValue)
    }

    fun addOpponentMoveToList(xValue: Int, yValue: Int, opponentMoveList: MutableList<Int> = mutableListOf<Int>()) {
        opponentMoveList.add(xValue)
        opponentMoveList.add(yValue)
    }

    fun useAndRemovePlayerMove(playerMoveList : MutableList<Int> = mutableListOf<Int>()) {
        useMoveOnPlayerList(playerMoveList)
        removePlayerMoveThatHasBeenUsed(playerMoveList)
    }

    fun useAndRemoveOpponentMove(opponentMoveList : MutableList<Int> = mutableListOf<Int>()) {
        useMoveOnOpponentList(opponentMoveList)
        removeOpponentMoveThatHasBeenUsed(opponentMoveList)
    }

    fun useMoveOnPlayerList(playerMoveList : MutableList<Int> = mutableListOf<Int>()) {
        if(isThisBoardPositionAlreadyTaken(playerMoveList[0], playerMoveList[1])) {
            board[generateRandomXValue()][generateRandomYValue()] = playersCounter
        } else {
            board[playerMoveList[0]][playerMoveList[1]] = playersCounter
        }

    }

    fun useMoveOnOpponentList(opponentMoveList : MutableList<Int> = mutableListOf<Int>()) {
        if(isThisBoardPositionAlreadyTaken(opponentMoveList[0], opponentMoveList[1])) {
            board[generateRandomXValue()][generateRandomYValue()] = opponentsCounter
        } else {
            board[opponentMoveList[0]][opponentMoveList[1]] = opponentsCounter
        }

    }

    fun isThisBoardPositionAlreadyTaken(x: Int, y: Int) : Boolean{
        return board[x][y] != 0
    }

    fun generateRandomXValue(): Int {
        return Random.nextInt(0, xMax)
    }

    fun generateRandomYValue(): Int {
        return Random.nextInt(0, yMax)
    }

    fun removePlayerMoveThatHasBeenUsed(playerMoveList : MutableList<Int> = mutableListOf<Int>()) {
        if(playerMoveList.isNotEmpty()) {
            playerMoveList.remove(0)
            playerMoveList.remove(1)
        }
    }

    fun removeOpponentMoveThatHasBeenUsed(opponentMoveList : MutableList<Int> = mutableListOf<Int>()) {
        if(opponentMoveList.isNotEmpty()) {
            opponentMoveList.remove(0)
            opponentMoveList.remove(1)
        }
    }
}

