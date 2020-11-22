package rybas.utils;

import rybas.models.figures.Figure;
import rybas.models.figures.FigureColor;
import rybas.models.figures.FigureType;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class FxUtils {
    public static LinkedHashMap<FigureType, HashMap<FigureColor, String>> getFigureImages() {
        return new LinkedHashMap<>() {{
            put(FigureType.PAWN, new HashMap<>() {{
                put(FigureColor.WHITE, "file:src/main/java/rybas/models/figures/images/whitePawn.png");
                put(FigureColor.BLACK, "file:src/main/java/rybas/models/figures/images/blackPawn.png");
            }});

            put(FigureType.KNIGHT, new HashMap<>() {{
                put(FigureColor.WHITE, "file:src/main/java/rybas/models/figures/images/whiteKnight.png");
                put(FigureColor.BLACK, "file:src/main/java/rybas/models/figures/images/blackKnight.png");
            }});

            put(FigureType.ROOK, new HashMap<>() {{
                put(FigureColor.WHITE, "file:src/main/java/rybas/models/figures/images/whiteRook.png");
                put(FigureColor.BLACK, "file:src/main/java/rybas/models/figures/images/blackRook.png");
            }});

            put(FigureType.BISHOP, new HashMap<>() {{
                put(FigureColor.WHITE, "file:src/main/java/rybas/models/figures/images/whiteBishop.png");
                put(FigureColor.BLACK, "file:src/main/java/rybas/models/figures/images/blackBishop.png");
            }});

            put(FigureType.KING, new HashMap<>() {{
                put(FigureColor.WHITE, "file:src/main/java/rybas/models/figures/images/whiteKing.png");
                put(FigureColor.BLACK, "file:src/main/java/rybas/models/figures/images/blackKing.png");
            }});

            put(FigureType.QUEEN, new HashMap<>() {{
                put(FigureColor.WHITE, "file:src/main/java/rybas/models/figures/images/whiteQueen.png");
                put(FigureColor.BLACK, "file:src/main/java/rybas/models/figures/images/blackQueen.png");
            }});
        }};
    }
}
