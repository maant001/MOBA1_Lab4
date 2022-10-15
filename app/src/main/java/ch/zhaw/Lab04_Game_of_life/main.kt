package ch.zhaw.Lab04_Game_of_life

fun main (args: Array<String>) {
    var rows = 7
    var columns = 7

    var board = Board(rows, columns)

    println("Original State:")
    for (i in 0 until board.rows) {
        for (j in 0 until board.columns) {
            if (board.getBoard()[i][j].state == 1) {
                print("1")
            } else {
                print("0")
            }
            Thread.sleep(150)
        }
        println()
    }

    println("Next State:")
    var futureBoard = board.calculateNextGen(board.getBoard(), rows, columns)
    for (i in futureBoard.indices) {
        for (j in 0 until futureBoard[i].size) {
            if (futureBoard[i][j].state == 1) {
                print("1")
            } else {
                print("0")
            }
            Thread.sleep(150)
        }
        println()
    }


}