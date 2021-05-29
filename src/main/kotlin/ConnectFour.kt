import kotlin.random.Random

enum class Script() {

}

class ConnectFour {
    var board = arrayOf<Array<Int>>()
    var opponantX : Int = Random.nextInt(0, 5)
    var opponantY : Int = Random.nextInt(0, 6)
    var playerX = Integer.valueOf(readLine())
    var playerY = Integer.valueOf(readLine())



    fun play() {
        setup()
        do {
            game()
            if()
        } while ()

    }

    fun game() {
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
        println("Your move")
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

    }

    fun checkHorizontal(xValue: Int, yValue: Int) : Boolean{

    }

    fun checkDiagonal(xValue: Int, yValue: Int) : Boolean{

    }

    fun checkVertical(xValue: Int, yValue: Int) : Boolean{

    }

    fun opponant() {
        println()
        println("Now my turn....hmm")
        println()
        Thread.sleep(5_000)
        println("ok I'm moving")
        Thread.sleep(1_000)
        board[opponantX][opponantY] = 2
        printBoard()
        checkWinner(opponantX, opponantY)
    }
}

fun main(args: Array<String>) {
    var connectFour = ConnectFour()
    connectFour.play()
}