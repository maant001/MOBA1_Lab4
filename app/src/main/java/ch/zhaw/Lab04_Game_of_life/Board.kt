package ch.zhaw.Lab04_Game_of_life

class Board constructor(var rows: Int, var columns: Int) {
    private var boardLayout = Array(rows) {Array(columns) {Cell()} }

    fun calculateNextGen(boardLayout : Array<Array<Cell>>, rows: Int, columns: Int ) {
        val futureGen = Array(rows) {Array(columns) {Cell()} }

        for (l in 0 until rows) {
            for (m in 0 until columns) {
                var aliveNeighbours = checkAliveNeighbours(rows, columns) - boardLayout[l][m].state
                if ((boardLayout[l][m].state == 1) && (aliveNeighbours < 2)) {
                    
                }

            }
        }
    }

    fun checkAliveNeighbours(l: Int, m: Int): Int {
        var aliveNeighbours = 0
        // checking neighbouring cells
        aliveNeighbours += checkNeighbouringCell(l - 1, m - 1)
        aliveNeighbours += checkNeighbouringCell(l - 1, m)
        aliveNeighbours += checkNeighbouringCell(l - 1, m + 1)
        aliveNeighbours += checkNeighbouringCell(l, m - 1)
        aliveNeighbours += checkNeighbouringCell(l, m + 1)
        aliveNeighbours += checkNeighbouringCell(l + 1, m - 1)
        aliveNeighbours += checkNeighbouringCell(l + 1, m)
        aliveNeighbours += checkNeighbouringCell(l + 1, m + 1)

        return aliveNeighbours
    }

    fun checkNeighbouringCell(row: Int, column: Int) : Int {
        // check board out of bounds
        if (row < 0 || column < 0) {
            return 0
        }
        if (row >= rows || column >= columns) {
            return 0
        }

        // check state of niegh cell
        if (boardLayout[row][column].state == 1) {
            return 1
        } else {
            return 0
        }
    }

}