import kotlin.random.Random

class ConnectFour {
    var board = arrayOf<Array<Int>>()


    fun play() {
        program()
        driver()
        opponant()
    }

    fun program() {

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

    fun driver() {
        println("Your move")
        var Xinput = Integer.valueOf(readLine())
        var Yinput = Integer.valueOf(readLine())
        board[Xinput][Yinput] = 1
        printBoard()
    }

    fun opponant() {
        println()
        println("Now my turn....hmm")
        Thread.sleep(5_000)
        println("ok I'm moving")
        board[Random.nextInt(0, 5)][Random.nextInt(0, 6)] = 1
        printBoard()
    }
}

fun main(args: Array<String>) {
    var connectFour = ConnectFour()
    connectFour.play()
}