import kotlin.random.Random

enum class Script(val shortHandScript: String) {
    move("Your Move"),
    turn("Now my turn....hmm"),
    moveMe("ok I'm moving")
}

class ConnectFour {
    var board = arrayOf<Array<Int>>()
    var opponantX : Int = Random.nextInt(0, 5)
    var opponantY : Int = Random.nextInt(0, 6)
    var playerX : Int = 0
    var playerY : Int = 0

    fun play() {
        setup()
        game()
    }

    fun game() {
        player()
        opponant()
        player()
        opponant()
        player()
        opponant()
    }

    fun setup() {
        for (i in 0..5) {
            var array = arrayOf<Int>()
            for (j in 0..6) {
                array += 0
            }
            board += array
        }
        printBoard()
    }

    fun printBoard() {
        for (array in board) {
            for (value in array) {
                print("$value ")
            }
            println()
        }
    }

    fun player() {
        println(Script.move.shortHandScript)
        playerX = Integer.valueOf(readLine())
        playerY = Integer.valueOf(readLine())
        board[playerX][playerY] = 1
        printBoard()
        checkWinner(playerX, playerY)
    }

    fun checkWinner(xValue: Int, yValue: Int): Boolean{
        if(checkHorizontal(xValue, yValue)){

        } else if (checkDiagonal(xValue, yValue)) {

        } else if(checkVertical(xValue, yValue)) {

        } else {

        }
        return false
    }

    fun checkHorizontal(xValue: Int, yValue: Int) : Boolean{
        return false
    }

    fun checkDiagonal(xValue: Int, yValue: Int) : Boolean{
        return false
    }

    fun checkVertical(xValue: Int, yValue: Int) : Boolean{
        return false
    }

    fun opponant() {
        println(Script.turn.shortHandScript)
        Thread.sleep(5_000)
        println(Script.moveMe.shortHandScript)
        Thread.sleep(1_000)
        if(board.contains(2)) {
            board[opponantX+1][opponantY]
        } else {
            board[opponantX][opponantY] = 2
        }

        printBoard()
        checkWinner(opponantX, opponantY)
    }
}

fun main(args: Array<String>) {
    var connectFour = ConnectFour()
    connectFour.play()
}