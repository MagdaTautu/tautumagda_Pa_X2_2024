package com.example.laborator6;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import com.example.laborator6.Stone;
import com.example.laborator6.Player;
import java.io.Serializable;
import java.util.Random;

public class PositionalGameGUI {

    private BorderPane root; // Rădăcina layout-ului pentru interfața grafică
    private int numLines = 5; // Numărul de linii ale tabelei de joc
    private int numColumns = 5; // Numărul de coloane ale tabelei de joc
    private Canvas canvas; // Obiectul canvas pentru desenarea elementelor grafice
    private Player currentPlayer; // Jucătorul curent
    /**
     * Constructor pentru inițializarea interfeței grafice a jocului.
     */
    public PositionalGameGUI() {
        // Inițializarea rădăcinii layout-ului
        root = new BorderPane();
        root.setPadding(new Insets(10));
        // Inițializarea jucătorului curent cu culoarea roșie
        currentPlayer = new Player(Player.StoneColor.RED);

        // Configurarea panoului de setări
        HBox configPanel = new HBox(10);
        configPanel.setPadding(new Insets(5));
        Label numLinesLabel = new Label("Num Lines:");
        TextField numLinesField = new TextField(Integer.toString(numLines));
        Button decrementLinesButton = new Button("▼");
        decrementLinesButton.setOnAction(e -> {
            numLines = Math.max(1, numLines - 1);
            numLinesField.setText(Integer.toString(numLines));
            drawBoard();
        });
        Button incrementLinesButton = new Button("▲");
        incrementLinesButton.setOnAction(e -> {
            numLines++;
            numLinesField.setText(Integer.toString(numLines));
            drawBoard();
        });
        Label numColumnsLabel = new Label("Num Columns:");
        TextField numColumnsField = new TextField(Integer.toString(numColumns));
        Button decrementColumnsButton = new Button("▼");
        decrementColumnsButton.setOnAction(e -> {
            numColumns = Math.max(1, numColumns - 1);
            numColumnsField.setText(Integer.toString(numColumns));
            drawBoard();
        });
        Button incrementColumnsButton = new Button("▲");
        incrementColumnsButton.setOnAction(e -> {
            numColumns++;
            numColumnsField.setText(Integer.toString(numColumns));
            drawBoard();
        });
        Button newGameButton = new Button("Create");
        newGameButton.setOnAction(e -> {
            numLines = Integer.parseInt(numLinesField.getText());
            numColumns = Integer.parseInt(numColumnsField.getText());
            drawBoard();
        });
        configPanel.getChildren().addAll(numLinesLabel, numLinesField, incrementLinesButton,  decrementLinesButton,
                numColumnsLabel,  numColumnsField, incrementColumnsButton,decrementColumnsButton, newGameButton);
        root.setTop(configPanel);


        canvas = new Canvas(400, 400);
        root.setCenter(canvas);

        // Configurarea panoului de control
        HBox controlPanel = new HBox(10);
        controlPanel.setPadding(new Insets(5));
        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");
        Button exitButton = new Button("Exit");
        controlPanel.getChildren().addAll(loadButton, saveButton, exitButton);
        exitButton.setOnAction(event -> Platform.exit());

        root.setBottom(controlPanel);

        // Inițializarea tablei de joc și gestionarea evenimentului de click al mouse-ului
        drawBoard();
        canvas.setOnMousePressed(event -> handleMousePressed(event));
    }
    private boolean isValidIntersection(double mouseX, double mouseY, int row, int column, double cellWidth, double cellHeight) {
        double cellCornerX = column * cellWidth;
        double cellCornerY = row * cellHeight;

        return (mouseX >= cellCornerX && mouseX <= cellCornerX + cellWidth &&
                mouseY >= cellCornerY && mouseY <= cellCornerY + cellHeight);
    }
    /**
     * Metodă pentru obținerea rădăcinii layout-ului.
     * @return Rădăcina layout-ului
     */
    public BorderPane getRoot() {
        return root;
    }
    /**
     * Metodă pentru desenarea tablei de joc cu liniile grilă.
     */
    private void drawBoard() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double cellWidth = canvas.getWidth() / numColumns;
        double cellHeight = canvas.getHeight() / numLines;


