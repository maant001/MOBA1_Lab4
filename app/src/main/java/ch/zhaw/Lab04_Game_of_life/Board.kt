package ch.zhaw.Lab04_Game_of_life

class Board constructor(var rows: Int, var columns: Int) {
    private var boardLayout = Array(rows) {Array(columns) {Cell()} }

    fun calculateNextGen(boardLayout : Array<Array<Cell>>, rows: Int, columns: Int ) {
        val futureGen = Array(rows) {Array(columns) {Cell()} }

        for (i in 0 until rows) {
            for (j in 0 until columns) {
                
            }
        }
    }
}