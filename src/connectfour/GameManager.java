package connectfour;

import java.util.Locale;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;

/**
 * The Class GameManager.
 */
public class GameManager {
    private static final int[][] DIRECTIONS =
            {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private static final int DEFAULT_COLUMN_AMOUNT = 7;
    private static final int DEFAULT_ROW_AMOUNT = 6;
    private static final int DEFAULT_ALIGNED_TOKEN = 4;
    private final Scanner reader;
    private final Logger logger = Logger.getLogger("connectfour.logger");
    private Grid grid;
    private final Player[] players;
    private int turnCount;
    private int lastColumnChoosed;

    /**
     * Instantiates a new game manager.
     */
    public GameManager() {
        this.reader = new Scanner(System.in, "UTF-8");
        this.setGrid(new Grid(GameManager.DEFAULT_COLUMN_AMOUNT, GameManager.DEFAULT_ROW_AMOUNT));
        this.players = new Player[2];

        final Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);
        handler.setFormatter(new SimpleFormatter() {

            @Override
            public synchronized String format(LogRecord lr) {
                return lr.getMessage() + "\r\n";
            }
        });

        this.logger.addHandler(handler);
        this.logger.setLevel(Level.FINE);
        this.logger.fine("\u001B[37m");

    }

    /**
     * Inits the game.
     */
    public void initGame() {
        this.setPlayers();
    }

    /**
     * Sets the grid.
     *
     * @param grid the new grid
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * Sets the players.
     */
    public void setPlayers() {
        String msg = "";
        for (int index = 1; index < 3; index++) {
            msg = String.format("Choose a name for player %d :", index);
            this.logger.fine(msg);
            final String playerName = this.manageTextEntry();
            msg = String.format("Choose a symbol for player %d : ", index);
            this.logger.fine(msg);
            final char playerSymbol = this.manageTextEntry().charAt(0);
            msg = String.format("The player -%s- has the symbol \"%s\" %n", playerName,
                    playerSymbol);
            this.logger.fine(msg);
            this.createPlayer(playerName, playerSymbol);
        }
    }

    private String manageTextEntry() {
        String text = this.reader.nextLine();
        while (!Pattern.matches("[a-zA-Z0-9]*", text) || text.length() == 0) {
            this.logger.fine("Missing or incorrect text. Try Again.");
            text = this.reader.nextLine();
        }
        return text;
    }

    /**
     * Creates the player.
     *
     * @param username the username
     * @param symbol the symbol
     */
    public void createPlayer(String username, char symbol) {
        if (this.getPlayerByIndex(0) == null) {
            this.players[0] = new Player(username, symbol);
        } else if (this.getPlayerByIndex(1) == null) {
            this.players[1] = new Player(username, symbol);
        } else {
            this.logger.fine("Two players already exists");
        }
    }

    /**
     * Play game.
     */
    public void playGame() {
        Player actualPlayer = this.getPlayerByIndex(0);
        this.displayGrid();
        while (!this.hasWon(actualPlayer) && !this.getGrid().isFull()) {
            actualPlayer = this.getPlayerByIndex(this.getTurnCount() % 2);
            this.logger.fine(
                    "It's the turn of " + actualPlayer.getName() + "\nChoose a column number : ");
            this.setLastColumnChoosed(this.manageColumnChoosed() - 1);
            while (this.getGrid().getColumn(this.getLastColumnChoosed()).isFull()) {
                this.logger.fine("This column is full. Please choose another.");
                this.setLastColumnChoosed(this.manageColumnChoosed() - 1);
            }
            this.getGrid().addToken(this.getLastColumnChoosed(), actualPlayer);
            this.displayGrid();
            this.incrementTurnCount();
        }
        if (this.getGrid().isFull()) {
            this.logger.fine("Grid is full");
        } else {
            this.displayVictory();
        }
    }

    private int manageColumnChoosed() {
        int columnChoosed = -1;
        while (columnChoosed < 0) {
            try {
                columnChoosed = this.reader.nextInt();
                if (columnChoosed > GameManager.DEFAULT_ROW_AMOUNT + 1 || columnChoosed < 1) {
                    this.logger.fine("This column number doesn't exist. Try again:");
                    columnChoosed = -1;
                }
            } catch (final java.util.InputMismatchException e) {
                this.logger.fine("Please enter a correct column number.");
            }

            this.reader.nextLine();
        }
        return columnChoosed;
    }

