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

    fun playConnectFour(moveList : MutableList<Int> = mutableListOf<Int>()) {
        setup(moveList)
        play(moveList)
    }

    fun setup(moveList : MutableList<Int> = mutableListOf<Int>()) {
        setupBoard()
        setupPlayerMoves(moveList)
        setupOpponentMoves()
    }

    fun play(moveList : MutableList<Int> = mutableListOf<Int>()) {
        usePlayerMove()
    }

    fun setupBoard(){
        buildBoard()
        printBoard()
    }

    fun setupPlayerMoves(moveList : MutableList<Int> = mutableListOf<Int>()) {
        getNextMoveForPlayer(moveList)
        addPlayerMoveToList(xValue, yValue, moveList)
    }

    fun usePlayerMove() {
        useMoveOnPlayerList()
        removePlayerMoveThatHasBeenUsed()
    }

    fun setupOpponentMoves() {
        generateOpponentMove()
        //var opponentX : Int = Random.nextInt(0, 5)
        //var opponentY : Int = Random.nextInt(0, 6)
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

    fun getNextMoveForPlayer(moveList : MutableList<Int> = mutableListOf<Int>()) {
        if(moveList.isEmpty()) {
            xValue = Integer.valueOf(readLine())
            yValue = Integer.valueOf(readLine())
            addPlayerMoveToList(xValue, yValue)
        }
    }

    fun addPlayerMoveToList(xValue: Int, yValue: Int, moveList: MutableList<Int> = mutableListOf<Int>()) {
        moveList.add(xValue)
        moveList.add(yValue)
    }

    fun useMoveOnPlayerList(moveList : MutableList<Int> = mutableListOf<Int>()) {
        board[moveList[0]][moveList[1]] = playersCounter
    }

    fun removePlayerMoveThatHasBeenUsed(moveList : MutableList<Int> = mutableListOf<Int>()) {
        if(moveList.isNotEmpty()) {
            moveList.remove(0)
            moveList.remove(1)
        }
    }

    fun generateOpponentMove(opponentX: Int, opponentY: Int) {
        board[opponentX][opponentY] = opponentsCounter
    }

}

