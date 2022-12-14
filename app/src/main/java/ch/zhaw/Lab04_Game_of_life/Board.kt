package ch.zhaw.Lab04_Game_of_life

class Board constructor(var rows: Int, var columns: Int) {
    private var boardLayout = Array(rows) {Array(columns) {Cell()} }

    fun calculateNextGen(boardLayout : Array<Array<Cell>>, rows: Int, columns: Int ): Array<Array<Cell>> {
        val futureGen = Array(rows) {Array(columns) {Cell()} }

        for (l in 0 until rows) {
            for (m in 0 until columns) {

                // TODO needed?
                // subtracting
                //var aliveNeighbours = checkAliveNeighbours(rows, columns) - boardLayout[l][m].state
                var aliveNeighbours = checkAliveNeighbours(l, m)


                // Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                if ((boardLayout[l][m].state == 1) && (aliveNeighbours < 2)) {
                    futureGen[l][m].state = 0
                } else

                // Any live cell with more than three live neighbours dies, as if by overpopulation.
                if ((boardLayout[l][m].state == 1) && (aliveNeighbours > 3)) {
                    futureGen[l][m].state = 0
                } else

                // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                if ((boardLayout[l][m].state == 0) && (aliveNeighbours == 3)) {
                    futureGen[l][m].state == 1
                } else {
                    futureGen[l][m].state = boardLayout[l][m].state
                }

            }
        }
        return futureGen
    }

    private fun checkAliveNeighbours(l: Int, m: Int): Int {
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
        } else
        if (row >= rows || column >= columns) {
            return 0
        } else

        // check state of neigh cell
        if (boardLayout[row][column].state == 1) {
            return 1
        } else {
            return 0
        }
    }

    fun getBoard() : Array<Array<Cell>> {
        return boardLayout
    }

}