    /**
     * Gets the last column choosed.
     *
     * @return the last column choosed
     */
    public int getLastColumnChoosed() {
        return this.lastColumnChoosed;
    }

    /**
     * Sets the last column choosed.
     *
     * @param lastColumnChoosed the new last column choosed
     */
    public void setLastColumnChoosed(int lastColumnChoosed) {
        this.lastColumnChoosed = lastColumnChoosed;
    }

    /**
     * Gets the turn count.
     *
     * @return the turn count
     */
    public int getTurnCount() {
        return this.turnCount;
    }

    /**
     * Increment turn count.
     */
    public void incrementTurnCount() {
        this.turnCount += 1;
    }

    /**
     * Gets the grid.
     *
     * @return the grid
     */
    public Grid getGrid() {
        return this.grid;
    }

    /**
     * Gets the player by index.
     *
     * @param index the index
     * @return the player by index
     */
    public Player getPlayerByIndex(int index) {
        return this.players[index];
    }

    /**
     * Checks for won.
     *
     * @param player the player
     * @return true, if successful
     */
    public boolean hasWon(Player player) {
        final int row =
                (this.getGrid().getColumn(this.getLastColumnChoosed()).getIndexEmptyTile() == 0) ? 0
                        : this.getGrid().getColumn(this.getLastColumnChoosed()).getIndexEmptyTile()
                                - 1;

        int alignedTokenCounter = 1;
        for (final int[] direction : GameManager.DIRECTIONS) {
            if (!this.isOutOfBound(this.getLastColumnChoosed(), row, direction[0] * 3,
                    direction[1] * 3)) {
                for (int index = 1; index < 4; index++) {
                    if (this.getGrid().getPlayerFromTile(
                            this.getLastColumnChoosed() + direction[0] * index,
                            row + direction[1] * index) == player) {
                        alignedTokenCounter++;
                    } else {
                        alignedTokenCounter = 1;
                        break;
                    }
                }

                if (alignedTokenCounter == GameManager.DEFAULT_ALIGNED_TOKEN) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if is out of bound.
     *
     * @param x the x
     * @param y the y
     * @param vx the vx
     * @param vy the vy
     * @return true, if is out of bound
     */
    public boolean isOutOfBound(int x, int y, int vx, int vy) {
        return x + vx < 0 || x + vx > GameManager.DEFAULT_COLUMN_AMOUNT - 1 || y + vy < 0
                || y + vy > GameManager.DEFAULT_ROW_AMOUNT - 1;
    }

    /**
     * Display grid.
     */
    public void displayGrid() {
        final char[][] table = new char[GameManager.DEFAULT_ROW_AMOUNT * 2
                + 1][GameManager.DEFAULT_COLUMN_AMOUNT * 2 + 2];

        for (int indexColumn = 0; indexColumn < GameManager.DEFAULT_COLUMN_AMOUNT * 2
                + 1; indexColumn++) {
            if (indexColumn % 2 == 0) {
                for (int indexRow = GameManager.DEFAULT_ROW_AMOUNT * 2; indexRow > 0; indexRow--) {
                    table[indexRow][indexColumn] = '|';
                }
            } else {
                final StringBuilder builder = new StringBuilder();
                builder.append(Integer.toString(indexColumn / 2 + 1));
                builder.append(String.join("—",
                        this.getGrid().getColumn(indexColumn / 2).toString().split("")));
                builder.append('—');

                final String column = builder.toString();

                for (int indexRow = 0; indexRow <= GameManager.DEFAULT_ROW_AMOUNT * 2; indexRow++) {
                    table[indexRow][indexColumn] = column.charAt(indexRow);
                }
            }

        }

        for (int index = 0; index < table.length / 2; index++) {
            final char[] temp = table[index];
            table[index] = table[table.length - index - 1];
            table[table.length - index - 1] = temp;
        }

        String msg = "";
        for (final char[] line : table) {
            msg = new String(line);
            this.logger.fine(msg);
        }
    }

    /**
     * Display victory.
     */
    public void displayVictory() {
        String msg = String.format("%nAND THE WINNER IS %s",
                this.getPlayerByIndex((this.getTurnCount() - 1) % 2).getName()
                        .toUpperCase(Locale.getDefault()));
        this.logger.fine(msg);
        msg = String.format("Number of turns : %d", this.getTurnCount());
        this.logger.fine(msg);
    }
}