        gc.setStroke(Color.BLACK);
        for (int i = 0; i <= numColumns; i++) {
            double x = i * cellWidth;
            gc.strokeLine(x, 0, x, canvas.getHeight());
        }
        for (int j = 0; j <= numLines; j++) {
            double y = j * cellHeight;
            gc.strokeLine(0, y, canvas.getWidth(), y); // Horizontal lines
        }
    }


    /**
     * Metodă pentru gestionarea evenimentului de click al mouse-ului.
     * @param event Evenimentul de click al mouse-ului
     */
    private void handleMousePressed(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();


        double cellWidth = canvas.getWidth() / numColumns;
        double cellHeight = canvas.getHeight() / numLines;


        int column = (int) (mouseX / cellWidth);
        int row = (int) (mouseY / cellHeight);


        double intersectionX = column * cellWidth;
        double intersectionY = row * cellHeight;


        double range = 20;


        if (mouseX >= intersectionX - range && mouseX <= intersectionX + range &&
                mouseY >= intersectionY - range && mouseY <= intersectionY + range) {
            // If within range, use intersection coordinates for drawing
            mouseX = intersectionX;
            mouseY = intersectionY;
        }


        if (isValidIntersection(mouseX, mouseY, row, column, cellWidth, cellHeight)) {
            drawStone(row, column);
        }
    }
    /**
     * Metodă pentru desenarea unei piese la colțul unei celule.
     * @param row Indicele rândului celulei.
     * @param column Indicele coloanei celulei.
     */
    private void drawStone(int row, int column) {
        GraphicsContext gc = canvas.getGraphicsContext2D();


        double cellWidth = canvas.getWidth() / numColumns;
        double cellHeight = canvas.getHeight() / numLines;
        double centerX = column * cellWidth;
        double centerY = row * cellHeight;


        if (currentPlayer.getColor() == Player.StoneColor.RED) {
            gc.setFill(Color.RED); // Set fill color to red
        } else {
            gc.setFill(Color.BLUE);
        }


        double radius = Math.min(cellWidth, cellHeight) / 2;
        gc.fillOval(centerX - radius/2, centerY - radius /2, radius, radius);


        currentPlayer.setColor((currentPlayer.getColor() == Player.StoneColor.RED) ? Player.StoneColor.BLUE : Player.StoneColor.RED);
    }
    /**
     * Metodă pentru desenarea unui număr aleatoriu de "bățuri" (sticle) între celule.
     */
    void drawRandomSticks() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Random random = new Random();

        double cellWidth = canvas.getWidth() / numColumns;
        double cellHeight = canvas.getHeight() / numLines;


        int numSticks = random.nextInt(20) + 5;
        for (int i = 0; i < numSticks; i++) {
            int startX, startY, endX, endY;

            boolean isHorizontal = random.nextBoolean();

            if (isHorizontal) {
                startX = random.nextInt(numColumns - 1);
                startY = random.nextInt(numLines);
                endX = startX + 1;
                endY = startY;
            } else {
                startX = random.nextInt(numColumns);
                startY = random.nextInt(numLines - 1);
                endX = startX;
                endY = startY + 1;
            }


            drawStick(gc, startX, startY, endX, endY, cellWidth, cellHeight);
        }
    }
    /**
     * Desenează un "băț" între două puncte date.
     *
     * @param gc         Contextul grafic în care să se deseneze bățul.
     * @param startX     Coordonata x a începutului bățului.
     * @param startY     Coordonata y a începutului bățului.
     * @param endX       Coordonata x a sfârșitului bățului.
     * @param endY       Coordonata y a sfârșitului bățului.
     * @param cellWidth  Lățimea celulei în care se desenează bățul.
     * @param cellHeight Înălțimea celulei în care se desenează bățul.
     */
    private void drawStick(GraphicsContext gc, int startX, int startY, int endX, int endY, double cellWidth, double cellHeight) {
        // Calcularea coordonatelor exacte ale începutului și sfârșitului bățului
        double startXCoord = startX * cellWidth + cellWidth;
        double startYCoord = startY * cellHeight + cellHeight;
        double endXCoord = endX * cellWidth + cellWidth;
        double endYCoord = endY * cellHeight + cellHeight;

        // Setarea grosimii liniei și desenarea liniei între punctele date
        gc.setLineWidth(3);
        gc.strokeLine(startXCoord, startYCoord, endXCoord, endYCoord);
    }

}