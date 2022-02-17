package com.quanticheart.ticTacToe.domain.models

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private lateinit var game: Game
    private var player1: Player? = null
    private var player2: Player? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("red", "green")
        player1 = game.player1
        player2 = game.player2
    }

    @Test
    fun `True If Has Three Same Horizontal Cell At Row 1`() {
        //Cenario
        val cell = Cell(player1)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        //Ação
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        //Resultado
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun `True If Has Three Same Horizontal Cell At Row 2`() {
        //Cenario
        val cell = Cell(player1)
        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell
        //Ação
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        //Resultado
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun `True If Has Three Same Horizontal Cell At Row 3`() {
        //Cenario
        val cell = Cell(player1)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell
        //Ação
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        //Resultado
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun `False If Does Not Have Three Same Horizontal Cells`() {
        val cell = Cell(player1)
        val anotherCell = Cell(player2)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = anotherCell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertFalse(hasThreeSameHorizontalCells)
    }

    @Test
    fun `True If Has Three Same Vertical Cell At Row 1`() {
        //Cenario
        val cell = Cell(player1)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        //Ação
        val hasThreeSameHorizontalCells = game.hasThreeSameVerticalCells()
        //Resultado
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun `True If Has Three Same Vertical Cell At Row 2`() {
        //Cenario
        val cell = Cell(player1)
        game.cells[0][1] = cell
        game.cells[1][1] = cell
        game.cells[2][1] = cell
        //Ação
        val hasThreeSameHorizontalCells = game.hasThreeSameVerticalCells()
        //Resultado
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun `True If Has Three Same Vertical Cell At Row 3`() {
        //Cenario
        val cell = Cell(player1)
        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = cell
        //Ação
        val hasThreeSameHorizontalCells = game.hasThreeSameVerticalCells()
        //Resultado
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun `False If Does Not Have Three Same Vertical Cells`() {
        val cell = Cell(player1)
        val anotherCell = Cell(player2)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = anotherCell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertFalse(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun `True If Has Three Same Diagonal Cells From Left`() {
        val cell = Cell(player1)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasThreeSameDiagonalCells =
            game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun `False If Does Not Have Three Same Diagonal Cells From Left`() {
        val cell = Cell(player1)
        val anotherCell = Cell(player2)

        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = anotherCell

        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertFalse(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun `True If Has Three Same Diagonal Cells From Right`() {
        val cell = Cell(player1)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun `False If Does Not Have Three Same Diagonal Cells From Right`() {
        val cell = Cell(player1)
        val anotherCell = Cell(player2)

        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = anotherCell

        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertFalse(hasThreeSameDiagonalCells)
    }

    @Test
    fun `End Game If Has Three Same Horizontal Cells`() {
        val cell = Cell(player1)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    fun `End Game If Has Three Same Vertical Cells`() {
        val cell = Cell(player1)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    fun `End Game If Has Three Same Diagonal Cells`() {
        val cell = Cell(player1)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    fun `End Game If Board Is Full`() {
        val cell1 = Cell(player1)
        val cell2 = Cell(player1)
        val cell3 = Cell(player2)
        val cell4 = Cell(player2)
        val cell5 = Cell(player1)
        val cell6 = Cell(player1)
        val cell7 = Cell(player1)
        val cell8 = Cell(player2)
        val cell9 = Cell(player2)
        game.cells[0][0] = cell1
        game.cells[0][1] = cell2
        game.cells[0][2] = cell3
        game.cells[1][0] = cell4
        game.cells[1][1] = cell5
        game.cells[1][2] = cell6
        game.cells[2][0] = cell7
        game.cells[2][1] = cell8
        game.cells[2][2] = cell9
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }
}