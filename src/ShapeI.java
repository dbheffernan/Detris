

import java.awt.*;

public class ShapeI extends Tetromino {
        public static final int rotationStep = 0;
        public static final int rotationStepMax = 1;
        public static final int[][][] grid2 = {{{1,1,1,1},
                                                {0,0,0,0},
                                                {0,0,0,0},
                                                {0,0,0,0}},
                
                                               {{1,0,0,0},
                                                {1,0,0,0},
                                                {1,0,0,0},
                                                {1,0,0,0}}};
                                    
        public static final int startX = 100;
        public static final int startY = 3;
        public static final int clear_right = 4;
        public static final int clear_left = 0;
        public static final int color = 2;
        public static final Color display = Color.CYAN;

        public ShapeI() {
            super(rotationStep, rotationStepMax, grid2, startX, startY,color, display, clear_right, clear_left);
            }
        
}